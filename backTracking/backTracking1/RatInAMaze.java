package backTracking.backTracking1;

public class RatInAMaze {
    public static void main(String[] args) {

        int mat[][] = {
                { 1, 1, 1},
                { 0, 1, 1},
                { 1, 1, 1}
        };
        int mat2[][] = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 1}
        };
        int n = mat2.length;
        int m = mat2[0].length;

        boolean vis[][] = new boolean[n][m];
        vis[0][0] = true;

//        ratInAMaze(mat,vis,0,0,n,m,"");

        int res = rateInAMazeCount(mat2,vis,0,0,n,m);
        System.out.println(res);
    }

    //    GIVING WRONG OUTPUT STILL NEED OPTIMISATION (PLS FOLLOW THIS) DO NOT DRY RUN THIS CODE
    static int rateInAMazeCount(int mat[][],boolean vis[][],int i, int j,int n,int m){
        if(i == n-1 && j == m - 1){
            return 1;
        }
//        Down
        int totalCount = 0;
        if(isValid(mat,vis,i+1,j,n,m)){
            vis[i+1][j] = true;
            totalCount +=  rateInAMazeCount(mat,vis,i+1,j,n,m) ;
            vis[i+1][j] = false;
        }
//       Left
//        int left = 0;
        if(isValid(mat,vis,i,j-1,n,m)){
            vis[i][j-1] = true;
            totalCount += rateInAMazeCount(mat,vis,i,j-1,n,m) ;
            vis[i][j-1] = false;
        }
//        Right
//        int right = 0;
        if(isValid(mat,vis,i,j+1,n,m)){
            vis[j+1][j] = true;
            totalCount += rateInAMazeCount(mat,vis,i,j+1,n,m);
            vis[j+1][j] = false;
        }
//        Up
//        int up = 0;
        if(isValid(mat,vis,i-1,j,n,m)){
            vis[i-1][j] = true;
            totalCount += rateInAMazeCount(mat,vis,i-1,j,n,m) ;
            vis[i-1][j] = false;
        }
        return totalCount;
    }
    static void ratInAMaze(int mat[][], boolean vis[][], int i, int j, int n, int m, String path){
        if( i == n - 1 && j == m - 1){
            System.out.println(path);
            return;
        }
//        Down
        if(isValid(mat,vis,i+1,j,n,m)){
            vis[i+1][j] = true;
            ratInAMaze(mat,vis,i+1,j,n,m,path+'D');
            vis[i+1][j] = false;
        }
//        Left
        if(isValid(mat,vis,i,j-1,n,m))  {
            vis[i][j-1] = true;
            ratInAMaze(mat,vis,i,j-1,n,m,path+'L');
            vis[i][j-1] = false;
        }
//        Right
        if(isValid(mat,vis,i,j+1,n,m)){
            vis[i][j+1] = true;
            ratInAMaze(mat,vis,i,j+1,n,m,path+'R');
            vis[i][j+1] = false;
        }
//        Up
        if(isValid(mat,vis,i-1,j,n,m)){
            vis[i-1][j] = true;
            ratInAMaze(mat,vis,i-1,j,n,m,path+'U');
            vis[i-1][j] = false;
        }
    }
    static boolean isValid(int mat[][], boolean vis[][],int i, int j,int n, int m){
        if(i < n && i >= 0 && j < m && j >= 0 && vis[i][j] == false && mat[i][j] == 1){
            return true;
        }
        return false;
    }
}
