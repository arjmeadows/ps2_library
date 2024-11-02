import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;

public class Library {

    Connection conn = null; // Declare the connection variable
    ResultSet rs = null; // Declare the ResultSet variable

    //create object
    UI uicall = new UI();

    // calldb
    private final DatabaseManager dbManager = new DatabaseManager();


    // Add game
    public void addGame(JTextField textArea) {
        String newGame = textArea.getText();
        String modalmessage = newGame + " has been added to your game library on " + LocalDate.now();
        String modaltitle = "Game added to library";
        String nameupdatesql = "INSERT INTO game_list(title) VALUES(?)";

        try (Connection conn = dbManager.connect();  // Get a connection to the database
             PreparedStatement gametitle = conn.prepareStatement(nameupdatesql)) {
            gametitle.setString(1, newGame);
            gametitle.executeUpdate();
            uicall.plainmodal(modaltitle, modalmessage);
            seelib();
            textArea.setText("");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // delete game
    public void removeGame(String selectedItem) {
        // Writing to a CSV file
        try (FileWriter writer = new FileWriter("games.csv", false)) {
            writer.append("\n")
                    .append(selectedItem + " (added on " + LocalDate.now() + ")");
        } catch (java.io.IOException a) {
            System.out.print("No!");
        }
    }


    // Show library button - create csv reader class later

    public DefaultListModel seelib() {
        DefaultListModel<String> sb = new DefaultListModel<>();

        try {
            // Get a connection to the database
            conn = dbManager.connect(); // Assuming dbManager.connect() returns a Connection

            // SQL query
            String sql = "SELECT title FROM game_list"; // Adjust the SQL according to your table

            // Create a Statement and execute the query
            try (Statement stmt = conn.createStatement()) { // Create Statement in try-with-resources
                rs = stmt.executeQuery(sql); // Execute the query on the Statement

                // Process the ResultSet
                while (rs.next()) {
                    // Retrieve data by column name
                    String title = rs.getString("title");
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


    public JList<String> showList(JFrame frame) {

        DefaultListModel games = seelib();

        JList<String> itemList = new JList<>(games); // Create JList with items
        itemList.setPreferredSize(new Dimension(500, 900)); // Width: 300 pixels, Height: 200 pixels

        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow single selection
        frame.add(itemList);
        return itemList;
    }

    }

// seelin meeds to roeturn a list model?