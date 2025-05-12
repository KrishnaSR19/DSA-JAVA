/*
 *Q. Given two integers r and c, return the value at the rth row and cth column (1-indexed) in a Pascal's Triangle.
In Pascal's triangle:

The first row has one element with a value of 1.
Each row has one more element in it than its previous row.
The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.
 */

/*
 * Time Complexity: O(C), where C is the column number. This is because the loop in the nCr function runs for a total of C times, where C can be as large as N/2.
Space Complexity: O(1), as no extra space is used.
 */



import java.util.*; 
public class PascalTriangle1 {

class Solution {
    // Function to print the element in rth row and cth column 
    public static int pascalTriangleI(int r, int c) {
        return nCr(r-1, c-1);
    }
    
    // Function to calculate nCr
    private static int nCr(int n, int r)  {
        // Choose the smaller value for lesser iterations
        if(r > n-r) r = n-r;
        
        // base case
        if(r == 1) return n;
        
        int res = 1; // to store the result 
        
        // Calculate nCr using iterative method avoiding overflow 
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        
        return res; // return the result 
    }
};

class Main {
    public static void main(String[] args) {
        // row number
        int r = 5; 
        // col number
        int c = 3;

        // Create an instance of the Solution class
        Solution sol = new Solution(); 
        
        // Function call to print the element in rth row and cth column 
        int ans = sol.pascalTriangleI(r, c);

        System.out.println("The element in the rth row and cth column in pascal's triangle is: " + ans);
    }
}

}
