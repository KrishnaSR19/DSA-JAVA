public class PascalTriangle1 {
    import java.util.*; 

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
