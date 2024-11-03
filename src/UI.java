import javax.swing.*;
import java.awt.*;


public class UI {


    public void plainmodal(String modaltitle, String modalmessage) {
        modaltitle = modaltitle;
        modalmessage = modalmessage;
        JOptionPane.showMessageDialog(null, modalmessage, modaltitle, JOptionPane.PLAIN_MESSAGE);
    }


    public JButton addGameButton(String buttonText) { // create and define add button

        //create button
        JButton addGameButton = new JButton(buttonText); // creates button
        GridBagConstraints addGameButton_gbc = new GridBagConstraints(); //creates constraint o assign to button

        return addGameButton;
    }


    // create input field UI
    public JTextField inputField() {
        JTextField inputField = new JTextField(10);
        inputField.setEditable(true);
        GridBagConstraints inputField_gbc = new GridBagConstraints(); //creates constraint to assign to button


        //  define constraints
        inputField_gbc.gridx = 1; // Column
        inputField_gbc.gridy = 1; // Row
        inputField_gbc.anchor = GridBagConstraints.EAST; // Anchor position
        inputField_gbc.weightx = 0; // Horizontal weight
        inputField_gbc.weighty = 0; // Vertical weight
        inputField_gbc.insets = new Insets(1, 1, 1, 1); // Insets for spacing


        return inputField;
    }


    // create gameList
    public JList gameList(DefaultListModel list, JFrame frame) {
        JList<String> jList = new JList<>(list); // Create JList with items
        jList.setPreferredSize(new Dimension(150, 900)); // Width: 300 pixels, Height: 200 pixels
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(jList); // Use CENTER to fill the space
        jList.repaint();
        jList.revalidate();


        GridBagConstraints list_gbc = new GridBagConstraints(); //creates constraint to assign to button


        //  define constraints
        list_gbc.gridx = 3; // Column
        list_gbc.gridy = 3; // Row
        list_gbc.anchor = GridBagConstraints.NORTH; // Anchor position
        list_gbc.weightx = 0; // Horizontal weight
        list_gbc.weighty = 0; // Vertical weight
        list_gbc.insets = new Insets(1, 1, 1, 1); // Insets for spacing




        return jList;
    }


    public JLabel gameBox (ImageIcon imageIcon1) {
        JLabel label = new JLabel(imageIcon1); // this could be in the UI class.
        GridBagConstraints label_gbc = new GridBagConstraints(); //creates constraint to assign to button

        //  define constraints
        label_gbc.gridx = 3; // Column
        label_gbc.gridy = 3; // Row
        label_gbc.anchor = GridBagConstraints.NORTH; // Anchor position
        label_gbc.weightx = 1; // Horizontal weight
        label_gbc.weighty = 1; // Vertical weight
        label_gbc.insets = new Insets(1, 1, 1, 1); // Insets for spacing

        return label;
    }


    }


