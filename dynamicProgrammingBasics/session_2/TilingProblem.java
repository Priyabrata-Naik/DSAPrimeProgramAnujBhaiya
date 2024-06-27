package dynamicProgrammingBasics.session_2;

public class TilingProblem {
    public static void main(String[] args) {

        int n = 5;

        int ans = tilingProblem(n);

        System.out.println(ans);

    }
    static int tilingProblem(int n){
        if(n <= 1) return 1;
        int first = 1;
        int second = 1;

        for(int i = 2; i <= n; i++){
            int ans = first + second;
            first = second;
            second = ans;
        }
        return second;
    }
}
