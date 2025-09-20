/*
 * 
 */

public class Solution {
    /* Function to get the single 
    number in the given array */
    public List<Integer> singleNumber(int[] nums) {
        
        // Array to store the answer
        List<Integer> ans = new ArrayList<>();
        
        /* Map to store the elements 
        and their frequencies */
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        // Iterate on the array
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1); // Update the map
        }
        
        // Iterate on the map
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            // If frequency is 1
            if (entry.getValue() == 1) {
                /* Add the element to
                the result array */
                ans.add(entry.getKey());
            }
        }
        
        // Return the result after sorting
        Collections.sort(ans);
        return ans;
    }
}
