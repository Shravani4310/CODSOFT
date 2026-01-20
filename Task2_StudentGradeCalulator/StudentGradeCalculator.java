
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of subjects");
        int subjects = sc.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.println("Enter the marks for subjects" + i + "(out of 100):");
            int marks = sc.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Enter between 0 and 100.");
                i--;
                continue;
            }
            totalMarks += marks;
        }
        double averagepercentage = (double) totalMarks / subjects;

        char grade;

        if (averagepercentage >= 90) {
            grade = 'A';
        } else if (averagepercentage >= 75) {
            grade = 'B';
        } else if (averagepercentage >= 60) {
            grade = 'C';
        } else if (averagepercentage >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("\n ----Result----");
        System.out.println("Total Marks:" + totalMarks);
        System.out.println("Average Percentage:" + averagepercentage);
        System.out.println("Grade:" + grade);

        sc.close();
    }
}
