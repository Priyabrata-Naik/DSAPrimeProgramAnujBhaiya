package a_dsaPrimeDoubtNPractice.dsaArray;

public class EvenDigitCount {
    public static void main(String[] args) {

        int a[] = {12, 3, 6, 2344, 123, 35};
        int res = evenDigitCount(a);

        System.out.println(res);

    }
    static int evenDigitCount(int a[]){
        int count = 0;
        int n = a.length;

        for(int i = 0; i < n; i++){
            int step = 0;
            int temp = a[i];
            while(temp > 0){
                temp /= 10;
                step++;
            }
            if((step % 2) == 0){
                count++;
            }
        }
        return count;
    }
}
