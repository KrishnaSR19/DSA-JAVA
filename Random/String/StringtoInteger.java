/*LC 8
 * Q.Convert a string to an integer (implement atoi).
 * The function should ignore leading whitespaces, handle optional '+' or '-' signs, and convert the string to an integer. If the conversion results in overflow or underflow, it should return Integer.MAX_VALUE or Integer.MIN_VALUE respectively.
 * Time Complexity: O(n) where n is the length of the string, as we traverse the string once.
 * Space Complexity: O(1) since we are using a constant amount of space for variables
 * Note: The function should handle cases like "   -42", "419 with words", and "words and 987" correctly.
 * 
 */




 class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1, result = 0;

        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle optional '+' or '-' sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 4: Check for overflow/underflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
