package ab_questionInCourse.backTracking;

public class KnightTour {
    public static void main(String[] args) {

        int a[][] = knightTour(5,5);

        for(int[] e: a){
            for(int d: e){
                System.out.print(d+" ");
            }
            System.out.println();
        }

    }
    public static int[][] knightTour(int n, int m) {
        //You can code here
        int a[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];
        vis[0][0] = true;


        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                a[i][j] = -1;
            }
        }
        a[0][0] = 0;

        int moveX[] = {2, 2, 1, -1, -2, -2, -1, 1};
        int moveY[] = {1, -1, -2, -2, -1, 1, 2, 2};
        knightTourHelper(a,moveX,moveY,1,0,0,vis,n,m);
        return a;

    }
    static boolean knightTourHelper(int a[][], int moveX[], int moveY[],int step, int curX, int curY,boolean vis[][],
                                    int n, int m){
        if(step == n * m){
            return true;
        }
        for(int i = 0; i < 8 ; i++){
            int nextX = curX + moveX[i];
            int nextY = curY + moveY[i];
            if(isSafe(a,nextX,nextY,n,m,vis)){
                a[nextX][nextY] = step;
                vis[nextX][nextY] = true;
                boolean isSafeToContinue = knightTourHelper(a,moveX,moveY,step+1,nextX,nextY,vis,n,m);
                if(isSafeToContinue){
                    a[0][0] = 0;
                    return true;
                }else{
                    a[nextX][nextY] = -1;
                    vis[nextX][nextY] = false;
                }
            }else{
                a[0][0] = -1;
            }
        }
        return false;
    }
    static boolean isSafe(int a[][],int i, int j,int n, int m,boolean vis[][]){
        return i < n && i >= 0 && j < m && j >= 0 && !vis[i][j] && a[i][j] == -1;
    }
}
