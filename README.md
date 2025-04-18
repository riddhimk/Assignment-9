# Student Data Entry Application (Java + JDBC + MySQL)

This is a Java-based console application for managing student data using JDBC with MySQL. It performs basic CRUD operations: Create, Read, Update, and Delete.

---

## Project Structure

```
StudentDataEntry/
│
├── Main.java                 // Main menu and program flow
├── Student.java              // Student class (POJO)
├── StudentOperations.java    // Contains all database operation methods
├── DBConnection.java         // Manages database connection
├── mysql-connector-j-9.2.0.jar  // JDBC driver (must be in classpath)
├── student_db.sql             // SQL setup for database and table
└── README.md                 // Project documentation
```

---

## Functionalities

1. Add a Student
2. Display All Students
3. Search Student by PRN
4. Update Student Details
5. Delete Student
6. Exit Application

---

## Database Setup

1. Make sure MySQL server is running.
2. Create the database and table using the following SQL:

```sql
CREATE DATABASE IF NOT EXISTS student_db;

USE student_db;

CREATE TABLE IF NOT EXISTS students (
    prn BIGINT PRIMARY KEY,
    name VARCHAR(100),
    dept VARCHAR(50),
    batch VARCHAR(20),
    cgpa DOUBLE
);
```

---

## Sample Data

To prefill the database, run the following SQL:

```sql
INSERT INTO students (prn, name, dept, batch, cgpa) VALUES
(101, 'Rohit Sharma', 'CSE', 'A1', 9.1),
(102, 'Virat Kohli', 'ENTC', 'B3', 8.5),
(103, 'Riddhim Kawdia', 'AIML', 'B2', 7.8),
(104, 'David Warner', 'CIVIL', 'A2', 8.2),
(105, 'Chris Gayle', 'CSE', 'B1', 9.0);
```

---

## JDBC Configuration

Make sure to include `mysql-connector-j-9.2.0.jar` in your project's classpath.

Update the DBConnection.java file with correct credentials:

```java
String url = "jdbc:mysql://localhost:3306/student_db";
String user = "**********";
String password = "**********";
```

## Functional Overview
| Operation         | Java Method Used                   | File                   |
|------------------|-------------------------------------|------------------------|
| Add Student       | `addStudent(Student student)`       | `StudentOperations.java` |
| Display Students  | `displayAllStudents()`             | `StudentOperations.java` |
| Search by PRN     | `searchStudent(long prn)`          | `StudentOperations.java` |
| Update Student    | `updateStudent(...)`               | `StudentOperations.java` |
| Delete Student    | `deleteStudent(long prn)`           | `StudentOperations.java` |
