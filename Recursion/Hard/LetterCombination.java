/*
 * Q.Given a string consisting of digits from 2 to 9 (inclusive). Return all possible letter combinations that the number can represent.
Mapping of digits to letters is given in first example.
 */

 /*
  * Time Complexity O(4^N * N), where n is the length of the input digits. This is because each digit can map to up to 4 letters and there are n digits.
Space Complexity: O(N), where n is the length of the input digits. This is due to the recursion stack depth.
  */

 class Solution {
    private final String[] map;
    public Solution() {
        // Mapping digits to corresponding characters
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
    // Recursive helper function to generate combinations
    private void helper(String digits, List<String> ans, int index, String current) {
        // Base case: if index reaches the end of digits
        if (index == digits.length()) {
            // Add the current combination to the answer
            ans.add(current);
            return;
        }
        // Get characters corresponding to the current digit
        String s = map[digits.charAt(index) - '0'];
        // Loop through the corresponding characters
        for (int i = 0; i < s.length(); i++) {
            // Recursively call function with next index
            // Add current character to the string
            helper(digits, ans, index + 1, current + s.charAt(i));
        }
    }
}
