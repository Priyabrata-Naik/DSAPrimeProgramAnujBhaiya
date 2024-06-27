package hashingAndHashMaps.liveSession_1;

import java.util.HashMap;
import java.util.Map;

public class SumOfAllSubMatrices {
    public static void main(String[] args) {

        int mat[][] = {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2}
        };
        int k = 8;
        int ans = countMatricesWithGivenSum(mat,k);

        System.out.println(ans);

    }
    static int countMatricesWithGivenSum(int a[][], int target){
        int rows = a.length;
        int cols = a[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
//        Preprocessing
        for(int i = 0; i < rows; i++){
            for(int j = 1; j < cols; j++){
                a[i][j] += a[i][j-1];
            }
        }
        for(int i = 0; i < cols; i++){
            for(int j = i; j < cols; j++){
                int sum = 0;
                map.clear();
                map.put(0, 1);
                for(int k = 0; k < rows; k++){
                    sum += (a[k][j] - (i > 0 ? a[k][i-1] : 0));
                    int freq = map.getOrDefault(sum-target, 0);
                    ans += freq;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return ans;
    }
    static int countSumOfAllSubMatricesBruteForce(int mat[][], int target){
        int count = 0;
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < m; j++){
                for(int k = 0; k < n; k++){
                    for(int l = 0; l < m; l++){
                        for(int x = i; x < k; x++){
                            for(int y = j; y < l; y++){
                                sum += mat[i][j];
                                if(sum == target){
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
