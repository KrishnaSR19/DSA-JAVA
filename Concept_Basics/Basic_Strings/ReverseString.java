// Given a string, the task is to reverse it. The string is represented by an array of characters s. Perform the reversal in place with O(1) extra memory.
// Note: no need to return anything, modify the given list.



package Concept_Basics.Basic_Strings;

import java.util.Vector;

public class ReverseString {
        public void reverseString(Vector<Character> s) {
        //your code goes here
        int start = 0,end=s.size()-1;

        while(start<end){
            char ch = s.get(start);
            s.set(start,s.get((end)));
            s.set(end,ch);

            start++;
            end--;
        }
        return;
    }
    
}
