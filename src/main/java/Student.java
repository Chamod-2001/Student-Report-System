/**
 * ===============================
 *         STUDENT CLASS
 * ===============================
 *
 *  VARIABLES:
 *  - String studentName
 *  - int rollNumber
 *  - int[] marks
 *  - double average
 *  - char grade
 *  - String performance
 *
 *  CONSTRUCTOR:
 *  - Student(String name, int roll, int[] marks)
 *
 *  METHODS:
 *  - getStudentName(), getRollNumber(), getAverage(), getGrade(), getPerformance()
 *  - setMarks(int[] newMarks)
 *  - calculateAverage(), assignGrade(), determinePerformance()
 *
 *  OOP PRINCIPLES:
 *  - Encapsulation
 *  - Abstraction
 */
public class Student {

    // ============================
    // Fields (Private - Encapsulated)
    // ============================
    private String studentName;     // Student's full name
    private int rollNumber;         // Unique identifier
    private int[] marks;            // Marks in 5 subjects
    private double average;         // Computed average
    private char grade;             // Grade based on average
    private String performance;     // Performance description

    // ============================
    // Constructor
    // ============================

    /**
     * Constructs a Student object and automatically evaluates
     * their average, grade, and performance.
     *
     * @param studentName Name of the student
     * @param rollNumber  Roll number (ID)
     * @param marks       Array of marks (length = 5)
     */
    public Student(String studentName, int rollNumber, int[] marks) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;

        // Automatically calculate derived data
        calculateAverage();
        assignGrade();
        determinePerformance();
    }

    // ============================
    // Getter Methods
    // ============================

    /**
     * @return The student's full name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @return The student's roll number.
     */
    public int getRollNumber() {
        return rollNumber;
    }

    /**
     * @return The student's calculated average.
     */
    public double getAverage() {
        return average;
    }

    /**
     * @return The grade assigned (A–F).
     */
    public char getGrade() {
        return grade;
    }

    /**
     * @return The student's performance description.
     */
    public String getPerformance() {
        return performance;
    }

    // ============================
    // Setter Method
    // ============================

    /**
     * Updates the marks and recalculates average, grade, and performance.
     *
     * @param newMarks An array of new marks (length = 5)
     */
    public void setMarks(int[] newMarks) {
        this.marks = newMarks;
        calculateAverage();
        assignGrade();
        determinePerformance();
    }

    // ============================
    // Internal Calculation Methods
    // ============================

    /**
     * Calculates the average mark from the 5 subjects.
     */
    private void calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        this.average = (double) total / marks.length;
    }

    /**
     * Assigns a grade based on the average.
     * Logic based on standard academic scale.
     */
    private void assignGrade() {
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    /**
     * Determines performance label using grade.
     * Uses switch-case for clarity and future scalability.
     */
    private void determinePerformance() {
        switch (grade) {
            case 'A':
                performance = "Excellent";
                break;
            case 'B':
                performance = "Good";
                break;
            case 'C':
                performance = "Average";
                break;
            case 'D':
                performance = "Below Average";
                break;
            case 'F':
                performance = "Poor";
                break;
            default:
                performance = "Undefined";
                break;
        }
    }
}
