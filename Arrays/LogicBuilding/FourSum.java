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
