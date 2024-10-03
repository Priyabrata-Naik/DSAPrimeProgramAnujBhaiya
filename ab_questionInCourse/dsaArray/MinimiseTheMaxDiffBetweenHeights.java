package ab_questionInCourse.dsaArray;

import java.util.Arrays;

public class MinimiseTheMaxDiffBetweenHeights {
    public static void main(String[] args) {

        int a[] = {1, 15, 10};
        int n = a.length;
        int k = 6;

        System.out.println(getMinDiffSolApp_(a, n, k));

    }

    static int getMinDiffSolApp_(int a[], int n, int k){

        if(a == null || n == 0 || n == 1) return 0;
        Arrays.sort(a);
        int eleMin = a[0];
        int eleMax = a[n-1];
        int ans = 0;
        if(n == 2 || (eleMax == eleMin)){
            int tempMin = eleMin + k;
            int tempMax = eleMax - k;
            return Math.abs(tempMax - tempMin);
        }

        int balDiff = eleMax >> 1;
        int median = n >> 1;
        int medVal = a[median];
        int tempMedVal = medVal;
        int tempMedian = median;
        int start = 0;
        int end = n-1;
        int size = 0;
        int prevTempMedian = 0;

//        System.out.println(tempMedVal);

        if((median & 1) != 0){
            if(tempMedVal >= balDiff){
                size = tempMedian + 1;
                while(tempMedVal >= (eleMax >> 1)){
                    for(int i = end; i >= tempMedian; i--){
                        a[i] = a[i] - k;
                    }
                    end = tempMedian - 1;
                    prevTempMedian = tempMedian;
                    tempMedian = (start + tempMedian) >> 1;
                    tempMedVal = a[tempMedian];
                    if(tempMedVal >= (eleMax >> 1) && tempMedian == 0){
                        tempMedian += 1;
                        break;
                    }
                }
                if(tempMedVal < balDiff) tempMedian = prevTempMedian;
                int pos = (tempMedian + end + 1) >> 1;

                int tempNewMedian = a[pos];
                if(tempNewMedian >= balDiff && tempMedian < end && tempMedVal < balDiff){
                    for(int i = pos; i <= end; i++){
                        a[i] = a[i] - k;
                    }
                }
                for(int i = 0; i < tempMedian; i++){
                    a[i] = a[i] + k;
                }

//                for(int e: a){
//                    System.out.println(e);
//                }

            }else{
                while(tempMedVal <= balDiff){
                    for(int i = start; i <= tempMedian; i++){
                        a[i] = a[i] + k;
                    }
                    start = tempMedian + 1;
                    prevTempMedian = tempMedian;
                    tempMedian = (tempMedian + end) >> 1;
                    int prevVal = tempMedVal;
                    tempMedVal = a[tempMedian];
                    if(prevVal == tempMedVal) break;
                }
                if(tempMedVal < balDiff) tempMedian = prevTempMedian;
                for(int i = end; i > tempMedian; i--){
                    a[i] = a[i] - k;
                }
            }
        }else{
            int secondMedian = tempMedian - 1;
            int secondMedVal = a[secondMedian];
            if(tempMedVal >= balDiff){
                if(secondMedVal >= balDiff){
                    while(secondMedVal >= balDiff){
                        for(int i = end; i >= secondMedian; i--){
                            a[i] = a[i] - k;
                        }
                        end = secondMedian - 1;
                        secondMedian = (start + secondMedian) >> 1;
                        secondMedVal = a[secondMedian];
                    }
                    for(int i = 0; i < secondMedian; i++){
                        a[i] = a[i] + k;
                    }
                }else{
                    for(int i = 0; i <= secondMedian; i++){
                        a[i] = a[i] + k;
                    }
                    for(int i = end; i > secondMedian; i--){
                        a[i] = a[i] - k;
                    }
                }
            }else{
                while(tempMedVal <= balDiff){
                    for(int i = start; i <= tempMedian; i++){
                        a[i] = a[i] + k;
                    }
                    start = tempMedian + 1;
                    tempMedian = (tempMedian + end) >> 1;
                    tempMedVal = a[tempMedian];
                }
                for(int i = end; i > tempMedian; i--){
                    a[i] = a[i] - k;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int max = -1;

        for(int e: a){
            min = Math.min(min, e);
            max = Math.max(max, e);
        }

        return max - min;

    }

    public static int getMinDiff(int[] a, int n, int k) {
        //You can code here

        if(a == null || n == 0 || n == 1) return 0;
        Arrays.sort(a);
        int eleMin = a[0];
        int eleMax = a[n-1];
        int ans = 0;
        if(n == 2){
            int tempMin = eleMin + k;
            int tempMax = eleMax - k;
            return Math.abs(tempMax - tempMin);
        }

        int median = n >> 1;
        int medVal = a[median];
        int tempMedVal = medVal;
        int tempMedian = median;
        int start = 0;
        int end = n-1;

        if((median & 1) != 0){

            if(tempMedVal <= (eleMax >> 1)){
                while(tempMedVal <= (eleMax >> 1)){
                    for(int i = start; i <= tempMedian; i++){
                        a[i] = a[i] + k;
                    }
                    start = tempMedian;
                    tempMedian = (tempMedian + end) >> 1;
                    int prevMedVal = tempMedVal;
                    tempMedVal = a[tempMedian];
                    if(tempMedVal == prevMedVal) break;
                }
                for(int i = tempMedian + 1; i < n; i++){
                    a[i] = a[i] - k;
                }
                int min = Integer.MAX_VALUE;
                int max = -1;
                for(int e: a){
                    min = Math.min(min, e);
                    max = Math.max(max, e);
                }

                return max - min;

            }else if(tempMedVal >= (eleMax >> 1)){
                while(tempMedVal >= (eleMax >> 1)){
                    for(int i = end; i >= tempMedian; i--){
                        a[i] = a[i] - k;
                    }
                    end = tempMedian;
                    tempMedian = (tempMedian + start) >> 1;
                    tempMedVal = a[tempMedian];
                }
                for(int i = 0; i < tempMedian; i++){
                    a[i] = a[i] + k;
                }
                int min = Integer.MAX_VALUE;
                int max = -1;
                for(int e: a){
                    min = Math.min(min, e);
                    max = Math.max(max, e);
                }
                return max - min;
            }

        }else{
            int secondMed = tempMedian - 1;
            int secondMedVal = a[secondMed];

            if((tempMedVal >= (eleMax >> 1))){
                if(secondMedVal >= (eleMax >> 1)){
                    while(secondMedVal >= (eleMax >> 1)){
                        for(int i = end; i >= secondMed; i--){
                            a[i] = a[i] - k;
                        }
                        end = secondMed;
                        secondMed = (start + secondMed) >> 1;
                        secondMedVal = a[secondMed];
                    }
                    for(int i = 0; i < end; i++){
                        a[i] = a[i] + k;
                    }

                }else{
                    while(secondMedVal <= (eleMax >> 1)){
                        for(int i = end; i >= tempMedian; i--){
                            a[i] = a[i] - k;
                        }
                        break;
                    }
                    for(int i = 0; i < tempMedian; i++){
                        a[i] = a[i] + k;
                    }
                }

            }else{
                for(int i = end; i > tempMedian; i--){
                    a[i] = a[i] - k;
                }
                for(int i = 0; i <= tempMedian; i++){
                    a[i] = a[i] + k;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int max = -1;
        for(int e: a){
            min = Math.min(min, e);
            max = Math.max(max, e);
        }

        return max - min;
    }
}
