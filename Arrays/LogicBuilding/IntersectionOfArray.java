/*
 * Brute Force
 */

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfArray {
        //Function to find intersection of two sorted arrays
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> ansList = new ArrayList<>();
        int[] visited = new int[nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

                /*If nums1[i] is equal to nums2[j] and nums2[j] 
                is not visited then add nums2[j] in ans.*/
                if (nums1[i] == nums2[j] && visited[j] == 0) {
                    
                    ansList.add(nums2[j]);
                    // Mark as visited
                    visited[j] = 1;
                    
                    break;
                } 
                 //If nums2[j] is greater than nums1[i], break out of loop
                else if (nums2[j] > nums1[i]) 
                    break; 
            }
        }

        // Convert ArrayList to int array
        int[] ans = new int[ansList.size()];
        for (int k = 0; k < ansList.size(); k++) {
            ans[k] = ansList.get(k);
        }
       
       //Return the final ans
        return ans;
    }
}
