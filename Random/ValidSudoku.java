/*
 * Q. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 * Given a 9x9 Sudoku board, determine if it is valid.
 * Only the filled cells need to be validated according to the following rules:
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3x3 sub-boxes must contain the digits 1-9 without repetition.
 */


 import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Array of 9 sets for rows, columns, and boxes
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // Initialize each set
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse every cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                // Skip empty cells
                if (num == '.') continue;

                // Calculate box index
                int boxIndex = (i / 3) * 3 + (j / 3);

                // Check for duplicates
                if (rows[i].contains(num) ||
                    cols[j].contains(num) ||
                    boxes[boxIndex].contains(num)) {
                    return false;
                }

                // Add to sets
                rows[i].add(num);
                cols[j].add(num);
                boxes[boxIndex].add(num);
            }
        }

        return true; // All checks passed
    }
}
