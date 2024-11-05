import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Library {

    Connection conn = null; // Declare the connection variable
    ResultSet rs = null; // Declare the ResultSet variable
    Scanner scanner = new Scanner(System.in);

    //create object
    UI uicall = new UI();

    // calldb
    private final DatabaseManager dbManager = new DatabaseManager();


    // Writes game to the database
    public String addGame(String capt, String capt2) { // this makes no sense.
        String modalmessage = capt + " has been added to your game library on " + LocalDate.now();
        String modaltitle = "Game added to library";
        String nameupdatesql = "INSERT INTO games(title, box) VALUES(?,?)";

        // Open connection to database and confirm to use
        try (Connection conn = dbManager.connect();  // Get a connection to the database
             PreparedStatement gametitle = conn.prepareStatement(nameupdatesql)) {
            gametitle.setString(1, capt);
            gametitle.setString(2, capt2);
            gametitle.executeUpdate();
            uicall.plainmodal(modaltitle, modalmessage);
            System.out.println(capt + " written");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return capt;
    }


    public DefaultListModel seelib() {
        DefaultListModel<String> sb = new DefaultListModel<>();

        try {
            // Get a connection to the database
            conn = dbManager.connect(); // Assuming dbManager.connect() returns a Connection

            // SQL query
            String sql = "SELECT title, box FROM games"; // Adjust the SQL according to your table

            // Create a Statement and execute the query
            try (Statement stmt = conn.createStatement()) { // Create Statement in try-with-resources
                rs = stmt.executeQuery(sql); // Execute the query on the Statement

                // Process the ResultSet
                while (rs.next()) {
                    // Retrieve data by column name
                    String title = rs.getString("title");
                    String box = rs.getString("box");
                    ((DefaultListModel<String>) sb).addElement(title);

                }
            } // Automatically closes stmt and rs due to try-with-resources

        } catch (SQLException ex) {
            throw new RuntimeException("Database error: " + ex.getMessage(), ex);
        } finally {
            // Close the ResultSet and Connection
            try {
                if (rs != null) rs.close(); // Close ResultSet if it was opened
                if (conn != null && !conn.isClosed()) conn.close(); // Close Connection if it was opened
            } catch (SQLException e) {
                System.out.println("Could not close resources: " + e.getMessage());
            }

        }

        return sb;
    }


        }