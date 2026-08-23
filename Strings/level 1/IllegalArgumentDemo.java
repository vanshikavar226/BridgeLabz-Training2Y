import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generate(String str) {
        System.out.println(str.substring(5, 2)); // Invalid range
    }

    public static void handle(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled!");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // generate(str);
        handle(str);
    }
}