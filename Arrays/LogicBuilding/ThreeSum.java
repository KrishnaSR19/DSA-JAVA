

/*
 * Brute Force
 * Time Complexity: O(N3 x log(no. of unique triplets)), where N is size of the array. Using 3 nested loops & inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
Space Complexity: O(2 x no. of the unique triplets) for using a set data structure and a list to store the triplets.
 */
import java.util.*;
class Solution {
    //Function to find triplets having sum equals to target
    public List<List<Integer>> threeSum(int[] nums) {
        // Set to store unique triplets
        Set<List<Integer>> tripletSet = new HashSet<>();

        int n = nums.length;

        // Check all possible triplets
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Found a triplet that sums up to target
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        
                        /* Sort the triplet to ensure 
                        uniqueness when storing in set*/
                        Collections.sort(temp);
                        tripletSet.add(temp);
                    }
                }
            }
        }

        // Convert set to list of lists (unique triplets)
        List<List<Integer>> ans = new ArrayList<>(tripletSet);

        //Return the ans
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        // Create an instance of Solution class
        Solution sol = new Solution();

        List<List<Integer>> ans = sol.threeSum(nums);

        // Print the result
        for (List<Integer> triplet : ans) {
            System.out.print("[");
            for (int num : triplet) {
                System.out.print(num + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}


/*
 * Better
 * Time Complexity: O(N^2 x log(no. of unique triplets)), where N is size of the array. Inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
Space Complexity: O(2 x no. of the unique triplets) + O(N) for using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.




 */


 import java.util.*;

class Solution {
    // Function to find triplets having sum equals to 0
    public List<List<Integer>> threeSum(int[] nums) {
        // Set to store unique triplets
        Set<List<Integer>> tripletSet = new HashSet<>();

        int n = nums.length;

        // Check all possible triplets
        for (int i = 0; i < n; i++) {
            // Set to store elements seen so far in the loop
            Set<Integer> hashset = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                // Calculate the 3rd element needed to reach 0
                int third =  - (nums[i] + nums[j]);

                /* Find if third element exists in
                hashset (complements seen so far)*/
                if (hashset.contains(third)) {
                    // Found a triplet that sums up to target
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);

                    /* Sort the triplet to ensure
                    uniqueness when storing in set*/
                    Collections.sort(temp);
                    tripletSet.add(temp);
                }

                /* Insert the current element 
                 into hashset for future checks*/
                hashset.add(nums[j]);
            }
        }

        // Convert set to list of lists (unique triplets)
        List<List<Integer>> ans = new ArrayList<>(tripletSet);

        //Return the ans
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        // Create an instance of Solution class
        Solution sol = new Solution();

        List<List<Integer>> ans = sol.threeSum(nums);

        // Print the result
        for (List<Integer> triplet : ans) {
            System.out.print("[");
            for (int num : triplet) {
                System.out.print(num + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}


