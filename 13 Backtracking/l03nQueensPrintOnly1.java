public class l03nQueensPrintOnly1 {
    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        // Initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
        if (nQueens(board, 0)) {
            System.out.println(" \nThere is a solution\n");
        } else {
            System.out.println("There is no soln");
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("\n------ CHESS BOARD ------\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean nQueens(char[][] board, int row) {

        // Base case
        if (row == board.length) {
            printBoard(board);
            return true;
        }
        // Column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueens(board, row + 1)) {
                    return true;
                }
                board[row][j] = 'x'; // backtrack
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        // check on top
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // check diagonal to left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // check diagonal to right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
