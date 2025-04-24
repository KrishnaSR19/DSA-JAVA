public class FIndMissing {
    import java.util.*;


    // Function to find the missing number
    public int missingNumber(int[] nums) {
        // Calculate N from the length of nums
        int N = nums.length;
        
        // Outer loop that runs from 0 to N
        for (int i = 0; i <= N; i++) {
            /* Flag variable to check 
            if an element exists*/
            int flag = 0;
            
            /* Search for the element 
            using linear search*/
            for (int j = 0; j < N; j++) {
                if (nums[j] == i) {
                    // i is present in the array
                    flag = 1;
                    break;
                }
            }
            
            // Check if the element is missing (flag == 0)
            if (flag == 0) return i;
        }
        
        /* The following line will never 
        execute, it is just to avoid warnings*/
        return -1;
    }



}
