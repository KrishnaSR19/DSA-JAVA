/*
Given an array of strings, group the anagrams together. You can return the answer in any order.
Problem Link: https://leetcode.com/problems/group-anagrams/
Problem Statement:
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.
    For example, "listen" and "silent" are anagrams of each other.
    Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    
 */

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // HashMap to store sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to char array
            char[] chars = s.toCharArray();
            
            // Sort characters
            Arrays.sort(chars);
            
            // Convert back to string (key)
            String key = new String(chars);
            
            // Add to map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        // Return grouped anagrams
        return new ArrayList<>(map.values());
    }
}
