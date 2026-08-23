import java.util.Scanner;

public class CharArrayProgram {

    public static char[] getCharacters(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    public static boolean compareArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length)
            return false;

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.next();

        char[] arr1 = getCharacters(str);
        char[] arr2 = str.toCharArray();

        System.out.println("Are arrays equal? " + compareArrays(arr1, arr2));
    }
}