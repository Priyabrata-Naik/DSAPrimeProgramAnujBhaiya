package backTracking.backTrackingLiveSession1;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {

//        String input = "23";
//        List<String> ans = smartKeypad(input);
//
//        for(String e: ans){
//            System.out.println(e);
//        }

//        String s = "abbaca";
//        List<List<String>> ans = palindromicPartitioning(s);
//        for(List<String> e: ans){
//            for(String d: e){
//                System.out.print(d+" ");
//            }
//            System.out.println();
//        }

        int mat[][] = {
                {7, 0, 0, 0, 0, 0, 2, 0, 0},
                {4, 0, 2, 0, 0, 0, 0, 0, 3},
                {0, 0, 0, 2, 0, 1, 0, 0, 0},
                {3, 0, 0, 1, 8, 0, 0, 9, 7},
                {0, 0, 9, 0, 7, 0, 6, 0, 0},
                {6, 5, 0, 0, 3, 2, 0, 0, 1},
                {0, 0, 0, 4, 0, 9, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 1, 0, 6},
                {0, 0, 6, 0, 0, 0, 0, 0, 8}
        };

        sudoku(mat,0,0);

        for(int[] e: mat){
            for(int d: e){
                System.out.print(d+" ");
            }
            System.out.println();
        }

    }
    static boolean isSafe(int a[][], int row, int col, int num){
//        Checking num if present in row
        for(int i = 0; i < 9; i++){
            if(num == a[i][col]){
                return false;
            }
        }
//        Checking num if present in col
        for(int j = 0; j < 9; j++){
            if(num == a[row][j]){
                return false;
            }
        }
//        Checking num if present in 3 * 3  box
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(a[i+startRow][j+startCol] == num){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean sudoku(int a[][], int row, int col){
        if(row == 9)
            return true;
        if(col == 9){
            return sudoku(a,row+1,0);
        }
        if(a[row][col] != 0){
            return sudoku(a,row,col+1);
        }

        for(int i = 1; i <= 9; i++){
            if(isSafe(a,row,col,i)){
                a[row][col] = i;
                if(sudoku(a,row,col+1)){
                    return true;
                }
                a[row][col] = 0;
            }
        }
        return false;
    }
    static List<List<String>> palindromicPartitioning(String s){
        List<List<String>> ans = new ArrayList<>();
        palindromicHelper(s,ans,0,new ArrayList<>());
        return ans;
    }
    static boolean isPalindrome(String s,int l,int r){
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    static void palindromicHelper(String s,List<List<String>> ans,int index,List<String> cur){
        if(index == s.length()){
            List<String> copyCur = new ArrayList<>(cur);
            ans.add(copyCur);
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                cur.add(s.substring(index,i+1));
                palindromicHelper(s,ans,i+1,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    static List<String> smartKeypad(String input){
        String a[] = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        List<String> ans = new ArrayList<>();
        smartKeypadHelper(input,0,ans,"",a);
        return ans;
    }
    static void smartKeypadHelper(String input,int index,List<String> ans,String cur,String a[]){

        if(index == input.length()){
            ans.add(cur);
            return;
        }

//        Doubt clearing
//        String s = "21";
//        String a[] = {"","abc","def"};
//        System.out.println(a[s.charAt(0)-'0']);
//        Ascii value of 2 is 50 & 0 is 48 which returns 2 in array
        String present = a[input.charAt(index)-'0'];
        for(int i = 0; i < present.length(); i++){
//            This is the help of backTracking
//            cur = cur + present.charAt(i);
//            smartKeypadHelper(input,index+1,ans,cur,a);
//            cur = cur.substring(0,cur.length()-1);
            smartKeypadHelper(input,index+1,ans,cur+present.charAt(i),a);
        }
    }
}
