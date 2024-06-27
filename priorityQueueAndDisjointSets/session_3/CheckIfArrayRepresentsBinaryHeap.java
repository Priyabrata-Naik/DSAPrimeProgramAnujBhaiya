package priorityQueueAndDisjointSets.session_3;

public class CheckIfArrayRepresentsBinaryHeap {
    public static void main(String[] args) {

        int a[] = {90, 15, 10, 7, 12, 2};
        int n = a.length;
        System.out.println(isHeap(a,n));

    }
    static boolean isHeap(int a[], int n){
        return isHeapHelper(a, n , 0);
    }
    static boolean isHeapHelper(int a[], int n, int i){
        if(i >= n/2) return true;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(a[i] >= a[left] && isHeapHelper(a,n,left)){
            if(right < n){
                return a[i] >= a[right] && isHeapHelper(a, n, right);
            }else return true;
        }
        return false;
    }
}
