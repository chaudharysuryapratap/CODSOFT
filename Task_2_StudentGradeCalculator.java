import java.util.Scanner;

public class Task_2_StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        if (numSubjects <= 0) {
            System.out.println("Number of subjects must be greater than zero.");
            return;
        }

        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks of Subject " + i + ": ");
            int marks = scanner.nextInt();
            
            // Validating marks
            if (marks < 0 || marks > 100) {
                System.out.println("Marks must not exceed 100 and should be less than 0. Please enter again.");
                i--; 
                continue;
            }

            totalMarks += marks;
        }

        // Calculating average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Assigning grade based on average percentage
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F'; 
        }
        
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}