package ab_questionInCourse.dsaArray;

public class SpiralOrderMatrixII {
    public static void main(String[] args) {

        int n = 4;
        int res[][] = spiralOrderMatrixSolution(n);

        for(int e[]: res){
            for(int d: e){
                System.out.print(d+" ");
            }
            System.out.println();
        }

    }

    static int[][] spiralOrderMatrixSolution(int n){
        int[][] ans = new int[n][n];
        int r1 = 0, r2 = n-1;
        int c1 = 0, c2 = n-1;
        int val = 1;

        while(r1 <= r2 && c1 <= c2){
//            move from left to right
            for(int i = c1; i <= c2; i++){
                ans[r1][i] = val++;
            }
//            move to down
            for(int i = r1+1; i <= r2; i++){
                ans[i][c2] = val++;
            }
//            move right to left
//            move up
            if(r1 < r2 && c1 < c2){
//                move right to left
                for(int i = c2-1; i > c1; i--){
                    ans[r2][i] = val++;
                }
//                move up
                for(int i = r2; i > r1; i--){
                    ans[i][c1] = val++;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

//    Partially solved , still need proper logic
    static int[][] spiralOrderMatrix(int n){
        int matrix[][] = new int[n][n];
        boolean marked[][] = new boolean[n][n];
        int rowCount = 0, colCount = 0;
        int i = 0, j = 0;
        int count = 1;

        while(count <= n * n){
            while(j < n - colCount){
                matrix[i][j] = count;
                count++;
                j++;
            }
            System.out.println("1st while " + count);
            if(j == (n - colCount)){
                j = n - colCount -1;
            }
            while(i < n - rowCount){
                matrix[i][j] = count;
                count++;
                i++;
            }
            if(i == (n - rowCount)){
                i = n - rowCount - 1;
            }
            rowCount++;
            while(j >= colCount){
                matrix[i][j] = count;
                count++;
                j--;
            }
            j = j + 1;
            while(i >= rowCount){
                matrix[i][j] = count;
                count++;
                i--;
            }
            i = i+1;
            colCount++;
        }

        return matrix;
    }
}
