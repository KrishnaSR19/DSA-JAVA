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


/*
 * Brute Force
 * Time Complexity: O(N), where N is the length of the array.
Three loops are used taking K, N-K, and K iterations respectively contributing to O(N+K). However, K can be N/2 in the worst case boiling down the time complexity as O(N).
Space Complexity: O(K), due to the temporary list created to copy the K elements.
 */

public class RotatebyK {
    // Function to rotate the array to the left by k positions
    public void rotateArray(int[] nums, int k) {
        int n = nums.length; // Size of array
        k = k % n; // To avoid unnecessary rotations

        int[] temp = new int[k];

        // Store first k elements in a temporary array
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }

        // Shift n-k elements of given array to the front
        for (int i = k; i < n; i++) {
            nums[i - k] = nums[i];
        }

        // Copy back the k elements at the end
        for (int i = 0; i < k; i++) {
            nums[n - k + i] = temp[i];
        }
    }
}


/*
  Optimal
 * Time Complexity: O(N), where N is the size of the array
As three reversals are performed taking O(k), O(N-k) and O(N) time respectively.
Space Complexity: O(1), as no extra space is used .
 */

 // Function to reverse the array between start and end
 private void reverseArray(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}

// Function to rotate the array to the left by k positions
public void rotateArray(int[] nums, int k) {
    int n = nums.length; // Size of array
    k = k % n; // To avoid unnecessary rotations
    
    // Reverse the first k elements
    reverseArray(nums, 0, k - 1);

    // Reverse the last n-k elements
    reverseArray(nums, k, n - 1);

    // Reverse the entire array
    reverseArray(nums, 0, n - 1);
}