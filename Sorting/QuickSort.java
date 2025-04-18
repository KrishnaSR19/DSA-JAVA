import java.util.Random;

public class QuickSort {
  
    // Function to partition the array
    public int partition(int[] arr, int low, int high) {

        // Choosing a random index between low and high
        int randomIndex = low + new Random().nextInt(high - low + 1);
        // Swap the random element with the first element
        int temp = arr[low];
        arr[low] = arr[randomIndex];
        arr[randomIndex] = temp;

        // Now choosing arr[low] as the pivot after the swap
        int pivot = arr[low];
        // Starting index for left subarray
        int i = low;
        // Starting index for right subarray
        int j = high;

        while (i < j) {
            /*  Move i to the right until we find an
                element greater than the pivot  */
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            /*  Move j to the left until we find an
                element smaller than the pivot  */
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            /*  Swap elements at i and j if i is still
                less than j  */
            if (i < j) {
                int temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
            }
        }

        // Pivot placed in correct position
        int temp3 = arr[low];
        arr[low] = arr[j];
        arr[j] = temp3;
        return j;
    }

    // Helper Function to perform the recursive quick sort
    public void quickSortHelper(int[] arr, int low, int high) {
        /*  Base case: If the array has one or no
            elements, it's already sorted  */
        if (low < high) {
            // Get the partition index
            int pIndex = partition(arr, low, high);
            // Sort the left subarray
            quickSortHelper(arr, low, pIndex - 1);
            // Sort the right subarray
            quickSortHelper(arr, pIndex + 1, high);
        }
    }

    // Function to perform quick sort on given array
    public int[] quickSort(int[] nums) {
        // Get the size of array
        int n = nums.length;

        // Perform quick sort
        quickSortHelper(nums, 0, n - 1);

        // Return sorted array
        return nums;
    }

}
