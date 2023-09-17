package recursion;

public class RecursionModerateHigh {

    public static void main(String[] args) {

        String s = "abc";
//		boolean isPalindrome = checkPalindrome(s, 0, s.length() - 1);
//
//		if (isPalindrome) {
//			System.out.println(s + " is palindrome");
//		} else {
//			System.out.println(s + " is not a palindrome");
//		}
//		String t = "ab";
//		System.out.println(counterOccurence(t, s));
        printAllSubset(s);

    }

    static boolean checkPalindrome(String s, int i, int j) {
        if (i >= j)
            return true;
        if (s.charAt(i) != s.charAt(j))
            return false;
        return checkPalindrome(s, i + 1, j - 1);

    }

    static int counterOccurence(String t, String s) {
        return counterOccurenceHelper(t, s, 0);
    }

    static int counterOccurenceHelper(String t, String s, int i) {
        if (i > s.length() - t.length()) {
            return 0;
        }
        int subProblem = counterOccurenceHelper(t, s, i + 1);
        boolean match = s.substring(i, i + t.length()).equals(t);
        if (match) {
            return subProblem + 1;
        }
        return subProblem;
    }

    static void printAllSubset(String s) {
        printAllSubset(s, 0, "");
    }

    static void printAllSubset(String s, int i, String cur) {
        if (i == s.length()) {
            System.out.println(cur);
            return;
        }
        printAllSubset(s, i + 1, cur + s.charAt(i));
        printAllSubset(s, i + 1, cur);
    }

}
