package backTracking.backTracking3;


public class KnightsTour {
    public static void main(String[] args) {

        int n = 5;
        int a[][] = knightsTour(n);

        for(int[] b: a){
            for(int c: b){
                System.out.print(c+" ");
            }
            System.out.println();
        }

    }
    static int[][] knightsTour(int n){
        int a[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = -1;
            }
        }
        a[0][0] = 0;
        int movesX[] = { 2, 1, -1, -2, -2, -1, 1, 2};
        int movesY[] = { 1, 2, 2, -1, 1, -2, -2, -1};
        knightsTourHelper(a,n,0,0,movesX,movesY,1);
        return a;
    }
    static boolean knightsTourHelper(int a[][],int n,int curX, int curY,int movesX[],int movesY[],int step){
        if(step == n * n) return true;

        for(int i = 0; i < 8; i++){
            int nextX = curX + movesX[i];
            int nextY = curY + movesY[i];
            if(isValid(a,n,nextX,nextY)){
                a[nextX][nextY] = step;
                boolean isSafeToContinue = knightsTourHelper(a,n,nextX,nextY,movesX,movesY,step+1);
                if(isSafeToContinue){
                    return true;
                }else{
                    a[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int a[][],int n,int i, int j) {
        return i >= 0 && i < n && j < n && j >= 0 && a[i][j] == -1;
    }
}
