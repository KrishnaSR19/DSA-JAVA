/*
Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 */

/*
Time Complexity: O(N log N) due to sorting the array. + O(N) for the linear scan.
Space Complexity: O(1) as we are using constant space.
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i =0 ; i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }

        return false;
    }
}

/*
Optimal Approach:
Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(N) for the hash set used to store elements.
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        
        return false;
    }
}
