/*
 * LeetCode Problem: Count of Reverse Pairs
 * Problem Link: https://leetcode.com/problems/reverse-pairs/
 * Description: Given an integer array nums, return the number of reverse pairs in the array.
 * A reverse pair is a pair (i, j) where i < j and nums[i] > 2 * nums[j].
 * Time Complexity: O(n log n), where n is the length of the input array. This is due to the merge sort algorithm used to count pairs.
 * Space Complexity: O(n), for the temporary array used in the merge step.
 * Note: The function should handle cases where the input array is empty or has only one element by returning 0.
 */


 class Solution {
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        //storing elements in the temporary array in a sorted manner//
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * arr[right])
                right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high); 
        cnt += countPairs(arr, low, mid, high); 
        merge(arr, low, mid, high); 
        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}