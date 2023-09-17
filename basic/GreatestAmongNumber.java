package basic;

import java.util.Scanner;

public class GreatestAmongNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter four numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        sc.close();

        if (a > b) {
            if (a > c) {
                if (a > d) {
                    System.out.println("a is largest element " + a);
                } else {
                    System.out.println("d is largest element " + d);
                }
            } else {
                if (c > d) {
                    System.out.println("c is largest element " + c);
                } else {
                    System.out.println("d is largest element " + d);
                }
            }
        } else if (b > c) {
            if (b > d) {
                System.out.println("b is largest element " + b);
            } else {
                System.out.println("d is largest element " + d);
            }
        } else {
            if (c > d) {
                System.out.println("c is largest element " + c);
            } else {
                System.out.println("d is largest element " + d);
            }
        }

    }

}
