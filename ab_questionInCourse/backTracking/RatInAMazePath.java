package ab_questionInCourse.backTracking;

import java.util.ArrayList;

public class RatInAMazePath {

    public static void main(String[] args) {

        int a[][] = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int n = 3;

        ArrayList<String> ans = findPath(a,n);

        System.out.println(ans);

    }

    public static ArrayList< String > findPath(int[][] arr, int n) {
        //You can code here

        ArrayList<String> ans = new ArrayList<>();

        if(arr[0][0] == 0) return ans;
        // findPathHelper(arr,n,ans,"",0,0);
        helper(arr,n,ans);

        return ans;
    }
    public static void helper(int a[][],int n,ArrayList<String> ans){
        int r = a.length;
        int c = a[0].length;
        boolean vis[][] = new boolean[r][c];
        vis[0][0] = true;
        findPathHelper(a,n,ans,"",0,0,vis);
    }

    public static void findPathHelper(int a[][],int n,ArrayList<String> ans,String cur,int i, int j,boolean vis[][]){
        if(i == n-1 && j == n - 1){
            ans.add(cur);
            return ;
        }

        if(a[0][0] != 1){
            ans.add(cur);
            return;
        }

//        Down move
        if(isSafe(a,n,i+1,j,vis)){
            vis[i+1][j] = true;
            findPathHelper(a,n,ans,cur+'D',i+1,j,vis);
//            ans.add(cur);
            vis[i+1][j] = false;
        }
//        Left Move
        if(isSafe(a,n,i,j-1,vis)){
            vis[i][j-1] = true;
            findPathHelper(a,n,ans,cur+'L',i,j-1,vis);
            vis[i][j-1] = false;
        }
//        Right move
        if(isSafe(a,n,i,j+1,vis)){
            vis[i][j+1] = true;
            findPathHelper(a,n,ans,cur+'R',i,j+1,vis);
            vis[i][j+1] = false;
        }
//        Up move
        if(isSafe(a,n,i-1,j,vis)){
            vis[i-1][j] = true;
            findPathHelper(a,n,ans,cur+'U',i-1,j,vis);
            vis[i-1][j] = false;
        }
    }

    private static boolean isSafe(int a[][],int n,int i,int j,boolean vis[][]) {
        return i < n && i >= 0 && j < n && j >= 0 && vis[i][j] == false && a[i][j] == 1;
    }

}
