// Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.






import java.util.HashMap;

public class isomorphic {
      public boolean isomorphicString(String s, String t) {
    if (s.length() != t.length()) return false; // Different lengths can't be isomorphic

    HashMap<Character, Character> hash1 = new HashMap<>();
    HashMap<Character, Character> hash2 = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char charS = s.charAt(i);
      char charT = t.charAt(i);

      // If charS was mapped before, check consistency
      if (hash1.containsKey(charS) && hash1.get(charS) != charT) return false;
      if (hash2.containsKey(charT) && hash2.get(charT) != charS) return false;

      // Store the character mapping
      hash1.put(charS, charT);
      hash2.put(charT, charS);
    }
    return true;
  }
    
}
