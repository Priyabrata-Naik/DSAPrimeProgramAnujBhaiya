package basic;

public class GivingToffee {

    public static void main(String[] args) {

        for (int i = 0; i <= 20; i++) {
            if (i == 2 || i == 8)
                continue;
            if (i >= 15)
                break;
            System.out.println("Giving toffee " + i);
        }

    }

}
