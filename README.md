![Java](https://img.shields.io/badge/Java-Console%20App-blue?style=flat-square&logo=java)


# 🎓 Student Report System

A Java-based console application developed by **Chamod Lakshitha** to manage student report cards.  
This system allows users to add students, calculate grades, sort by average, search by roll number, and export report data.

---

## ✨ Features

- 🔹 Add student details: name, roll number, and marks for 5 subjects
- 🔹 Auto-calculate average marks, assign grade, and performance level
- 🔹 Sort students by average using Bubble Sort
- 🔹 Search students by roll number using:
    - Linear Search
    - Binary Search (after sorting by roll number)
- 🔹 Export student report to `student_report.txt` file

---

## 🛠 Technologies Used

- Java (Console Application)
- IntelliJ IDEA (IDE)
- Git & GitHub
- Windows OS (Developed on)

---



## 📊 UML Class Diagram (Text Representation)

<details>
  <summary>Click to expand UML diagram (Text)</summary>

```
+-------------------------+ 
| Student                 | 
+-------------------------+ 
| - studentName           | 
| - rollNumber            | 
| - marks[]               | 
| - average               | 
| - grade                 | 
| - performance           | 
+-------------------------+ 
| + getStudentName()      | 
| + getRollNumber()       | 
| + getAverage()          | 
| + getGrade()            | 
| + getPerformance()      | 
| + setMarks()            | 
| - calculateAverage()    | 
| - assignGrade()         | 
| - determinePerformance()| 
+-------------------------+

+------------------------+ 
| StudentUtils           | 
+------------------------+ 
| + bubbleSortByAverage()| 
| + sortByRollNumber()   | 
| + linearSearch()       | 
| + binarySearch()       | 
+------------------------+

+------------------------+ 
| Main                   | 
+------------------------+ 
| + main()               | 
| + addStudents()        | 
| + displayAllStudents() | 
| + exportToTextFile()   | 
| + getValidInput()      | 
+------------------------+
```
</details>


---
## 📂 Project Structure

