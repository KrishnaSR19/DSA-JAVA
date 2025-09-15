/*
 * Given an array of nums of n integers. Every integer in the array appears twice except one integer. Find the number that appeared once in the array.
 */

class Solution {
    /* Function to get the single 
    number in the given array */
    public int singleNumber(int[] nums) {
        
        /* Map to store the elements 
        and their frequencies */
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        // Iterate on the array
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1); //Update the map
        }
        
        //Iterate on the map
        for (int key : mpp.keySet()) {
            // If frequency is 1
            if (mpp.get(key) == 1) {
                // Return the element
                return key;
            }
        }   
        
        /* Return -1, if there is no 
        number having frequency 1 */
        return -1;
    }
}
