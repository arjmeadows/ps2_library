import javax.swing.*;
import java.io.FileWriter;

public class Library {

 // Add new game
    public void addGame(JTextField textArea) {
        String newGame = textArea.getText();
        JOptionPane.showMessageDialog(null, " " + newGame + " has been added to your collection!");
// Writing to a CSV file
        try (FileWriter writer = new FileWriter("games.csv", true)) {
            writer.append("\n")
                    .append(newGame);
        } catch (java.io.IOException a) {
            System.out.print("No!");
        }
    }





}
