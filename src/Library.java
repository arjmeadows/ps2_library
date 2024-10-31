import javax.swing.*;
import java.io.*;
import java.time.LocalDate;

public class Library {

    //create object
    UI uicall = new UI();


    // Add new game
    public void addGame(JTextField textArea) {
        String newGame = textArea.getText();
        String modalmessage = newGame + " has been added to your game library on " + LocalDate.now();
        String modaltitle = "Game added to library";
        uicall.plainmodal(modaltitle, modalmessage);
        textArea.setText("");

        // Writing to a CSV file
        try (FileWriter writer = new FileWriter("games.csv", true)) {
            writer.append("\n")
                    .append(newGame + " (added on " + LocalDate.now() + ")");
        } catch (java.io.IOException a) {
            System.out.print("No!");
        }
    }

    // Show library button - create csv reader class later
    public void seelib() {
        String csvFile = "games.csv";
        StringBuilder headerLine = new StringBuilder();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("games.csv"));) {

            do {
                headerLine.append(line);
                ;
                headerLine.append("\n");
            } while (((line = br.readLine())) != null);

            JOptionPane.showMessageDialog(null, headerLine, "Current Library", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException a) {
            System.out.print("No!");

        }
    }
}