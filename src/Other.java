import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class Other {
    public static void main(String[] args) {
    }
        public static void other() {

        // create frame
        JFrame frame = new JFrame("Game Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());


        // create buttons
        JButton button1 = new JButton("Add game");
        JButton delete = new JButton("Delete game");
        JButton button2 = new JButton("See library");
        JButton button3 = new JButton("Exit");
        JTextField textArea = new JTextField(20);
        textArea.setEditable(true);
        JTextArea listArea = new JTextArea(20,20);
        listArea.setEditable(true);


        // create objects
        Library newGame = new Library();
        Library showlibrary = new Library();


        // show list of games
        String games = showlibrary.seelib().toString();
        String[] splitgames = games.split("\n");
        JList<String> itemList = new JList<>(splitgames); // Create JList with items
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow single selection
        JScrollPane scrollPane = new JScrollPane(itemList); // Add JList to JScrollPane



//        // remove existing items;
//        itemList.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                if (!e.getValueIsAdjusting()) {
//                    Library deleteGame = new Library();
//                    String selectedItem = itemList.getSelectedValue();
//
//                    // call delete method on button press
//                    delete.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            deleteGame.removeGame(selectedItem);
//                            delete.repaint();     // Forces the component to repaint itself
//
//                        }
//                    });
//                }
//            }
//        });


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
                showlibrary.seelib();

            }
        });

        // Add components to the frame
        frame.add(new JLabel("Enter Game Name:"));
        frame.add(button1);
        frame.add(button2);
        frame.add(textArea);
        frame.add(itemList);
        frame.add(delete);

        // Make the frame visible
        frame.setVisible(true);
        panel.setVisible(true);

}

    }


// date causing issue? try a prefilled text box