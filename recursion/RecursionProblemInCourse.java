package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecursionProblemInCourse {

    public static void main(String[] args) {

//		int a[] = { 2, 12 };
//		System.out.println(helper(a, a.length, 0));

        String s = "abc";
        findSubstring(s);

    }

    static boolean helper(int a[], int n, int i) {
        if (i == (n - 1))
            return true;
        if (a[i + 1] < a[i]) {
            return false;
        }
        return helper(a, n, i + 1);
    }

    static List<String> findSubstring(String s) {

        List<String> al = new ArrayList<>();

        subString(s, al, 0, "");
        Collections.sort(al);
        al.remove(0);

        return al;

    }

    static void subString(String s, List<String> ans, int i, String cur) {
        if (i == s.length()) {
            ans.add(cur);
            return;
        }
        subString(s, ans, i + 1, cur + s.charAt(i));
        subString(s, ans, i + 1, cur);
    }

}
