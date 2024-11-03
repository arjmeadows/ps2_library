import javax.swing.*;
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

        // creates a text field and stores it as a variable
        JTextField inf = UI.inputField();
        frame.add(inf);


        JButton addGameButton = UI.addGameButton("Add game",6,8,1,1);
        frame.add(addGameButton);
        addGameButton.addActionListener(new ActionListener() { // listen for click
            @Override
            public void actionPerformed(ActionEvent e) {
                String capt = inf.getText();
                Library.addGame(capt);
            }
        });

frame.add(UI.gameList(Library.seelib()));


        // render frame and components inside it
            // add elements to frame

            // render frame finally
        frame.setVisible(true);

    }


     }
