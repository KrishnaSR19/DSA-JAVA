
/*
 * Given an integer array nums of size n, sorted in ascending order with distinct values. The array has been right rotated an unknown number of times, between 0 and n-1 (including). Determine the number of rotations performed on the array.
 */

/*
 * Optimal
 * Time Complexity:O(logN), where N is size of the array. As binary search algorithm is being applied to solve the problem.
Space Complexity: As no additional space is used, so the Space Complexity is O(1).
 */

class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
     int n = nums.size();
     int low=0;
     int high = n-1;
     int min =Integer.MAX_VALUE;
     int index=-1;
     while(low<=high){
        int mid = (low+high)/2;

        if(nums.get(low)<=nums.get(high)){
            if(nums.get(low)<min){
                index=low;
                min=nums.get(low);
            }
        }
        if(nums.get(low)<=nums.get(mid)){
            if(nums.get(low)<min){
                index=low;
                min=nums.get(low);

            }
            low=mid+1;
        }
        else{
            if(nums.get(mid)<min){
                index=mid;
                min=nums.get(mid);
            }
            high = mid-1;
        }
        
        
     }
     return index;
    }
}