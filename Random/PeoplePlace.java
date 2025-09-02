/*
 * LeetCode Problem 3025 : Find the number of ways to place people
 */

class Solution {
    public int countPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                // Check if A (i) is upper-left of B (j)
                if (x1 <= x2 && y1 >= y2) {
                    int xmin = Math.min(x1, x2);
                    int xmax = Math.max(x1, x2);
                    int ymin = Math.min(y1, y2);
                    int ymax = Math.max(y1, y2);

                    boolean valid = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;

                        int x = points[k][0], y = points[k][1];
                        // If any other point lies inside or on the rectangle
                        if (xmin <= x && x <= xmax && ymin <= y && y <= ymax) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) count++;
                }
            }
        }

        return count;
    }
}
