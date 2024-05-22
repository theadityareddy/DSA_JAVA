public class l05sudokuSolver {

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // base case
        if (row == 9) {
            return true;
        }

        // recurssion
        // calculate newRow and newCol
        int newRow = row, newCol = col + 1;
        if (newCol == 9) {
            newRow = row + 1;
            newCol = 0;
        }

        // if number is already placed, go to next step
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, newRow, newCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isValid(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, newRow, newCol)) { // solution exists for next step
                    return true;
                }
                sudoku[row][col] = 0; // if solution doesnt exist, revert back to 0
            }
        }

        return false;
    }

    public static boolean isValid(int[][] sudoku, int row, int col, int digit) {
        // row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        // col
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // grid
        int startingRow = (row / 3) * 3; // 0 for row0, row1, row2 | 1 for row3, row4, row5 | 2 for row6, row7, row8
        int startingCol = (col / 3) * 3; // 0 for row0, row1, row2 | 1 for row3, row4, row5 | 2 for row6, row7, row8

        for (int i = startingRow; i < startingRow + 3; i++) {
            for (int j = startingCol; j < startingCol; i++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };

        if (sudokuSolver(sudoku, 0, 0)) {
            printSudoku(sudoku);
            System.out.println("Solution exists");
        } else {
            System.out.println("Solution doesnt exist");
        }
    }
}
