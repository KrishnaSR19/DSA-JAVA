public class FourSum {
    import java.util.*;

class Solution {
    //function to find quadruplets having sum equal to target
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //size of the array
        int n = nums.length;
        
        // Set to store unique quadruplets
        Set<List<Integer>> set = new HashSet<>();
        
        // Checking all possible quadruplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        // Calculate the sum of the current quadruplet
                        long sum = nums[i] + nums[j] + nums[k] + nums[l];
                        
                        // Check if the sum matches the target
                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            // Sort the quadruplet to ensure uniqueness
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        
        // Convert set to list (unique quadruplets)
        return new ArrayList<>(set);
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        
        //create an instance of the Solution class
        Solution sol = new Solution();
        
        List<List<Integer>> ans = sol.fourSum(nums, target);
        
        // Print the result
        System.out.println("The quadruplets are: ");
        for (List<Integer> quad : ans) {
            System.out.print("[");
            for (int num : quad) {
                System.out.print(num + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
}



import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        
        // Set to store unique quadruplets
        Set<List<Integer>> set = new HashSet<>();
        
        // Checking all possible quadruplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Set to store elements seen so far in the loop
                Set<Long> hashset = new HashSet<>();
                
                for (int k = j + 1; k < n; k++) {
                    /* Calculate the fourth element
                    needed to reach target*/
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = target - sum;
                    
                    /* Find if fourth element exists in 
                    hashset (complements seen so far)*/
                    if (hashset.contains(fourth)) {
                        // Found a quadruplet that sums up to target
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    
                    // Insert the kth element into hashset for future checks
                    hashset.add((long) nums[k]);
                }
            }
        }
        
        // Convert set to list (unique quadruplets)
        ans.addAll(set);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        
        // Create an instance of Solution class
        Solution sol = new Solution();
        
        List<List<Integer>> ans = sol.fourSum(nums, target);
        
        // Print the result
        System.out.println("The quadruplets are:");
        for (List<Integer> quad : ans) {
            System.out.print("[");
            for (int num : quad) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }
}


/*
 * Optimal
 */

class Solution{
public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    int n = nums.length;
    
    // Sort the input array nums
    Arrays.sort(nums);
    
    // Iterate through the array to find quadruplets
    for (int i = 0; i < n; i++) {
        // Skip duplicates for i
        if (i > 0 && nums[i] == nums[i - 1])
            continue;
        
        for (int j = i + 1; j < n; j++) {
            // Skip duplicates for j
            if (j > i + 1 && nums[j] == nums[j - 1])
                continue;
            
            // Two pointers approach
            int k = j + 1;
            int l = n - 1;
            
            while (k < l) {
                long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                
                if (sum == target) {
                    // Found a quadruplet that sums up to target
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                    ans.add(temp);
                    
                    // Skip duplicates for k and l
                    k++;
                    l--;
                    while (k < l && nums[k] == nums[k - 1]) k++;
                    while (k < l && nums[l] == nums[l + 1]) l--;
                } else if (sum < target) {
                    k++;
                } else {
                    l--;
                }
            }
        }
    }
    
    return ans;
}
}