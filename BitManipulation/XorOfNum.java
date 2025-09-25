/*
 * Q.Given two integers L and R. Find the XOR of the elements in the range [L , R].
 */

/*
 * Time Complexity: O(N) Traversing through all the numbers take O(N) time.
Space Complexity: O(1) Using only a couple of variables, i.e., constant space.
 */

 class Solution {

    /* Function to find the XOR 
    of numbers from L to R */
    public int findRangeXOR(int l, int r) {
        
        // To store the XOR of numbers
        int ans = 0;
        
        // XOR all the numbers
        for (int i = l; i <= r; i++) {
            ans ^= i;
        }
        
        // Return the result
        return ans;
    }
}


/*
 * Optimal
 * Time Complexity: O(1) Using constant time operations.
Space Complexity: O(1) Using a couple of variables i.e., constant space.
 */
class Solution {
    /* Function to find the XOR 
    of numbers from 1 to n */
    private int XORtillN(int n) {
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n + 1;
        if(n % 4 == 3) return 0;
        return n;
    }
    
    /* Function to find the XOR 
    of numbers from L to R */
    public int findRangeXOR(int l, int r) {
        return XORtillN(l - 1) ^ XORtillN(r);
    }
}


