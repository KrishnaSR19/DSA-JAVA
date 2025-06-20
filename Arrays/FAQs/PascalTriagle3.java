/*
 * Given an integer n, return the first n (1-Indexed) rows of Pascal's triangle.
In Pascal's triangle:
The first row has one element with a value of 1.
Each row has one more element in it than its previous row.
The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.
*/

/*
 * A naive way to solve this problem will be to calculate the element n and c (where n is the given row number and c is the column number that will vary from 1 to n) for every column from 1 to n and for every row, using the process used in Pascal Triangle-I. However, this will result in an O(N3) time complexity.

A better way to solve this problem will be to generate every row from 1 to n using the method discussed in Pascal Triangle-II and store the entire Pascal's Triangle in a 2D list. Once the entire Pascal's Triangle is generated, we can return the triangle.
 */



/*
  Optimal
 * Time Complexity: O(N2), generating each row takes linear time relative to its size, and there are N rows, leading to a total time complexity of O(N2).
Space Complexity: O(N2), storing the entire Pascal's Triangle requires space proportional to the sum of the first N natural numbers, resulting in O(N2) space complexity.
 */

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

        // return the pascalTriangle
        return pascalTriangle;
    }
}
