/*
 * Q.You have a set of integers s, which originally contains all the numbers
 * from 1 to n. Unfortunately, due to some error, one of the numbers in s got
 * duplicated to another number in the set, which results in repetition of one
 * number and loss of another number.
 * 
 * You are given an integer array nums representing the data status of this set
 * after the error.
 * 
 * Find the number that occurs twice and the number that is missing and return
 * them in the form of an array.
 */


 /*
  * Time Complexity: O(N), where N is the length of the input array. We traverse the array once to calculate the sums and another time to compute the results.
    * Space Complexity: O(1), as we are using a constant amount of extra space for variables, regardless of the input size.
  */

 class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        long sumN = (long)n * (n + 1) / 2;         // Expected sum of 1 to n
        long sumSqN = (long)n * (n + 1) * (2 * n + 1) / 6; // Expected sum of squares

        long sum = 0, sumSq = 0;
        for (int num : nums) {
            sum += num;
            sumSq += (long) num * num;
        }

        long diff = sum - sumN;           // x - y (duplicate - missing)
        long sqDiff = sumSq - sumSqN;     // x^2 - y^2 = (x - y)(x + y)

        long sumXY = sqDiff / diff;       // x + y

        int duplicate = (int)((diff + sumXY) / 2);
        int missing = (int)(duplicate - diff);

        return new int[]{duplicate, missing};
    }
}
