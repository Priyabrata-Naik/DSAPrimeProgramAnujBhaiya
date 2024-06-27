package bitManipulation_Mathematics.liveSession_1;

public class DivideInteger {
    public static void main(String[] args) {

        int a = 100;
        int b = 6;
        int res = divideInteger(a,b);

        System.out.println(res);

    }
    static int divideInteger(int dnd, int dsr){
        int sign = (dnd < 0) ^ (dsr < 0)? -1: 1;
        int ans = 0;

        dnd = Math.abs(dnd);
        dsr = Math.abs(dsr);

        while(dnd > dsr){
            int temp = dsr;
            int i = 0;
            while(dnd > (temp << 1)){
                temp = temp << 1;
                i++;
            }
            ans += (1 << i);
            dnd -= temp;
        }
        return ans * sign;
    }
}
