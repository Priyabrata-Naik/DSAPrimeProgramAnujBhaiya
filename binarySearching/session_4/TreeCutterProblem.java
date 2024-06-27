package binarySearching.session_4;

public class TreeCutterProblem {
    public static void main(String[] args) {

        int a[] = {1, 7, 6, 3, 4, 7};
        int k = 8;
        int res = woodCutter(a,k);

        System.out.println(res);

    }
    static int woodCutter(int a[], int k){
        int l = 0, h = (int) 1e9;

        while(l <= h){
            int m = l + (h-l)/2;
            int totalWoodLength = getWoodAtCut(a,m);
            if(totalWoodLength == k) return m;
            if(totalWoodLength > k){
                l = m+1;
            }else{
                h = m-1;
            }
        }
        return -1;
    }
    static int getWoodAtCut(int a[], int cut){
        int ans = 0;
        for(int e: a){
            ans += e > cut? e-cut: 0;
        }
        return ans;
    }
}
