import javax.swing.*;
import java.io.*;

public class Library {

    // Add new game
    public void addGame(JTextField textArea) {
        String newGame = textArea.getText();
        JOptionPane.showMessageDialog(null, " " + newGame + " has been added to your collection!", "New game added", JOptionPane.PLAIN_MESSAGE);

        // Writing to a CSV file
        try (FileWriter writer = new FileWriter("games.csv", true)) {
            writer.append("\n")
                    .append(newGame);
        } catch (java.io.IOException a) {
            System.out.print("No!");
        }
    }

    // Show library - create csv reader class later
    public void seelib() {
        String csvFile = "games.csv";
        String line;

            while (true) {
                try (BufferedReader br = new BufferedReader(new FileReader("games.csv"));) {
                    String headerLine = br.readLine();
                    br.readLine();
                    JOptionPane.showMessageDialog(null, headerLine, "Nice", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException a) {
                    System.out.print("No!");
                }
            }
        }
    }