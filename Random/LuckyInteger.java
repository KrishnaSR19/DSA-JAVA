/*
* Q. Given an array of integers, find the lucky integer in the array.
* A lucky integer is an integer that has a frequency in the array equal to its value.
 */


 /*
  * Optimal
    * Time Complexity: O(n), where n is the number of elements in the array.
    * Space Complexity: O(n), as we are using a HashMap to store the frequency of each integer
  */

  
class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int result = -1;

        for (int key : freq.keySet()) {
            if (key == freq.get(key)) {
                result = Math.max(result, key);
            }
        }

        return result;
    }
}