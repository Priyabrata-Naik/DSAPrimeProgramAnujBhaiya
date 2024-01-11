package stack.live_session_1;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {

        int a[] = {1, 4, 2, 3, 5};
        int res = shortestUnsortedSubarray(a);

        System.out.println(res);

    }
    static int shortestUnsortedSubarray(int a[]){
        int n = a.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int startInd = -1;
        int endInd = -1;

        for(int i = 0; i < n; i++){
            if(a[i] > max){
                max = a[i];
            }else if(a[i] < max){
                endInd = i;
            }
        }
        if(endInd == -1){
            return 0;
        }
        for(int i = n-1; i >= 0; i--){
            if(a[i] < min){
                min = a[i];
            }else if(a[i] > min){
                startInd = i;
            }
        }
        return endInd-startInd+1;
    }
}
