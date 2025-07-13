/*
 * LeetCode Question number 1865
 * 
 */

class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freqMap; // Stores frequency of elements in nums2

    // Constructor: Initializes nums1, nums2 and builds the frequency map for nums2
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        freqMap = new HashMap<>();
        
        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }
    
    // Adds 'val' to nums2[index] and updates the frequency map
    public void add(int index, int val) {
        int oldVal = nums2[index];          // Current value at index
        int newVal = oldVal + val;          // New value after addition

        // Decrease frequency of old value
        freqMap.put(oldVal, freqMap.get(oldVal) - 1);
        if (freqMap.get(oldVal) == 0) {
            freqMap.remove(oldVal);         // Clean up if frequency drops to 0
        }

        // Update nums2 and increase frequency of new value
        nums2[index] = newVal;
        freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);
    }
    
    // Counts number of pairs (i, j) such that nums1[i] + nums2[j] == tot
    public int count(int tot) {
        int count = 0;
        for (int num : nums1) {
            int target = tot - num;  // Value that must exist in nums2
            count += freqMap.getOrDefault(target, 0); // Add its frequency if present
        }
        return count;
    }
}
