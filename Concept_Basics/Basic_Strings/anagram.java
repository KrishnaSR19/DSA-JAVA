// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


//I solved with this
public class anagram {
    public boolean anagramStrings(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> s1 = new HashMap<>();
        HashMap<Character, Integer> t1 = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            s1.put(s.charAt(i), s1.getOrDefault(s.charAt(i), 0) + 1);
            t1.put(t.charAt(i), t1.getOrDefault(t.charAt(i), 0) + 1);
        }

        return s1.equals(t1);
    }
}

//Brute Force
// Time Complexity: O(N log N) due to sorting each string.

// Space Complexity: O(1) as no additional data structures are used. Note that for Java, the space complexity will be O(N) due to the creation of additional character arrays.
import java.util.Arrays;

class Solution {
    public boolean anagramStrings(String s, String t) {
        // If lengths are not equal, they cannot be anagrams
        if (s.length() != t.length()) return false;

        // Convert strings to char arrays and sort them
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Compare sorted arrays
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "INTEGER";
        String str2 = "TEGERNI";
        boolean result = solution.anagramStrings(str1, str2);
        System.out.println(result ? "True" : "False");
    }
}


// Optimal
// Time Complexity: O(N), where N is the length of the string

// Space Complexity: O(1) as no additional data structures are used

class Solution {
    public boolean anagramStrings(String s, String t) {
        // Edge Cases
        if (s.length() != t.length()) return false;

        // To store the count of each character
        int[] count = new int[26];

        // Count occurrence of each character in first string 
        for (char c : s.toCharArray()) count[c - 'a']++;

        // Decrement the count for each character in the second string
        for (char c : t.toCharArray()) count[c - 'a']--;

        // Check for count of every character
        for (int i : count) {
            // If the count is not zero
            if (i != 0) return false; // Return false
        }

        // Otherwise strings are anagram
        return true;
    }
}




