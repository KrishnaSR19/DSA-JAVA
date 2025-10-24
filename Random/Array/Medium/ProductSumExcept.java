/*
 * Better
 */

 /*
  * Time and Space Complexity
Time Complexity: O(n) because we are traversing the input array three times.
Space Complexity: O(n) for the prefix and suffix arrays.
  */

 public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] output = new int[n];
    int[] prefix = new int[n];
    int[] suffix = new int[n];

    prefix[0] = 1;
    for (int i = 1; i < n; i++) {
        prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    suffix[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
        suffix[i] = suffix[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < n; i++) {
        output[i] = prefix[i] * suffix[i];
    }

    return output;
}

/*
 * Optimal
 * Time and Space Complexity
Time Complexity: O(n) because it involves two passes over the array.
Space Complexity: O(1) extra space apart from the output array.
 */

 public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] output = new int[n];

    // Initialize the output array with left products
    output[0] = 1;
    for (int i = 1; i < n; i++) {
        output[i] = output[i - 1] * nums[i - 1];
    }

    // Calculate and multiply the right products
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        output[i] *= right;
        right *= nums[i];
    }

    return output;
}