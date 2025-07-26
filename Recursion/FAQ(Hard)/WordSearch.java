/*
 * Q.Given a grid of n x m dimension grid of characters board and a string word.The word can be created by assembling the letters of successively surrounding cells, whether they are next to each other vertically or horizontally. It is forbidden to use the same letter cell more than once.
Return true if the word exists in the grid otherwise false.
 */

/*
 * Time Complexity : O(N * M * 4^L) where N is rows, M is columns and L is the word length; recursive search through board.
Space Complexity : O(L) due to recursive call stack depth, where L is the length of the word.
 */

class Solution {
    // Helper function to check if the word exists starting from cell (i, j)
    private boolean func(char[][] board, int i, int j, String word, int k) {
        // If all characters of the word are found
        if (k == word.length()) {
            return true;
        }
        // Boundary conditions and character mismatch check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(k) != board[i][j]) {
            return false;
        }

        // Temporarily mark the cell as visited
        char temp = board[i][j];
        board[i][j] = ' ';

        // Check all four possible directions (down, up, right, left)
        boolean ans = func(board, i + 1, j, word, k + 1) ||
                func(board, i - 1, j, word, k + 1) ||
                func(board, i, j + 1, word, k + 1) ||
                func(board, i, j - 1, word, k + 1);

        // Restore the original character in the cell
        board[i][j] = temp;

        return ans;
    }

    // Main function to check if the word exists in the board
    public boolean exist(char[][] board, String word) {
        // Iterate through each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the first character matches, start the search
                if (board[i][j] == word.charAt(0)) {
                    // If the word is found, return true
                    if (func(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        // If the word is not found, return false
        return false;
    }
}
