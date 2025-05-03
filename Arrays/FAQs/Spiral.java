/*
 * Q.Given an M * N matrix, print the elements in a clockwise spiral manner. Return an array with the elements in the order of their appearance when printed in a spiral manner.
 */


/*
 * Time Complexity: O(MxN) since all the elements are being traversed once and there are total N x M elements ( M elements in each row and total N rows) so the time complexity will be O(N x M).
Space Complexity: O(1) as extra space to store answer is not considered.
 */

public class Spiral {
    import java.util.*;

class Solution {
    //Function to print matrix in spiral manner
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        // Number of rows
        int n = matrix.length;

        // Number of columns
        int m = matrix[0].length;
        
        // Initialize pointers for traversal
        int top = 0, left = 0;      
        int bottom = n - 1, right = m - 1;
        
        // Traverse the matrix in spiral order
        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; ++i) {
                ans.add(matrix[top][i]);
            }
            top++;
            
            // Traverse from top to bottom
            for (int i = top; i <= bottom; ++i) {
                ans.add(matrix[i][right]);
            }
            right--;
            
            // Traverse from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        //Return the ans
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        // Create an instance of the Solution class
        Solution finder = new Solution();
        
        // Get spiral order using class method
        List<Integer> ans = finder.spiralOrder(mat);
       
        System.out.print("Elements in spiral order are: ");
        for (int i = 0; i < ans.size(); ++i) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

}
