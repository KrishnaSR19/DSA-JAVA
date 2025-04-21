package Arrays.Fundamentals;
/*
 * Worst method
 */
public void rotateArray(int[] nums, int k) {
    while(k>0){    
    int temp = nums[0];
    for (int i = 1; i < nums.length; i++) {
        nums[i - 1] = nums[i];
    }
    nums[nums.length - 1] = temp;
    k--;
    }
}



public class RotatebyK {
    
}
