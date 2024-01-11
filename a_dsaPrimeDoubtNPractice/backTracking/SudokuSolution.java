package a_dsaPrimeDoubtNPractice.backTracking;

public class SudokuSolution {
    public static void main(String[] args) {
        char board[][] = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
    }
    public static void solveSudoku(char[][] board) {
        //You can code here
        print(board);
    }

    public static void print(char[][] board) {
        if (sudokuHelper(board, 0, 0));
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }

    }

    public static boolean isSafe(char[][] board, int row, int col, char num) {
        for(int x = 0; x < board.length; x++) {
            if(board[row][x] == (char)(num + '0')) {
                return false;
            }
        }

        for(int x = 0; x < board.length; x++) {
            if(board[x][col] == (char)(num + '0')) {
                return false;
            }
        }

        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == (char) (num + '0')) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean sudokuHelper(char[][] board, int row, int col ) {
        if (row == board.length) return true;

        if (col == board.length) {
            return sudokuHelper(board, row+1, 0);
        }

        if (board[row][col] != '.') {
            return sudokuHelper(board, row, col+1);
        }

        for(char num = 1; num <= 9; num++) {
            if(isSafe(board, row, col, num)) {
                board[row][col] = (char)(num + '0');

                if (sudokuHelper(board, row, col+1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
}
