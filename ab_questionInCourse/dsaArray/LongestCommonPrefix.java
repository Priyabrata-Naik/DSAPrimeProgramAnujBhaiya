package ab_questionInCourse.dsaArray;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String s[] = {"hello", "help", "heskel"};
        String res = longestCommonPrefix(s);

//        while(s[1].indexOf(s[0]) != 0){
//            System.out.println(s[1].indexOf(s[0]));
//            s[0] = s[0].substring(0,s[0].length()-1);
//            System.out.println(s[0]);
//        }
//        System.out.println("help".indexOf("hel"));

        System.out.println(res);

    }
    static String longestCommonPrefix(String s[]){
        int n = s.length;
        if(s == null || n == 0)
            return "";
        String prefix = s[0];
        for(int i = 1; i < n; i++){
            while(s[i].indexOf(prefix) != 0){
//                System.out.println(s[i].indexOf(prefix));
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
