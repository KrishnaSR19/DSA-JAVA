public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        // Traverse through the array
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;

            // Swap elements till we reach greater element
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
        return nums;
    }
}
