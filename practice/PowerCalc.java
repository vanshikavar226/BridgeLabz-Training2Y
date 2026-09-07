import java.util.Scanner;

public class PowerCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Base: ");
        double base = sc.nextDouble();

        System.out.print("Exponent: ");
        double exp = sc.nextDouble();

        double result = Math.pow(base, exp);
        System.out.println("Result = " + result);
    }
}
