/*
 * Given an integer n, return the first n (1-Indexed) rows of Pascal's triangle.
In Pascal's triangle:
The first row has one element with a value of 1.
Each row has one more element in it than its previous row.
The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.
*/

/*
 * Time Complexity: O(N2), generating each row takes linear time relative to its size, and there are N rows, leading to a total time complexity of O(N2).
Space Complexity: O(N2), storing the entire Pascal's Triangle requires space proportional to the sum of the first N natural numbers, resulting in O(N2) space complexity.
 */


public class PascalTriagle3 {
    import java.util.*;

class Solution {
    private List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        
        // Inserting the 1st element
        ansRow.add(1); 

        // Calculate the rest of the elements
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        
        return ansRow; // Return the computed row
    }

    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        // Compute the entire Pascal's Triangle
        for (int row = 1; row <= n; row++) {
            pascalTriangle.add(generateRow(row));
        }
        
        //return the pascalTriangle
        return pascalTriangle;
    }
}

class Main {
    public static void main(String[] args) {
        int n = 5;
        Solution sol = new Solution();

        // Generate Pascal's Triangle with n rows
        List<List<Integer>> pascalTriangle = sol.pascalTriangleIII(n);

        // Output the Pascal's Triangle
        for (List<Integer> row : pascalTriangle) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

}
