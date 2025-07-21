/*
 * 1957. Delete Characters to Make Fancy String
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.
 */


 /*
  * Time Complexity: O(N), where N is the length of the string s. We traverse the string once to build the result.
  * Space Complexity: O(N), for storing the result string in a StringBuilder.
  */



 class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int len = result.length();
            // Check last two characters in result
            if (len >= 2 && result.charAt(len - 1) == s.charAt(i) && result.charAt(len - 2) == s.charAt(i)) {
                continue; // Skip this char to avoid 3 in a row
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
