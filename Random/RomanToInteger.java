/*
 * LeetCode Problem: Roman to Integer
 * Problem Link: https://leetcode.com/problems/roman-to-integer/
 * Description: Convert a Roman numeral to an integer.
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D, and M.
 * Symbol       Value   
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together
 * 11 is written as XI, which is simply X + I. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.     
 */

 /*
  * Time Complexity: O(N), where N is the length of the input string s. We iterate through each character in the string once.
  * Space Complexity: O(1), as we are using a fixed-size map to store the Roman numeral values, which does not depend on the size of the input.
  
  */
class Solution {
    public int romanToInt(String s) {
        //  Create a map for Roman numerals
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int n = s.length();

        // Iterate from left to right
        for (int i = 0; i < n; i++) {
            int curr = map.get(s.charAt(i));
            int next = (i + 1 < n) ? map.get(s.charAt(i + 1)) : 0;

            // If current value is less than next, subtract it
            if (curr < next) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }
}
