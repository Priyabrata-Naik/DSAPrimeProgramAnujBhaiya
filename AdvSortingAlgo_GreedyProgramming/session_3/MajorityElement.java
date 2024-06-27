package AdvSortingAlgo_GreedyProgramming.session_3;

public class MajorityElement {
    public static void main(String[] args) {

        int a[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int res = majorityElementOp(a);

        System.out.println(res);

    }
//    Moore's Voting Algorithm
    static int majorityElementOp(int a[]){
        int n = a.length;
        int count = 1;
        int majority = a[0];

        for(int i = 1; i < n; i++){
            if(majority == a[i]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                majority = a[i];
                count = 1;
            }
        }
        int freq = 0;
        for(int e: a){
            if(majority == e) freq++;
        }
        return freq > (n >> 1) ? majority : -1;
    }
    static int majorityElement(int a[]){
        int n = a.length;
        int ans = -1;

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(a[i] == a[j]){
                    count++;
                }
            }
            if(count > (n >> 1)){
                ans = a[i];
                break;
            }
        }
        return ans;
    }
}
