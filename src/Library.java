import javax.swing.*;
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
    public StringBuilder seelib() {

        try (Connection conn = dbManager.connect(); {  // Get a connection to the database
             String stmt = conn.createStatement();
             String sql = "SELECT title FROM game_list"; // Adjust the SQL according to your table
             rs = stmt.executeQuery(sql);

        while (rs.next()) {
            // Retrieve data by column name
            String title = rs.getString("title");
        }

        catch (SQLException ex) {
            throw new RuntimeException(ex);
        } ;

        finally {
            // Close the ResultSet, Statement, and Connection
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Could not close resources: " + e.getMessage());
            }

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        }
    }
}

// scanner needs to keep checking until it finds the seleced value;