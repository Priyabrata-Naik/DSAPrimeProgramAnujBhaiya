package a_dsaPrimeDoubtNPractice.general;

public class SplitingString {
    public static void main(String[] args) {
        String s = "Shark";
        String a[] = s.split("");

        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
