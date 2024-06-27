package dynamicProgrammingBasics.session_5;

public class LongestRepeatingSubSequence {
    public static void main(String[] args) {

        String a = "AABCBD";

        int ans = longestRepeatingSubSequence(a);

        System.out.println(ans);

    }

    static int longestRepeatingSubSequence(String a){
        int m = a.length();
        int n = m;
        String b = a;

        int arr1[] = new int[n+1];
        int arr2[] = new int[n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n ; j++){
                if(a.charAt(i-1) == b.charAt(j-1) && i-1 != j-1){
                    arr2[j] = arr1[j-1] + 1;
                }else{
                    arr2[j] = Math.max(arr1[j], arr2[j-1]);
                }
            }
            for(int j = 1; j <= n; j++){
                arr1[j] = arr2[j];
            }
        }
        return arr2[n];
    }
}
