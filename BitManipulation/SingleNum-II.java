/*
 * Time Complexity: O(N) (where N is the size of the array) –
Traversing the array to update the Hash Map - O(N).
Traversing on the map - O(N) (in worst case).
Space Complexity: O(N) – Using a hashmap data structure and in the worst-case (when all elements in the array are unique), it will store N key-value pairs.
 */

class Solution {
    /*
     * Function to get the single
     * number in the given array
     */
    public int singleNumber(int[] nums) {

        /*
         * Map to store the elements
         * and their frequencies
         */
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // Iterate on the array
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1); // Update the map
        }

        // Iterate on the map
        for (HashMap.Entry<Integer, Integer> it : mpp.entrySet()) {
            // If frequency is 1
            if (it.getValue() == 1) {
                // Return the element
                return it.getKey();
            }
        }

        /*
         * Return -1, if there is no
         * number having frequency 1
         */
        return -1;
    }
}


/*
 * Time Complexity: O(32*N) – For every 32-bit position, all the elements of the array are traversed.
Space Complexity: O(1) – Using a couple of variables i.e., constant space.
 */
class Solution {
    /* Function to get the single 
    number in the given array */
    public int singleNumber(int[] nums) {
        // Variable to store size of array
        int n = nums.length;
        
        // Variable to store the ans
        int ans = 0;
        
        // Checking every bit position
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            
            /* Variable to count number of 
            set bits in bitIndex position */
            int count = 0;
            
            // Traversing all elements 
            for (int i = 0; i < n; i++) {
                
                /* Counting elements having set
                bits at bitIndex position */
                if ((nums[i] & (1 << bitIndex)) != 0) {
                    count++;
                }
            }
            
            // Updating bits in answer
            if (count % 3 != 0) {
                ans |= (1 << bitIndex);
            }
        }
        
        return ans;
    }
}

/*
 *Time Complexity: O(Nlog(N)) –
Sorting the array takes O(Nlog(N)) TC.
Traversing the array takes O(N/3) TC. Hence, O(Nlog(N)) + O(N/3) = O(Nlog(N)).
Space Complexity: O(1) Using a couple of variables i.e., constant space. 
 */
class Solution {
    /* Function to get the single 
    number in the given array */
    public int singleNumber(int[] nums) {
        // Variable to store size of array
        int n = nums.length;
        
        // Sorting the array
        Arrays.sort(nums);
        
        // Traversing the array
        for (int i = 1; i < nums.length; i += 3) {
            /* Checking the elements 
            in the bucket */
            if (nums[i] != nums[i - 1]) {
                // Return the single number
                return nums[i - 1];
            }
        }
        
        /* If not found till now, then 
        the last number will be single */
        return nums[n - 1];
    }
}

/*Optimal
 * Time Complexity: O(N), where N is the number of elements in the array
Traversing the array once takes linear time.
Space Complexity: O(1), as only a couple of variables are used.
 */

 import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        // Two buckets
        int ones = 0, twos = 0;

        // Traverse the array 
        for (int i = 0; i < nums.length; i++) {
            // Add the number to Ones, if it is not in Twos
            ones = (ones ^ nums[i]) & ~twos;

            // Add the number to Twos, if it is already in Ones
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }
}

