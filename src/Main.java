import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        // create frame
        JFrame frame = new JFrame("PS2 Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // create buttons
        JButton button1 = new JButton("Add game");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Exit");
        JTextField textArea = new JTextField(20);
        textArea.setEditable(true);


        // create objects
        Library newGame = new Library();

        // invite to add game
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame.addGame(textArea);            }

        });

        // Add components to the frame
        frame.add(new JLabel("Enter Game Name:"));
        frame.add(button1);
        frame.add(textArea);

        // Make the frame visible
        frame.setVisible(true);



    }
}