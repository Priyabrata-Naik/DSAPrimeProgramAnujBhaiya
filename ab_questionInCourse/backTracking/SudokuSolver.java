package ab_questionInCourse.backTracking;

public class SudokuSolver {
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
        for(char[] e: board){
            for(char d: e){
                System.out.print(d+" ");
            }
            System.out.println();
        }
    }
    public static void solveSudoku(char[][] board) {
        //You can code here
        sudokuHelper(board,0,0);
    }
    static boolean sudokuHelper(char board[][],int row, int col){
        if(row == 9){
            return true;
        }
        if(col == 9){
            return sudokuHelper(board,row+1,0);
        }
        if(board[row][col] != '.'){
            return sudokuHelper(board,row,col+1);
        }

        for(int i = 1; i <= 9; i++){
            if(isValid(board,row,col,i)){
                board[row][col] = (char) (i + '0');
                boolean solvable = sudokuHelper(board,row,col+1);
                if(solvable){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    static boolean isValid(char board[][],int row, int col,int value){
        for(int i = 0; i < board.length; i++){
//            Checking in row
           if(board[row][i] == (char) (value + '0')){
               return false;
           }
//           Checking in column
           if(board[i][col] == (char) (value + '0')){
               return false;
           }
        }
//        Checking in 3*3 boxes
//        for(int i = 0 ; i < 3; i++){
//            for(int j = 0; j < 3; j++){
//                if((i+1) < 3 && (j+1) < 3 && board[i+1][j+1] == (char) (value + '0')){
//                    return false;
//                }
//            }
//        }
//        Checking in 3*3 boxes
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == (char) (value + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

}
