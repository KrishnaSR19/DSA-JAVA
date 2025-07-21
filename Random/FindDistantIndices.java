/*
 * You are given a 0-indexed integer array nums and two integers key and k. A
 * k-distant index is an index i of nums for which there exists at least one
 * index j such that |i - j| <= k and nums[j] == key.
 * Return a list of all k-distant indices sorted in increasing order.
 */


 /*
  * Time Complexity: O(N), where N is the length of the nums array. We traverse the array once to find k-distant indices.
  * Space Complexity: O(N), for storing the result list of k-distant indices.
  */

  class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> result = new HashSet<>();
        int n = nums.length;

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(n - 1, j + k);
                for (int i = start; i <= end; i++) {
                    result.add(i);
                }
            }
        }

        List<Integer> sortedList = new ArrayList<>(result);
        Collections.sort(sortedList);
        return sortedList;
    }
}
