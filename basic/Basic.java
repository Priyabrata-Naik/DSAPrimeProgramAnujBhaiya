package basic;

public class Basic {

    public static int x = 5;

    public static void main(String[] args) {

//		String s = "Java Programming";
//		String words[] = s.split("a");
//		System.out.println(words.length);
//
//		for (String word : words) {
//			System.out.println(word);
//		}

        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - i - 1];
        }
        System.out.println(sum);

    }

    static void myFunction() {
        x = x + 3;

    }

}
