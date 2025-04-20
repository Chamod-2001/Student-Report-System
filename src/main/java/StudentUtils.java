/**
 * Utility class for sorting and searching student data.
 * Provides implementations for Bubble Sort, Linear Search, and Binary Search.
 */
public class StudentUtils {

    /**
     * Sorts the array of students in descending order based on their average marks.
     * This is used to rank students from highest to lowest performers.
     *
     * @param students Array of Student objects
     * @param count    Number of students currently in the array
     */
    public static void bubbleSortByAverage(Student[] students, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getAverage() < students[j + 1].getAverage()) {
                    swap(students, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the array of students in ascending order by roll number.
     * This is required before performing binary search.
     *
     * @param students Array of Student objects
     * @param count    Number of students currently in the array
     */
    public static void sortByRollNumber(Student[] students, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getRollNumber() > students[j + 1].getRollNumber()) {
                    swap(students, j, j + 1);
                }
            }
        }
    }

    /**
     * Searches for a student by roll number using the Linear Search algorithm.
     *
     * @param students     Array of Student objects
     * @param count        Number of students currently in the array
     * @param rollToSearch Roll number to find
     * @return Student object if found, otherwise null
     */
    public static Student linearSearch(Student[] students, int count, int rollToSearch) {
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNumber() == rollToSearch) {
                return students[i];  // Match found
            }
        }
        return null; // No match found
    }

    /**
     * Searches for a student by roll number using the Binary Search algorithm.
     * Assumes the array is sorted in ascending order by roll number.
     *
     * @param students     Sorted array of Student objects
     * @param count        Number of students currently in the array
     * @param rollToSearch Roll number to search for
     * @return Student object if found, otherwise null
     */
    public static Student binarySearch(Student[] students, int count, int rollToSearch) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midRoll = students[mid].getRollNumber();

            if (midRoll == rollToSearch) {
                return students[mid];  // Match found
            } else if (rollToSearch < midRoll) {
                right = mid - 1;       // Search left half
            } else {
                left = mid + 1;        // Search right half
            }
        }

        return null;  // No match found
    }

    /**
     * Swaps two elements in the student array.
     *
     * @param array Array of students
     * @param i     First index
     * @param j     Second index
     */
    private static void swap(Student[] array, int i, int j) {
        Student temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
