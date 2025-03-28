// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
// For example, if s = "abcde", then it will be "bcdea" after one shift

//Brute force
public class rotateString {
    public boolean rotateString(String s, String goal) {
        // Strings must be same length to be rotations of each other
            if (s.length() != goal.length()) {
                return false; 
            }
            // Try all possible rotations of s
            for (int i = 0; i < s.length(); i++) {
                String rotated = s.substring(i) + s.substring(0, i); 
                if (rotated.equals(goal)) {
                    return true;  // Return true if a match is found
                }
            }
            return false;  
        }
    
}





 //Optimal
public boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) {
        return false;  
    }
    String doubledS = s + s;  // Concatenate s with itself
    return doubledS.contains(goal);  // Check if goal is a substring of s + s
    

}