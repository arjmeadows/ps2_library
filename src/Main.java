import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListResourceBundle;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

    private static String selectedGame = "src/p4.jpg";
    private static ImageIcon imageIcon1 = new ImageIcon(selectedGame);
private JFrame frame;



    public static void main(String[] args) {

        System.out.println(selectedGame);

        // create objects
        Library Library = new Library(); // can I invoke two objects w3ith different names, but then use () to modify?
        UI UI = new UI();




        // create frame
        JFrame frame = new JFrame("Game Library"); // create frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes frame
        frame.setSize(1080, 1920); // sets frame size
        frame.setLayout(new GridBagLayout()); // sets layout type


        JList test = UI.gameList(Library.seelib(), frame);
        frame.add(test);


        // creates a text field and stores it as a variable
        JTextField inf = UI.inputField();
        frame.add(inf);


    JLabel label = new JLabel(imageIcon1); // this could be in the UI class.
        GridBagConstraints label_gbc = new GridBagConstraints(); //creates constraint to assign to button

        //  define constraints
        label_gbc.gridx = 1; // Column
        label_gbc.gridy = 1; // Row
        label_gbc.anchor = GridBagConstraints.NORTH; // Anchor position
        label_gbc.weightx = 1; // Horizontal weight
        label_gbc.weighty = 1; // Vertical weight
        label_gbc.insets = new Insets(1, 1, 1, 1); // Insets for spacing

        frame.add(label, label_gbc);







        test.addListSelectionListener(new ListSelectionListener() {

                                          @Override
                                          public void valueChanged(ListSelectionEvent e) {
                                              // Check if the event is not adjusting (to prevent double calls)
                                              selectedGame = (String) test.getSelectedValue(); // Get the selected item
                                              imageIcon1 = new ImageIcon(selectedGame);
                                              label.setIcon(imageIcon1);
                                              System.out.println(selectedGame);
                                              label.revalidate();
                                              label.repaint();
                                              frame.revalidate();
                                              frame.repaint();
                                          }
                                      });


        JButton addGameButton = UI.addGameButton("Add game",3,3,1,1, frame);
        addGameButton.addActionListener(new ActionListener() { // listen for click
            @Override
            public void actionPerformed(ActionEvent e) {
                String capt = inf.getText();
                Library.addGame(capt);
                test.setModel(Library.seelib());
                test.revalidate();
                test.repaint();

            }

        });





        // render frame finally
        frame.setVisible(true);


    }


     }
