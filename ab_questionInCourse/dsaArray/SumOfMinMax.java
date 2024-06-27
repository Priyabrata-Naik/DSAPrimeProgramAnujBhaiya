package ab_questionInCourse.dsaArray;

import java.util.Collections;
import java.util.List;

public class SumOfMinMax {
    public static void main(String[] args) {



    }
    static long sumMaxMin(List<Long> nums){
        Collections.sort(nums);
        int n = nums.size();
        if(n == 0) return 0;

        long res = nums.get(n-1)-Math.abs(nums.get(0));

        return res;
    }
}
