/*
 * Q.Given an integer r, return all the values in the rth row (1-indexed) in Pascal's Triangle in correct order.
In Pascal's triangle:
The first row has one element with a value of 1.
Each row has one more element in it than its previous row.
The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.
 * 
 */


/*
 * Brute Force
 * TC:O(r*c)
 * SC:O(1)
 */

public class PascalsTria2 {
    public static int pascalTriangle2(int r) {
        for(int c=1;c<r;c++){
           return nCr(r-1, c-1);
        }
        
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


 
}


/*
Time Complexity: O(R), where R is the given row number.
A simple loop is used that runs R times and performs constant time oprations in each iteration resulting in a linear time complexity.
Space Complexity: O(1), as no extra space is used.
Note: that if the space used to return the row is considered, the space complexity will be O(R) as the space used to store the row is proportional to the row number.
 */

public class PascalsTria2 {

    // Function to return the rth row of Pascal's triangle
    public int[] pascalTriangleII(int r) {
        int[] ans = new int[r]; // to store the answer

        // Set the first element of the row as 1
        ans[0] = 1;

        // Compute each element in the rth row
        for (int i = 1; i < r; i++) {
            ans[i] = (ans[i - 1] * (r - i)) / i;
        }

        return ans; // return the result
    }

}
