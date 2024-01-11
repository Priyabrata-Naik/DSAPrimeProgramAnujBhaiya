package a_dsaPrimeDoubtNPractice.general;

public class CharValueIncreasing {
    public static void main(String[] args) {
//        Output I want, is not matched
//        for(char i = 1; i < 8; i++){
//            System.out.println(i);
//        }
        int num = 8;
        char c = (char) (num + '0');

        System.out.println(c);
        char a = 8;
        char ch = (char)(a + '0');

        System.out.println(ch==c);
    }
}
