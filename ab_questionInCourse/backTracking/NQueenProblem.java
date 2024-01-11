package ab_questionInCourse.backTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {
    public static void main(String[] args) {

        int n = 4;
        List<List<String>> ans = solveNQueens(n);

        for(List<String> e: ans){
            for(String d: e){
                System.out.print(d+" ");
            }
            System.out.println();
        }

    }

    public static List<List<String>> solveNQueens(int n)
    {
        //You can code here
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];

        solveNQueenHelper(board,ans,0);

        return ans;
    }
    static void solveNQueenHelper(char board[][],List<List<String>> ans,int col){

        if(col == board.length){
            saveBoard(board,ans);
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                solveNQueenHelper(board,ans,col+1);
                board[row][col] = '.';
            }
        }

    }

    private static boolean isSafe(char[][] board, int row, int col) {

//        Checking in row & column
        for(int i = 0; i < board.length; i++){
//            Row
            if(board[i][col] == 'Q'){
                return false;
            }
//            Column
            if(board[row][i] == 'Q'){
                return false;
            }
        }
//        Checking in upper left diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
//        Checking in upper right diagonal
        for(int i = row, j = col; i >= 0 && j <board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
//        Checking in lower left diagonal
        for(int i = row, j = col; i < board.length && j >= 0; i++, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
//        Checking in lower right diagonal
        for(int i = row, j = col; i < board.length && j < board.length; i++, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;

    }
    static void saveBoard(char board[][], List<List<String>> ans) {
        List<String> res = new ArrayList<>();
        String cur = "";
        for(int i = 0; i < board.length; i++){
            cur = "";
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'Q'){
                    cur += 'Q';
                }else{
                    cur += '.';
                }
            }
            res.add(cur);
        }
        ans.add(res);
    }
}
