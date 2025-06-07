/*
 * Q.Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.
 */

 /*
  * Brute Force
  Time Complexity: O(N2), where N is the size of the array. As for every element of the array the inner loop runs for N times.

Space Complexity: O(1) the space used is so small that it can be considered constant.
  */

  import java.util.*;

class Solution {
    // Function to find majority elements in an array
    public List<Integer> majorityElementTwo(int[] nums) {
        // Size of the array
        int n = nums.length;
        
        // List of answers
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            /* Checking if nums[i] is not 
            already part of the answer */
            
            if (result.size() == 0 || result.get(0) != nums[i]) {
                
                int cnt = 0;
                
                for (int j = 0; j < n; j++) {
                    // counting the frequency of nums[i]
                    if (nums[j] == nums[i]) {
                        cnt++;
                    }
                }
                
                // check if frequency is greater than n/3
                if (cnt > (n / 3)) {
                    result.add(nums[i]);
                }
            }
            
            // if result size is equal to 2 break out of loop
            if (result.size() == 2) {
                break;
            }
        }
        
        // return the majority elements
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        
        // Create an instance of Solution class
        Solution sol = new Solution();
        
        List<Integer> ans = sol.majorityElementTwo(arr);
        
        // Print the majority elements found
        System.out.print("The majority elements are: ");
        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}

/*
 * Better(HashMap)
 * Time Complexity: O(N * logN), where N is size of the given array. For using a map data structure, where insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN). On using unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).

Space Complexity: O(N) for uing a map data structure. A list that stores a maximum of 2 elements is also used, but that space used is so small that it can be considered constant.
 */

 import java.util.*;

class Solution {
    // Function to find majority elements in an array
    public List<Integer> majorityElementTwo(int[] nums) {
        
        // Size of the array
        int n = nums.length;

        // List of answers
        List<Integer> result = new ArrayList<>();

        // Declaring a map
        Map<Integer, Integer> mpp = new HashMap<>();

        // Least occurrence of the majority element
        int mini = n / 3 + 1;

        // Storing the elements with its occurrence
        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);

            // Checking if nums[i] is the majority element
            if (mpp.get(nums[i]) == mini) {
                result.add(nums[i]);
            }

            // If result size is equal to 2 break out of loop
            if (result.size() == 2) {
                break;
            }
        }

        // Return the majority elements
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};

        // Create an instance of Solution class
        Solution sol = new Solution();

        List<Integer> ans = sol.majorityElementTwo(arr);

        // Print the majority elements found
        System.out.print("The majority elements are: ");
        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}

