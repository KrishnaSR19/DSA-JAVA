
/*
 * 
Hard
Q.Given a grid of dimensions n x n. A rat is placed at coordinates (0, 0) and wants to reach at coordinates (n-1, n-1).
Find all possible paths that rat can take to travel from (0, 0) to (n-1, n-1). The directions in which rat can move are 'U' (up) , 'D' (down) , 'L' (left) , 'R' (right).
The value 0 in grid denotes that the cell is blocked and rat cannot use that cell for travelling, whereas value 1 represents that rat can travel through the cell. If the cell (0, 0) has 0 value, then mouse cannot move to any other cell.
Note :
In a path no cell can be visited more than once.
If there is no possible path then return empty vector.
 */

/*
 * Time Complexity : The time complexity is O(4^(N^2)) due to recursion exploring all paths in the grid.

Space Complexity :The space complexity is O(N^2) for the recursion stack and result storage.
 */

class Solution {
    // List to store the resulting paths
    List<String> result = new ArrayList<>();

    // Recursive function to find paths
    private void path(int[][] m, int x, int y, String dir, int n) {
        // If destination is reached, add path to result
        if (x == n - 1 && y == n - 1) {
            result.add(dir);
            return;
        }

        // If cell is blocked, return
        if (m[x][y] == 0)
            return;

        // Mark cell as visited by setting it to 0
        m[x][y] = 0;

        // Move up if possible
        if (x > 0)
            path(m, x - 1, y, dir + 'U', n);
        // Move left if possible
        if (y > 0)
            path(m, x, y - 1, dir + 'L', n);
        // Move down if possible
        if (x < n - 1)
            path(m, x + 1, y, dir + 'D', n);
        // Move right if possible
        if (y < n - 1)
            path(m, x, y + 1, dir + 'R', n);

        // Unmark cell as visited by setting it to 1
        m[x][y] = 1;
    }

    public List<String> findPath(int[][] grid) {
        int n = grid.length;

        // Clear previous results
        result.clear();

        // If starting or ending cell is blocked, return empty result
        if (grid[0][0] == 0 || grid[n - 1][n - 1] == 0)
            return result;

        // Start finding paths from (0, 0)
        path(grid, 0, 0, "", n);

        // Sort the result paths
        Collections.sort(result);

        return result;
    }
}
