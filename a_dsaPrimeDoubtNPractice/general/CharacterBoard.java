package a_dsaPrimeDoubtNPractice.general;

public class CharacterBoard {
    public static void main(String[] args) {

        char board[][] = new char[4][4];

        for(char e[]: board){
            for(char d: e){
                System.out.print(d+" ");
            }
            System.out.println();
        }

    }
}
