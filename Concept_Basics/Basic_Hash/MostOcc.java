class Solution {
    public int mostFrequentElement(int[] nums) {
        int maxVal=0;
        for(int i = 0;i<nums.length;i++){
            if(maxVal<nums[i]){
                maxVal=nums[i];
            }
        }
 
        int [] hash = new int[maxVal+1];
        for(int i =0;i<nums.length;i++){
            hash[nums[i]]++;
        }
        int max=0;
        int element=0;
        for(int i =0;i<hash.length;i++){
            if(max<hash[i]){
                max=hash[i];
                element=i;
            }
        }
        return element;
    }
}


