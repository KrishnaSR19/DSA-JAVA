/*
Problem Link: https://leetcode.com/problems/ransom-note/
Problem Statement:
Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and
false otherwise.
You can construct ransomNote from magazine if each letter in magazine
can only be used once in ransomNote.

 */

/*
Time Complexity: O(m + n) where m and n are the lengths of ransomNote and magazine respectively.
Space Complexity: O(1) since the HashMap will store at most 26 key-value pairs for lowercase English letters.
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch:magazine.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);

        }

        for(char ch:ransomNote.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch)==0){
                return false;
            }
            map.put(ch,map.get(ch)-1);
        }
        return true;
        

    }
}