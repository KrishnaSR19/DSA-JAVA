
/*
 * Brute Force
 * Time Complexity: O(N^2), where N is the size of the array. In the worst case i.e. if the missing number is N itself, the outer loop will run for N times, and for every single number the inner loop will also run for approximately N times. So, the total time complexity will be O(N^2).
   Space Complexity: O(1) , as no extra space is used.
 */

public class FIndMissing {
    import java.util.*;
    // Function to find the missing number
    public int missingNumber(int[] nums) {
        // Calculate N from the length of nums
        int N = nums.length;
        
        // Outer loop that runs from 0 to N
        for (int i = 0; i <= N; i++) {
            /* Flag variable to check 
            if an element exists*/
            int flag = 0;
            
            /* Search for the element 
            using linear search*/
            for (int j = 0; j < N; j++) {
                if (nums[j] == i) {
                    // i is present in the array
                    flag = 1;
                    break;
                }
            }
            
            // Check if the element is missing (flag == 0)
            if (flag == 0) return i;
        }
        
        /* The following line will never 
        execute, it is just to avoid warnings*/
        return -1;
    }
}

/*
 * Better
 * Time Complexity: O(N) + O(N) ~ O(2N), where N is size of the array + 1. For storing the frequencies in the hash array, the program takes O(N) time complexity and for checking the frequencies in the second step again O(N) is required. So, the total time complexity is O(N) + O(N)
Space Complexity: O(N) where N is size of the array + 1, as extra hash space is used.
 */

 import java.util.Arrays;

class Solution {
    //  Function to find the missing number
    public int missingNumber(int[] nums) {
        int N = nums.length; 
        
        // Array to store frequencies, initialized to 0
        int[] freq = new int[N+1];
        
        // Storing the frequencies in the array
        for (int num : nums) {
            freq[num]++;
        }
        
        // Checking the frequencies for numbers 0 to N
        for (int i = 0; i <= N; i++) {
            if (freq[i] == 0) {
                return i;
            }
        }
        
        /* This line will never execute, 
        it is just to avoid warnings */
        return -1;
    }
}



/*
 * Optimal -1
 * Time Complexity: O(N) where N is size of array, to compute the sum of the array elements.
Space Complexity: O(1) as no extra space is used.
 */

 public int missingNumber(int[] nums) {
    // Calculate N from the length of nums
    int N = nums.length;
    
    // Summation of first N natural numbers
    int sum1 = (N * (N + 1)) / 2;
    
    // Summation of all elements in nums
    int sum2 = 0;
    for (int num : nums) {
        sum2 += num;
    }
    
    // Calculate the missing number
    int missingNum = sum1 - sum2;
    
    // Return the missing number
    return missingNum;
}


/*
 * optima-2
 * Time Complexity: O(N) for getting the sum of the array elements, where N is the size of the array.
Space Complexity: O(1) as no extra space is used.
 */

 // Function to find missing number in array
 public int missingNumber(int[] nums) {
    int xor1 = 0, xor2 = 0;

    // Calculate XOR of all array elements
    for (int i = 0; i < nums.length; i++) {
        xor1 = xor1 ^ (i + 1); // XOR up to [1...N]
        xor2 = xor2 ^ nums[i]; // XOR of array elements
    }

    // XOR of xor1 and xor2 gives missing number
    return (xor1 ^ xor2);
}


/*
 * Better(Hash)
 */

 //Method -1 using hash


class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check from 1 to n for missing and repeating
        for (int i = 1; i <= nums.length; i++) {
            Integer count = map.get(i);
            if (count == null) {
                result[1] = i; // Missing number
            } else if (count == 2) {
                result[0] = i; // Repeating number
            }
        }

        return result;
    }
}

//Method 2 
import java.util.*;

class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        
        // Size of the array
        int n = nums.length;
        
        // Hash array to count occurrences
        int[] hash = new int[n + 1];
        
        // Update the hash array:
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }

        int repeating = -1, missing = -1;
        
        // Find the repeating and missing number:
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            /* If both repeating and missing 
            are found, break out of loop*/
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        
        // Return [repeating, missing]
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};
        
        // Create an instance of Solution class
        Solution sol = new Solution();

        int[] result = sol.findMissingRepeatingNumbers(nums);
        
        // Print the repeating and missing numbers found
        System.out.println("The repeating and missing numbers are: {" + result[0] + ", " + result[1] + "}");
    }
}


/*
 * Optimal(using equations)
 * Time Complexity: O(N), as a single loop is used, where N is the size of the given array.

Space Complexity: O(1) no extra space is used.
 */

 import java.util.*;

class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        
        // Size of the array
        long n = nums.length;

        // Sum of first n natural numbers
        long SN = (n * (n + 1)) / 2;

        // Sum of squares of first n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        /* Calculate actual sum (S) and sum 
           of squares (S2) of array elements */
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }

        // Compute the difference values
        long val1 = S - SN;

        // S2 - S2n = X^2 - Y^2
        long val2 = S2 - S2N;

        // Calculate X + Y using X + Y = (X^2 - Y^2) / (X - Y)
        val2 = val2 / val1;

        /* Calculate X and Y from X + Y and X - Y
           X = ((X + Y) + (X - Y)) / 2
           Y = X - (X - Y) */
        long x = (val1 + val2) / 2;
        long y = x - val1;

        // Return the results as [repeating, missing]
        return new int[]{(int) x, (int) y};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};

        // Create an instance of Solution class
        Solution sol = new Solution();

        int[] result = sol.findMissingRepeatingNumbers(nums);

        // Print the repeating and missing numbers found
        System.out.printf("The repeating and missing numbers are: {%d, %d}\n", result[0], result[1]);
    }
}


/*
 * Optimal(XOR)
 * Time Complexity: O(N), using only one loop running for N times, where N is the size of the given array.

Space Complexity: O(1) no extra space is used.
 */

import java.util.*;

class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        // size of the array
        int n = nums.length; 

        int xr = 0;

        for (int i = 0; i < n; i++) {
            // XOR of all elements in nums
            xr = xr ^ nums[i]; 
            
            // XOR of numbers from 1 to n
            xr = xr ^ (i + 1);  
        }

        // Get the rightmost set bit in xr
        int number = (xr & ~(xr - 1));

        // Group the numbers based on the differentiating bit
        // Number that falls into the 0 group
        int zero = 0; 
        
        // Number that falls into the 1 group
        int one = 0;  

        for (int i = 0; i < n; i++) {
            /* Check if nums[i] belongs to the 1 group
            based on the differentiating bit*/
            if ((nums[i] & number) != 0) {
                // XOR operation to find numbers in the 1 group
                one = one ^ nums[i];
            } else {
                // XOR operation to find numbers in the 0 group
                zero = zero ^ nums[i]; 
            }
        }

        // Group numbers from 1 to n based on differentiating bit
        for (int i = 1; i <= n; i++) {
            
            /* Check if i belongs to the 1 group 
            based on the differentiating bit*/
            if ((i & number) != 0) {
                // XOR operation to find numbers in the 1 group
                one = one ^ i; 
            } else {
                // XOR operation to find numbers in the 0 group
                zero = zero ^ i; 
            }
            
        }

        // Count occurrences of zero in nums
        int cnt = 0; 

        for (int i = 0; i < n; i++) {
            if (nums[i] == zero) {
                cnt++;
            }
        }

        if (cnt == 2) {
            /*zero is the repeating number,
            one is the missing number*/
            return new int[] {zero, one}; 
        }
        
        /* one is the repeating number, 
        zero is the missing number*/
        return new int[] {one, zero}; 
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};
        
        // Create an instance of Solution class
        Solution sol = new Solution();

        int[] result = sol.findMissingRepeatingNumbers(nums);
        
        // Print the repeating and missing numbers found
        System.out.println("The repeating and missing numbers are: {" + result[0] + ", " + result[1] + "}");
    }
}

