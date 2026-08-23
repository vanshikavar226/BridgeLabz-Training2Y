import java.util.Scanner;
import java.util.Random;

public class StudentGradeSystem {

    // Method to generate random PCM marks (2-digit)
    public static int[][] generateMarks(int n) {
        Random rand = new Random();
        int[][] marks = new int[n][3]; // Physics, Chemistry, Math

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = rand.nextInt(90) + 10; // 10–99
            }
        }
        return marks;
    }

    // Method to calculate total, average, percentage
    public static double[][] calculateResults(int[][] marks) {
        int n = marks.length;
        double[][] results = new double[n][3]; 
        // total, average, percentage

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round to 2 decimal places
            percentage = Math.round(percentage * 100.0) / 100.0;
            average = Math.round(average * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }

        return results;
    }

    // Method to calculate grade
    public static String[] calculateGrade(double[][] results) {
        int n = results.length;
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            double percent = results[i][2];

            if (percent >= 80)
                grades[i] = "A";
            else if (percent >= 70)
                grades[i] = "B";
            else if (percent >= 60)
                grades[i] = "C";
            else if (percent >= 50)
                grades[i] = "D";
            else if (percent >= 40)
                grades[i] = "E";
            else
                grades[i] = "R";
        }

        return grades;
    }

    // Method to display scorecard
    public static void displayScorecard(int[][] marks, double[][] results, String[] grades) {

        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.println("Student\tPhy\tChem\tMath\tTotal\tAverage\t%\tGrade");
        System.out.println("---------------------------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            System.out.println((i + 1) + "\t" +
                    marks[i][0] + "\t" +
                    marks[i][1] + "\t" +
                    marks[i][2] + "\t" +
                    (int)results[i][0] + "\t" +
                    results[i][1] + "\t" +
                    results[i][2] + "\t" +
                    grades[i]);
        }

        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = generateMarks(n);
        double[][] results = calculateResults(marks);
        String[] grades = calculateGrade(results);

        displayScorecard(marks, results, grades);

        sc.close();
    }
}