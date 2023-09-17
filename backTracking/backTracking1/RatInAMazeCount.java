package backTracking.backTracking1;

public class RatInAMazeCount {
    public static void main(String[] args) {
        int mat[][] = {
                {1, 1, 0},
                {1, 1, 0},
                {1, 1, 1}
        };
        int n = mat.length; // row
        int m = mat[0].length; // column

        int res = ratInAMazeCount(mat,0,0,n,m);

        System.out.println(res);


    }
    static int ratInAMazeCount(int mat[][],int i, int j, int n, int m){
        boolean vis[][] = new boolean[n][m];
        return ratInAMazeCount(mat,vis,i,j,n,m);
    }
    static int ratInAMazeCount(int mat[][],boolean vis[][],int i, int j,int n, int m){
        if( i == n - 1 && j == m - 1){
            return 1;
        }
        if (isSafe(mat,vis,i,j,n,m)){
            vis[i][j] = true;
            int totalCount = 0;
//            Move Down
            if(i+1 < n){
                totalCount += ratInAMazeCount(mat,vis,i+1,j,n,m);
            }
//            Move left
            if(j - 1 >= 0){
                totalCount += ratInAMazeCount(mat,vis,i,j-1,n,m);
            }
//            Move Right
            if(j + 1 < m){
                totalCount += ratInAMazeCount(mat,vis,i,j+1,n,m);
            }
//            Move Up
            if(i - 1 >= 0){
                totalCount += ratInAMazeCount(mat,vis,i-1,j,n,m);
            }
            vis[i][j] = false;
            return totalCount;
        }
        return 0;
    }
    static boolean isSafe(int mat[][],boolean vis[][],int i, int j , int n, int m){
        if(i < n && i >= 0 && j < m && j >= 0 && vis[i][j] == false && mat[i][j] == 1){
            return true;
        }
        return false;
    }
}
