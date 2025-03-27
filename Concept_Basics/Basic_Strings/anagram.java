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

