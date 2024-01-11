package ab_questionInCourse.dsaArray;

public class MultipleLeftRotation {
    public static void main(String[] args) {

        MultipleLeftRotation obj = new MultipleLeftRotation();
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {3, 2};
        int ans[][] = obj.multipleLeftRotation(a,b);

        for(int[] e: ans){
            obj.printArray(e);
            System.out.println();
        }

    }
    void printArray(int a[]){
        for(int e: a){
            System.out.print(e+" ");
        }
    }
    public int[][] multipleLeftRotation(int[] A, int[] B) {
        //You Can Code Here
        int n = A.length;
        int m = B.length;
        int ans[][] = new int[m][n];
        int temp[] = new int[2*n];

        for(int i = 0; i < n; i++){
            temp[i] = A[i];
            temp[i+n] = A[i];
        }

        for(int i = 0; i < m; i++){
            int leftRotate = (B[i]%n);
            System.out.println(leftRotate);
            for(int j = 0; j < n; j++){
                ans[i][j] = temp[leftRotate+j];
            }
        }

        return ans;


    }
}
