//import javax.swing.*;
//import javax.swing.border.Border;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import static javax.swing.JOptionPane.showMessageDialog;
//
//public class oldmain {
//    public static void main(String[] args) {
//
//
//
//        // create frame
//        JFrame frame = new JFrame("Game Library");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(1920, 1080);
//        frame.setLayout(new GridBagLayout());
//
//
//        // create buttons
//        JButton button1 = new JButton("Add game");
//        JButton delete = new JButton("Delete game");
//        JButton button2 = new JButton("See library");
//        JButton button3 = new JButton("Exit");
//        JTextField textArea = new JTextField(20);
//        textArea.setEditable(true);
//
//        // constraint
//        GridBagConstraints gbcButton1 = new GridBagConstraints();
//        gbcButton1.gridx = 9;
//        gbcButton1.gridy = 1;
//        gbcButton1.anchor = GridBagConstraints.EAST;
//        frame.add(button1, gbcButton1); //
//
//        JTextField developer = new JTextField(20);
//        textArea.setEditable(true);
//
//        JTextArea listArea = new JTextArea(20,20);
//        listArea.setEditable(false);
//
//        // add image
//
//        // create objects
//        Library newGame = new Library();
//
//
////        // invite to add game
////        button1.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                newGame.addGame(textArea);
////            }
//
//        });
//
//
//        // Add components to the frame
////        frame.add(new JLabel("Enter Game Name:"), BorderLayout.NORTH);
////        frame.add(button1);
////        frame.add(textArea);
////        frame.add(developer);
////
////        newGame.showList(frame);
//
//
//        //   frame.add(delete);
//
//        // Make the frame visible
//        frame.setVisible(true);
//
//
////        public void showimage(newGame.selectedGame(String selectedGame)));
////        ImageIcon imageIcon = new ImageIcon(selectedGame);
////        JLabel label = new JLabel(imageIcon);
////        frame.add(label);
////        label.getParent().revalidate();
////        label.getParent().repaint();
//    }
//}
