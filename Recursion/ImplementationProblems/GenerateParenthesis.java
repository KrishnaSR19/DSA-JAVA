/*
 * Generate Parenthesis
 * Given an integer n.Generate all possible combinations of well-formed parentheses of length 2 x N.
 */

/*
 * Time Complexity: O(4^n / sqrt(n)), where n is the number of pairs of parentheses. This complexity arises because each step involves branching into two possibilities, resulting in an exponential number of possibilities, reduced by the Catalan number formula for valid combinations.

Space Complexity: O(4^n / sqrt(n)), primarily due to the recursion stack and the storage required for the result list of valid combinations. The space is proportional to the number of valid combinations generated.
 */

class Solution {

    /**
     * Generates all valid combinations of n pairs of balanced parentheses.
     * 
     * @param n Number of pairs of parentheses
     * @return List of all valid combinations
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result); // Start recursive generation
        return result;
    }

    /**
     * Recursive helper function to generate valid parenthesis combinations.
     * 
     * @param open    Number of opening brackets used so far
     * @param close   Number of closing brackets used so far
     * @param n       Total pairs of parentheses
     * @param current Current string being built
     * @param result  List to store all valid combinations
     */
    private void generate(int open, int close, int n, String current, List<String> result) {
        // Base case: If current string has 2*n characters, it's a valid combination
        if (open == close && open + close == 2 * n) {
            result.add(current);
            return;
        }

        // Add opening bracket if count is less than n
        if (open < n) {
            generate(open + 1, close, n, current + '(', result);
        }

        // Add closing bracket if it does not exceed the number of opening brackets
        if (close < open) {
            generate(open, close + 1, n, current + ')', result);
        }
    }
}
