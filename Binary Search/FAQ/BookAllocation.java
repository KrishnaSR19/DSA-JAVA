/*
 *Q.Given an array nums of n integers, where nums[i] represents the number of pages in the i-th book, and an integer m representing the number of students, allocate all the books to the students so that each student gets at least one book, each book is allocated to only one student, and the allocation is contiguous.
Allocate the books to m students in such a way that the maximum number of pages assigned to a student is minimized. If the allocation of books is not possible, return -1.
 */

/*
 * Time Complexity:O(N * (sum-max)), where N is size of the array, sum is the sum of all array elements, max is the maximum of all array elements.
As the loop runs from max to sum to check all possible numbers of pages. Inside the loop, the countStudents() function is being called for each number, and the loop inside this runs for N times.
Space Complexity: As no additional space is used, so the Space Complexity is O(1).
 */

class Solution {
    /*
     * Function to count the number of
     * students required given the maximum
     * pages each student can read
     */
    private int countStudents(int[] nums, int pages) {
        // Size of array
        int n = nums.length;

        int students = 1;
        int pagesStudent = 0;

        for (int i = 0; i < n; i++) {
            if (pagesStudent + nums[i] <= pages) {
                // Add pages to current student
                pagesStudent += nums[i];
            } else {
                // Add pages to next student
                students++;
                pagesStudent = nums[i];
            }
        }
        return students;
    }

    /*
     * Function to allocate the book to ‘m’
     * students such that the maximum number
     * of pages assigned to a student is minimum
     */
    public int findPages(int[] nums, int m) {
        int n = nums.length;

        // Book allocation impossible
        if (m > n)
            return -1;

        // Calculate the range for search
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]);
            high = high + nums[i];
        }

        // Linear search for minimum maximum pages
        for (int pages = low; pages <= high; pages++) {
            if (countStudents(nums, pages) == m) {
                return pages;
            }
        }
        return low;
    }

}

/*
 * Optimal
 * Time Complexity:O(N * log(sum-max)), where N is size of the array, sum is the
 * sum of all array elements, max is the maximum of all array elements.
 * As, binary search is being applied on [max, sum]. Inside the loop, we are
 * calling the countStudents() function for the value of ‘mid’. Now, inside the
 * countStudents() function, the loop runs for N times.
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */
class Solution {
    /*
     * Function to count the number of
     * students required given the maximum
     * pages each student can read
     */
    private int countStudents(int[] nums, int pages) {
        // Size of array
        int n = nums.length;

        int students = 1;
        int pagesStudent = 0;

        for (int i = 0; i < n; i++) {
            if (pagesStudent + nums[i] <= pages) {
                // Add pages to current student
                pagesStudent += nums[i];
            } else {
                // Add pages to next student
                students++;
                pagesStudent = nums[i];
            }
        }
        return students;
    }

    /*
     * Function to allocate the book to ‘m’
     * students such that the maximum number
     * of pages assigned to a student is minimum
     */
    public int findPages(int[] nums, int m) {
        int n = nums.length;

        // Book allocation impossible
        if (m > n)
            return -1;

        // Calculate the range for search
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]);
            high = high + nums[i];
        }

        // Binary search for minimum maximum pages
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(nums, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
