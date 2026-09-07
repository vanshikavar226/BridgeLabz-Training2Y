import java.util.Scanner;

public class AverageThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        double a = sc.nextDouble();

        System.out.print("Enter number 2: ");
        double b = sc.nextDouble();

        System.out.print("Enter number 3: ");
        double c = sc.nextDouble();

        double avg = (a + b + c) / 3;
        System.out.println("Average = " + avg);
    }
}
