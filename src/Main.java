import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {

        // create objects
        Library Library = new Library(); // can I invoke two objects w3ith different names, but then use () to modify?
        UI UI = new UI();

        // create frame
        JFrame frame = new JFrame("Game Library"); // create frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes frame
        frame.setSize(900, 800); // sets frame size
        frame.setLayout(new GridBagLayout()); // sets layout type

        // button and field to add game to DB
            // add game button
        JButton addGameButton = UI.addGameButton("Add game",6,8,1,1);
        frame.add(addGameButton);
        addGameButton.addActionListener(new ActionListener() { // listen for click
            @Override
            public void actionPerformed(ActionEvent e) {
                Library.addGame(UI.inputField());
            }
        });


        // render frame and components inside it
            // add elements to frame
        frame.add(UI.inputField());
        frame.add(UI.gameList(Library.seelib()));

            // render frame finally
        frame.setVisible(true);

    }
                                          }
