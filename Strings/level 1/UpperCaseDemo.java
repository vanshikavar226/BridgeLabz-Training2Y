import java.util.Scanner;

public class UpperCaseDemo {

    public static String toUpper(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                ch = (char)(ch - 32);
            result += ch;
        }
        return result;
    }

    public static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String custom = toUpper(str);
        String builtIn = str.toUpperCase();

        System.out.println("Are equal? " + compare(custom, builtIn));
    }
}