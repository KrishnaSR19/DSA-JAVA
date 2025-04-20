import java.util.*;

/*
 * Brute force 
 */
public class SecondLargest {
    public int secondLargestElement(int[] nums) {
        Arrays.sort(nums);
        int largest=nums[nums.length-1];
        for(int i =nums.length-2; i>=0;i--){
            if(nums[i]<largest && nums[i] != largest){
                return nums[i];
            }
        }
         
         return -1;
    
    }

}
