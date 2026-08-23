import java.util.Scanner;

public class StringIndexDemo {

    public static void generate(String str) {
        System.out.println(str.charAt(str.length())); // Invalid index
    }

    public static void handle(String str) {
        try {
            System.out.println(str.charAt(str.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // generate(str);
        handle(str);
    }
}