package recursion;

public class CounterOccurenceOfString {

    public static void main(String[] args) {

        String a = "abcdeabc";
        String b = "abc";
        int res = counterString(a, b);

        System.out.println(res);

    }

    static int counterString(String s, String t) {
        int n = s.length();
        int a = t.length();
        int count = 0;
//		ArrayDeque<Character> ad = new ArrayDeque<>();

        for (int i = 0, j = a - 1; i <= n - a && j < n; i++, j++) {
            if (t.equals(s.substring(i, j + 1))) {
                count++;
            }
        }
        return count;
    }

}
