import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A Java console application that manages student records, calculates grades,
 * sorts students, and allows search by roll number.
 * Includes features like validation, bubble sort, linear and binary search,
 * and exporting data to a file.
 */
public class Main {

    // Max number of students
    private static final int MAX_STUDENTS = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[MAX_STUDENTS];
        int studentCount = 0;
        int choice;

        do {
            displayMenu();
            choice = getIntegerInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    studentCount = addStudents(scanner, students, studentCount);
                    break;
                case 2:
                    displayAllStudents(students, studentCount);
                    break;
                case 3:
                    sortStudentsByAverage(students, studentCount);
                    break;
                case 4:
                    searchByRollLinear(scanner, students, studentCount);
                    break;
                case 5:
                    searchByRollBinary(scanner, students, studentCount);
                    break;
                case 6:
                    exportToTextFile(students, studentCount);
                    break;
                case 7:
                    System.out.println("👋 Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please select a valid option.");
            }
        } while (choice != 7);

        scanner.close();
    }

    /**
     * Displays the main menu options.
     */
    private static void displayMenu() {
        System.out.println("\n===== STUDENT REPORT SYSTEM MENU =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Sort by Average Marks (Bubble Sort)");
        System.out.println("4. Search by Roll Number (Linear Search)");
        System.out.println("5. Search by Roll Number (Binary Search)");
        System.out.println("6. Export to Text File");
        System.out.println("7. Exit");
    }

    /**
     * Adds new student(s) and updates the student count.
     */
    private static int addStudents(Scanner scanner, Student[] students, int studentCount) {
        int numberOfStudents = getIntegerInput(scanner, "How many students do you want to add? ");

        for (int n = 0; n < numberOfStudents; n++) {
            System.out.println("\n--- Entering details for Student " + (studentCount + 1) + " ---");

            // Input name
            String studentName;
            while (true) {
                System.out.print("Enter Student Name: ");
                studentName = scanner.nextLine();
                if (studentName.matches("[a-zA-Z ]+")) break;
                System.out.println("❌ Invalid name! Use letters and spaces only.");
            }

            // Input roll number
            int rollNumber;
            while (true) {
                System.out.print("Enter Roll Number: ");
                String input = scanner.nextLine();
                if (input.matches("[0-9]+")) {
                    rollNumber = Integer.parseInt(input);
                    break;
                }
                System.out.println("❌ Invalid Roll Number! Digits only.");
            }

            // Input marks
            int[] marks = new int[5];
            System.out.println("Enter marks for 5 subjects (0 - 100):");
            for (int i = 0; i < 5; i++) {
                marks[i] = getValidMark(scanner, "Subject " + (i + 1) + ": ");
            }

            // Create and store student
            students[studentCount++] = new Student(studentName, rollNumber, marks);
            System.out.println("✅ Student " + studentCount + " added successfully!");
        }

        return studentCount;
    }

    /**
     * Displays all student records.
     */
    private static void displayAllStudents(Student[] students, int count) {
        if (count == 0) {
            System.out.println("⚠️ No student records found.");
            return;
        }

        System.out.println("\n===== ALL STUDENT REPORT CARDS =====\n");
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            System.out.println("Name: " + s.getStudentName() +
                    " | Roll: " + s.getRollNumber() +
                    " | Average: " + s.getAverage() +
                    " | Grade: " + s.getGrade() +
                    " | Performance: " + s.getPerformance());
            System.out.println("-----------------------------------");
        }
    }

    /**
     * Sorts students by average marks using bubble sort.
     */
    private static void sortStudentsByAverage(Student[] students, int count) {
        if (count == 0) {
            System.out.println("⚠️ No students to sort.");
        } else {
            StudentUtils.bubbleSortByAverage(students, count);
            System.out.println("✅ Students sorted by average marks (high to low).");
        }
    }

    /**
     * Performs linear search by roll number.
     */
    private static void searchByRollLinear(Scanner scanner, Student[] students, int count) {
        if (count == 0) {
            System.out.println("⚠️ No students to search.");
            return;
        }

        int roll = getIntegerInput(scanner, "Enter Roll Number to search: ");
        Student found = StudentUtils.linearSearch(students, count, roll);

        displayStudentResult(found);
    }

    /**
     * Performs binary search by roll number.
     */
    private static void searchByRollBinary(Scanner scanner, Student[] students, int count) {
        if (count == 0) {
            System.out.println("⚠️ No students to search.");
            return;
        }

        int roll = getIntegerInput(scanner, "Enter Roll Number to search: ");
        StudentUtils.sortByRollNumber(students, count);
        Student found = StudentUtils.binarySearch(students, count, roll);

        displayStudentResult(found);
    }

    /**
     * Exports student data to a text file.
     */
    private static void exportToTextFile(Student[] students, int count) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("student_report.txt"))) {
            writer.println("===== STUDENT REPORT CARD =====");
            for (int i = 0; i < count; i++) {
                Student s = students[i];
                writer.println("Student " + (i + 1));
                writer.println("Name       : " + s.getStudentName());
                writer.println("Roll Number: " + s.getRollNumber());
                writer.println("Average    : " + s.getAverage());
                writer.println("Grade      : " + s.getGrade());
                writer.println("Performance: " + s.getPerformance());
                writer.println("-----------------------------------");
            }
            System.out.println("✅ Student data exported to student_report.txt successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Displays a student's details or notifies if not found.
     */
    private static void displayStudentResult(Student student) {
        if (student != null) {
            System.out.println("\n✅ Student Found!\n");
            System.out.println("Name       : " + student.getStudentName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Average    : " + student.getAverage());
            System.out.println("Grade      : " + student.getGrade());
            System.out.println("Performance: " + student.getPerformance());
        } else {
            System.out.println("❌ No student found with that roll number.");
        }
    }

    /**
     * Utility to safely get an integer input from user.
     */
    private static int getIntegerInput(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                value = Integer.parseInt(input);
                break;
            }
            System.out.println("❌ Invalid input! Please enter a numeric value.");
        }
        return value;
    }

    /**
     * Utility to safely get a valid subject mark between 0 and 100.
     */
    private static int getValidMark(Scanner scanner, String prompt) {
        int mark;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                mark = Integer.parseInt(input);
                if (mark >= 0 && mark <= 100) break;
                else System.out.println("❌ Enter mark between 0 and 100.");
            } else {
                System.out.println("❌ Numeric values only.");
            }
        }
        return mark;
    }
}
