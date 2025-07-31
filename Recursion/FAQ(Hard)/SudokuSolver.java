/*
 * Q. Solve a Sudoku puzzle by filling the empty cells.
 * * The function should take a 9x9 Sudoku board as input and fill the empty cells (denoted by '.') with digits from 1 to 9, ensuring that each row, column, and 3x3 subgrid contains all digits from 1 to 9 without repetition.
 * * Time Complexity: O(9^(n*n)), where n is the size of the Sudoku board (9 in this case). This is because we try to fill each empty cell with digits from 1 to 9, leading to exponential time complexity in the worst case.
 * * Space Complexity: O(n*n) for the recursion stack, where n is the size of the Sudoku board (9 in this case).
 * * Note: The function should handle cases where the Sudoku board is already solved or has no solution by returning false.
 * 
 */


class Solution {

public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Recursive method to solve the Sudoku
    private boolean solve(char[][] board) {
        int n = 9;  // Size of the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Empty cell found
                if (board[i][j] == '.') {  
                    for (char digit = '1'; digit <= '9'; digit++) {
                        // Check if digit can be placed
                        if (areRulesMet(board, i, j, digit)) {  
                            // Place digit
                            board[i][j] = digit;  
                            // Recur to place next digits
                            if (solve(board)) {  
                                return true;
                            } else {
                                // Reset if placing digit doesn't solve Sudoku
                                board[i][j] = '.';  
                            }
                        }
                    }
                    // If no digit can be placed, return false
                    return false;  
                }
            }
        }
        // Sudoku solved
        return true;  
    }

    // Method to check if placing a digit follows Sudoku rules
    private boolean areRulesMet(char[][] board, int row, int col, char digit) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit) {
                // Digit already in row or column
                return false;  
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) {
                    // Digit already in 3x3 sub-box
                    return false;  
                }
            }
        }
        // Digit can be placed
        return true;  
    }
};
