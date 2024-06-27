package ab_questionInCourse.dsaArray;

public class SpiralOrderMatrixII {
    public static void main(String[] args) {

        int n = 4;
        int res[][] = spiralOrderMatrix(n);

        for(int e[]: res){
            for(int d: e){
                System.out.print(d+" ");
            }
            System.out.println();
        }

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
