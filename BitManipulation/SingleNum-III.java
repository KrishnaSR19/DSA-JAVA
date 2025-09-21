/*
 * Brute Force
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


/*
 * Optimal
 */

class Solution {
    /* Function to get the single 
    numbers in the given array */
    public int[] singleNumber(int[] nums) {
        // Variable to store size of array
        int n = nums.length;
        
        // Variable to store XOR of all elements
        long XOR = 0;
        
        // Traverse the array
        for(int i=0; i < n; i++) {
            // Update the XOR
            XOR = XOR ^ nums[i];
        }
        
        /* Variable to get the rightmost 
        set bit in overall XOR */
        int rightmost = (int)(XOR & (XOR - 1)) ^ (int)XOR;
        
        /* Variables to stores XOR of
        elements in bucket 1 and 2 */
        int XOR1 = 0, XOR2 = 0;
        
        // Traverse the array
        for(int i=0; i < n; i++) {
            /* Divide the numbers among bucket 1
             and 2 based on rightmost set bit */
            if((nums[i] & rightmost) != 0) {
                XOR1 = XOR1 ^ nums[i];
            }
            else {
                XOR2 = XOR2 ^ nums[i];
            }
        }
        
        // Return the result in sorted order
        if(XOR1 < XOR2) return new int[]{XOR1, XOR2};
        return new int[]{XOR2, XOR1};
    }
    
}
