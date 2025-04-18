import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Database connection
        Connection conn = null;
        try {
            // Connect to MySQL database
            String url = "jdbc:mysql://localhost:3306/quizdb";
            String user = "root";
            String password = "yourpassword";  // Change with your password
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database.");

            // Welcome message
            System.out.println("Welcome to the Online Quiz Application!");
            System.out.println("Please login to start the quiz.");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String userPassword = scanner.nextLine();

            // Check if the user exists
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, userPassword);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                System.out.println("Login successful!");
                startQuiz(conn, scanner);
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void startQuiz(Connection conn, Scanner scanner) {
        try {
            // Query to get quiz questions
            String query = "SELECT * FROM questions";
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            int score = 0;
            int totalQuestions = 0;

            // Loop through the questions
            while (resultSet.next()) {
                totalQuestions++;
                String question = resultSet.getString("question");
                String optionA = resultSet.getString("option_a");
                String optionB = resultSet.getString("option_b");
                String optionC = resultSet.getString("option_c");
                String optionD = resultSet.getString("option_d");
                String correctAnswer = resultSet.getString("correct_answer");

                // Display the question and options
                System.out.println("\n" + question);
                System.out.println("A) " + optionA);
                System.out.println("B) " + optionB);
                System.out.println("C) " + optionC);
                System.out.println("D) " + optionD);
                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine().toUpperCase();

                // Check if the answer is correct
                if (userAnswer.equals(correctAnswer)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer is " + correctAnswer + ".");
                }
            }

            // Display final score
            System.out.println("\nQuiz completed!");
            System.out.println("You scored " + score + " out of " + totalQuestions);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


               
