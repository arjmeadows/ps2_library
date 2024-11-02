import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {

        // create frame
        JFrame frame = new JFrame("Game Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();

        // create buttons
        JButton button1 = new JButton("Add game");
        JButton delete = new JButton("Delete game");
        JButton button2 = new JButton("See library");
        JButton button3 = new JButton("Exit");
        JTextField textArea = new JTextField(20);
        textArea.setEditable(true);
        JTextArea listArea = new JTextArea(20,20);
        listArea.setEditable(true);

        // add image
        ImageIcon imageIcon = new ImageIcon("src/mgs_cover.jpg");
        JLabel label = new JLabel(imageIcon);

        // create objects
        Library newGame = new Library();



        // invite to add game
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame.addGame(textArea);

                                                      }

        });

        // open existing library
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Other.other();

            }
        });

        // Add components to the frame
        frame.add(new JLabel("Enter Game Name:"));
        frame.add(button1);
        frame.add(textArea);
        //   frame.add(delete);
        newGame.showList(frame); // calls method that shows list


        // Make the frame visible
        frame.setVisible(true);
        panel.setVisible(true);


                                              }
                                          }
