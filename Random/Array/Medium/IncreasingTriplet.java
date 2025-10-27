public boolean increasingTriplet(int[] nums) {
    // Initialize the first and second variables to the maximum possible value
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    // Traverse the array
    for (int num : nums) {
        // If current number is less than or equal to the first, update first
        if (num <= first) {
            first = num;
        // Else if current number is less than or equal to the second, update second
        } else if (num <= second) {
            second = num;
        // Else we found a number greater than both first and second
        } else {
            return true;
        }
    }
    return false;
}