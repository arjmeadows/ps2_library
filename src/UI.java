import javax.swing.*;
import java.awt.*;

public class UI {

    public void plainmodal(String modaltitle, String modalmessage) {
        modaltitle = modaltitle;
        modalmessage = modalmessage;
        JOptionPane.showMessageDialog(null, modalmessage, modaltitle, JOptionPane.PLAIN_MESSAGE);
    }

    public JButton addGameButton(String buttonText, int x, int y, int weightx, int weighty) { // create and define add button

        //create button
        JButton addGameButton = new JButton(buttonText); // creates button
        GridBagConstraints addGameButton_gbc = new GridBagConstraints(); //creates constraint o assign to button

        // define constraints
        addGameButton_gbc.gridx = x; // Column
        addGameButton_gbc.gridy = y; // Row
        addGameButton_gbc.anchor = GridBagConstraints.NORTH; // Anchor position
        addGameButton_gbc.weightx = weightx; // Horizontal weight
        addGameButton_gbc.weighty = weighty; // Vertical weight
        addGameButton_gbc.insets = new Insets(10, 1, 1, 1); // Insets for spacing

        return addGameButton;
    }

    // create input field UI
    public JTextField inputField() {
        JTextField inputField = new JTextField(20);
        inputField.setEditable(true);
        GridBagConstraints inputField_gbc = new GridBagConstraints(); //creates constraint to assign to button

        //  define constraints
        inputField_gbc.gridx = 1; // Column
        inputField_gbc.gridy = 1; // Row
        inputField_gbc.anchor = GridBagConstraints.SOUTH; // Anchor position
        inputField_gbc.weightx = 4; // Horizontal weight
        inputField_gbc.weighty = 5; // Vertical weight
        inputField_gbc.insets = new Insets(1, 1, 1, 1); // Insets for spacing

        return inputField;
    }

    // create gameList
    public JList gameList(DefaultListModel list, JFrame frame) {
        JList<String> jList = new JList<>(list); // Create JList with items
        jList.setPreferredSize(new Dimension(200, 800)); // Width: 300 pixels, Height: 200 pixels
      jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(jList); // Use CENTER to fill the space
        jList.repaint();
        jList.revalidate();


        return jList;
    }
}

