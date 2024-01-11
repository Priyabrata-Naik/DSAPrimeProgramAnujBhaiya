package dsaArray.session_2;

public class MaximumDifference {
    public static void main(String[] args) {

        int a[] = {12, 9, 8, 2, 11, 5, 4, 5};

//        System.out.println(maxDiff(a));
        System.out.println(maxDiffOp(a));

    }
    static int maxDiff(int a[]){
        int n = a.length;
        int aipi[] = new int[n];
        int aimi[] = new int[n];

        for(int i = 0; i < n; i++){
            aipi[i] = a[i] + i;
            aimi[i] = a[i] - i;
        }

        int minaipi = Integer.MAX_VALUE;
        int maxaipi = Integer.MIN_VALUE;

        int minaimi = Integer.MAX_VALUE;
        int maxaimi = Integer.MIN_VALUE;

        for(int e: aipi){
            minaipi = Math.min(minaipi,e);
            maxaipi = Math.max(maxaipi,e);
        }

        for(int e: aimi){
            minaimi = Math.min(minaimi,e);
            maxaimi = Math.max(maxaimi,e);
        }

        int diffaipi = maxaipi - minaipi;
        int diffaimi = maxaimi - minaimi;

        return Math.max(diffaimi,diffaipi);
    }
    static int maxDiffOp(int a[]){
        int n = a.length;
        int minaipi = Integer.MAX_VALUE;
        int maxaipi = Integer.MIN_VALUE;

        int minaimi = Integer.MAX_VALUE;
        int maxaimi = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            minaipi = Math.min(minaipi,a[i] + i);
            maxaipi = Math.max(maxaipi,a[i] + i);

            minaimi = Math.min(minaimi,a[i] - i);
            maxaimi = Math.max(maxaimi, a[i] - i);
        }
        int diffaipi = maxaipi - minaipi;
        int diffaimi = maxaimi - minaimi;

        return Math.max(diffaimi,diffaipi);
    }
}
