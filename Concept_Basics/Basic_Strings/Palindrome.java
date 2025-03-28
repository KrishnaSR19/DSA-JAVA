// You are given a string s. Return true if the string is palindrome, otherwise false. A string is called palindrome if it reads the same forward and backward.

package Concept_Basics.Basic_Strings;

public class Palindrome {
    public boolean palindromeCheck(String s) {
        // your code goes here
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

}
