
/*
 * Q.Given two sorted arrays, nums1 and nums2, return an array containing the intersection of these two arrays. Each element in the result must appear as many times as it appears in both arrays.
The intersection of two arrays is an array where all values are present in both arrays.
 */




/*
 * Brute Force
 * Time Complexity: O(MxN), where M is the length of nums1 and N is the length of nums2.
Space Complexity: O(N), where N is size of nums2, extra space to store answer is not considered.
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

/*
 * Optimal
 * Time Complexity: O(M), where M is the length of that array which has less elements.
Space Complexity: O(1), extra space to store answer is not considered.
 */

     // Function to find intersection of two sorted arrays
     public int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> tempList = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays using two pointers approach
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } 
            // nums1[i] == nums2[j]
            else {
                tempList.add(nums1[i]);
                i++;
                j++;
            }
        }

        // Convert the list to an integer array
        int[] ans = new int[tempList.size()];
        for (int k = 0; k < tempList.size(); k++) {
            ans[k] = tempList.get(k);
        }

        // Return the intersection of two arrays
        return ans;
    }