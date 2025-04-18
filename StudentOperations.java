import java.sql.*;

public class StudentOperations
{
    public static void addStudent(Student student)
            throws SQLException
    {
        String query = "INSERT INTO students (prn, name, dept, batch, cgpa) VALUES (?, ?, ?, ?, ?)";
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        )
        {
            stmt.setLong(1, student.getPrn());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getDept());
            stmt.setString(4, student.getBatch());
            stmt.setDouble(5, student.getCgpa());
            stmt.executeUpdate();
            System.out.println("Student added successfully.");
        }
    }

    public static void displayAllStudents()
            throws SQLException
    {
        String query = "SELECT * FROM students";
        try (
                Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        )
        {
            while (rs.next())
            {
                System.out.println(
                        "PRN: " + rs.getLong("prn") +
                        "\nName: " + rs.getString("name") +
                        "\nDept: " + rs.getString("dept") +
                        "\nBatch: " + rs.getString("batch") +
                        "\nCGPA: " + rs.getDouble("cgpa") +
                        "\n----------------------------\n"
                );
            }
        }
    }

    public static void searchByPRN(long prn)
            throws SQLException
    {
        String query = "SELECT * FROM students WHERE prn = ?";
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        )
        {
            stmt.setLong(1, prn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                System.out.println("Student Found: " + rs.getString("name"));
            }
            else
            {
                System.out.println("No student found with PRN: " + prn);
            }
        }
    }

    public static void updateStudent(long prn, String name, String dept, String batch, double cgpa)
            throws SQLException
    {
        String query = "UPDATE students SET name=?, dept=?, batch=?, cgpa=? WHERE prn=?";
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        )
        {
            stmt.setString(1, name);
            stmt.setString(2, dept);
            stmt.setString(3, batch);
            stmt.setDouble(4, cgpa);
            stmt.setLong(5, prn);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0)
            {
                System.out.println("Student updated successfully.");
            }
            else
            {
                System.out.println("No student found with PRN: " + prn);
            }
        }
    }

    public static void deleteStudent(long prn)
            throws SQLException
    {
        String query = "DELETE FROM students WHERE prn = ?";
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        )
        {
            stmt.setLong(1, prn);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0)
            {
                System.out.println("Student deleted successfully.");
            }
            else
            {
                System.out.println("No student found with PRN: " + prn);
            }
        }
    }
}
