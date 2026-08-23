import java.util.Scanner;

public class ArrayIndexDemo {

    public static void generate(String[] arr) {
        System.out.println(arr[arr.length]); // Invalid index
    }

    public static void handle(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled!");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[3];

        for (int i = 0; i < 3; i++) {
            names[i] = sc.next();
        }

        // generate(names);
        handle(names);
    }
}