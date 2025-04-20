import java.util.*;

/*
 * Q.Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.
 */


/*
 * Brute force 
 * TC O(n + nlogn)
 */
public class SecondLargest {
    public int secondLargestElement(int[] nums) {
        Arrays.sort(nums);   //O(nlogn)
         
        int largest=nums[nums.length-1];

        for(int i =nums.length-2; i>=0;i--){       //O(n)
            if(nums[i]<largest && nums[i] != largest){
                return nums[i];
            }
        }
         
         return -1;
    
    }

}


/*
 * Better than brute force
 * TC O(2n)
 */

 import java.util.*;

class Solution {
  public int secondLargestElement(int[] nums) {
    int largest = nums[0];
    for (int i = 1; i < nums.length; i++) {    //O(n)
      if (nums[i] > largest) {
        largest = nums[i];
      }
    }

    int sLargest = -1;
    for (int i = 0; i < nums.length - 1; i++) {          //O(n)
      if (nums[i] > sLargest && nums[i] != largest) {
        sLargest = nums[i];
      }
    }

    return sLargest;
  }
}


/*
 * Optimal 
 * TC O(n)
 */

 import java.util.*;

class Solution {
  public int secondLargestElement(int[] nums) {
    if(nums.length < 2){
        return -1;
    }
    int largest = Integer.MIN_VALUE;
    int sLargest = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length ; i++) {     //O(n)
      if (nums[i] > largest) {
        sLargest = largest;
        largest = nums[i];
      }else if(nums[i] != largest && nums[i] > sLargest){
        sLargest=nums[i];
      }
    }
    return sLargest == Integer.MIN_VALUE ?  -1 : sLargest;
  }
}


