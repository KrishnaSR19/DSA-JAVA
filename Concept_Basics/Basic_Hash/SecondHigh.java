class Solution {
    public int secondMostFrequentElement(int[] nums) {
      int maxVal = 0;
      for (int i = 0; i < nums.length; i++) {
        maxVal = Math.max(maxVal, nums[i]);
      }
      int[] hash = new int[maxVal + 1];
      for (int i = 0; i < nums.length; i++) {
        hash[nums[i]]++;
      }
      int count = 0;
      int el1 = -1, el2 = -1;
      int el1Freq = 0, el2Freq = 0;
      for (int i = 0; i <=maxVal; i++) {
        count = hash[i];
        if (count == 0) {
          continue;
        }
        if (count > el1Freq) {
          el2Freq = el1Freq;
          el2 = el1;
  
          el1Freq = count;
          el1 = i;
        } else if (count > el2Freq && count<el1Freq) {
          el2 = i;
          el2Freq = count;
        }
      //   else if(count==el1Freq){
      //     el1 = Math.min(el1,i);
      //   }
      //   else if(count ==el2Freq){
      //     el2=Math.min(el2,i);
      //   }
      }
      return el2;
    }
  }
  