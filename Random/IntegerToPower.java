/*
 * Q.Given two positive integers n and x.

Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.

Since the result can be very large, return it modulo 109 + 7.

For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.
 */

class Solution {
    static final int MOD = 1_000_000_007;
    Integer[][] memo;

    public int numberOfWays(int n, int x) {
        // Generate all possible powers <= n
        List<Integer> powers = new ArrayList<>();
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            powers.add((int) Math.pow(i, x));
        }

        memo = new Integer[powers.size()][n + 1];
        return dfs(powers, 0, n);
    }

    private int dfs(List<Integer> powers, int idx, int target) {
        if (target == 0)
            return 1; // Found valid combination
        if (idx >= powers.size() || target < 0)
            return 0;

        if (memo[idx][target] != null)
            return memo[idx][target];

        // Option 1: Skip current power
        int ways = dfs(powers, idx + 1, target) % MOD;

        // Option 2: Take current power
        ways = (ways + dfs(powers, idx + 1, target - powers.get(idx))) % MOD;

        return memo[idx][target] = ways;
    }
}
