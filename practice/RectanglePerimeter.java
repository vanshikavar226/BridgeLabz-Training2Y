import java.util.Scanner;

public class RectanglePerimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Length: ");
        double l = sc.nextDouble();

        System.out.print("Width: ");
        double w = sc.nextDouble();

        double p = 2 * (l + w);
        System.out.println("Perimeter = " + p);
    }
}
