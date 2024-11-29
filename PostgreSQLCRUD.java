package practicals;

import java.sql.*;

public class PostgreSQLCRUD {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/schooldb";
        String user = "postgres";
        String password = "Vivek@4862";

        try {

            Class.forName("org.postgresql.Driver");


            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connected to PostgreSQL database!");


                insertStudent(connection, "Alice", 20, 'A');
                insertStudent(connection, "Bob", 22, 'B');


                System.out.println("Student Records:");
                displayStudents(connection);

                // Update a student record
                updateStudent(connection, 1, "Alice Johnson", 21, 'A');

                // Delete a student record
                deleteStudent(connection, 2);

                // Display records after update and delete
                System.out.println("Updated Student Records:");
                displayStudents(connection);

            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found! " + e);
        }
    }


    private static void insertStudent(Connection connection, String name, int age, char grade) {
        String insertSQL = "INSERT INTO Student (name, age, grade) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, String.valueOf(grade));
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } catch (SQLException e) {
            System.err.println("Error inserting student: " + e.getMessage());
        }
    }

    // Read all student records
    private static void displayStudents(Connection connection) {
        String selectSQL = "SELECT * FROM Student";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");
                System.out.println(id + " | " + name + " | " + age + " | " + grade);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving students: " + e.getMessage());
        }
    }

    // Update a student record
    private static void updateStudent(Connection connection, int studentId, String newName, int newAge, char newGrade) {
        String updateSQL = "UPDATE Student SET name = ?, age = ?, grade = ? WHERE student_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, newAge);
            preparedStatement.setString(3, String.valueOf(newGrade));
            preparedStatement.setInt(4, studentId);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) updated.");
        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }


    private static void deleteStudent(Connection connection, int studentId) {
        String deleteSQL = "DELETE FROM Student WHERE student_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, studentId);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) deleted.");
        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }
}
