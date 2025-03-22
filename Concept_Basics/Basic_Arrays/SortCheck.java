class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        
        // Iterate through the array
        for (int i = 1; i < n; i++) {
            // If the previous element is greater than the current element, it's not sorted
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        
        return true;
       
    }
}