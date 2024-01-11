package dsaArray.liveSession_2;

public class SortColor {
    public static void main(String[] args) {

        int a[] = { 1, 2, 0, 1, 2, 0, 2, 1};
//        sortColorBruteForce(a);
        sortColorOp(a);

        for(int e: a){
            System.out.print(e+" ");
        }

    }

    static void sortColorOp(int a[]){
        int low = 0, mid = 0, high = a.length-1;

        while(mid <= high){
            if(a[mid] == 2){
                a[mid] = a[high];
                a[high] = 2;
                high--;
            }else if(a[mid] == 0){
                a[mid] = a[low];
                a[low] = 0;
                mid++;
                low++;
            }else {
                mid++;
            }
        }
    }
    static void sortColorBruteForce(int a[]){
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        int n = a.length;

        for(int i = 0; i < n; i++){
            if(a[i] == 0){
                countZero++;
            }else if(a[i] == 1){
                countOne++;
            }else{
                countTwo++;
            }
        }
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < n; i++){
            if(count0 < countZero){
                a[i] = 0;
                count0++;
            }else if(count1 < countOne){
                a[i] = 1;
                count1++;
            }else if(count2 < countTwo){
                a[i] = 2;
                count2++;
            }
        }
    }

}
