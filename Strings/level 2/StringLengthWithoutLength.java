import java.util.Scanner;

public class StringLengthWithoutLength {

    // Method to calculate length without using length()
    public static int findLength(String str) {
        int count = 0;

        try {
            while (true) {   // Infinite loop
                str.charAt(count);  // Access character
                count++;            // Increase counter
            }
        } 
        catch (StringIndexOutOfBoundsException e) {
            // Exception occurs when index exceeds string size
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        int userLength = findLength(text);     // User-defined method
        int builtInLength = text.length();     // Built-in method

        System.out.println("Length using user-defined method: " + userLength);
        System.out.println("Length using built-in length(): " + builtInLength);
    }
}