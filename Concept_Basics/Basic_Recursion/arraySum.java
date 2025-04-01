public class arraySum {
    public int arraySum(int[] nums) {
        //your code goes here
       return  sum(nums ,0);
    }

    private int sum(int[] nums,int i){
        if(i>=nums.length){
            return 0;
        }
        return nums[i] + sum(nums,i+1);

    }
}
