class Solution {
    public int[] reverse(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            // Swap current element with the corresponding element from the end
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        return arr;
    }
}



