import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;

public class Main {

    private static String selectedGame = "";
    private static ImageIcon imageIcon1 = new ImageIcon(selectedGame);
    private JFrame frame;

    public static void main(String[] args) {

        System.out.println(selectedGame);

        // create objects
        Library Library = new Library();
        UI UI = new UI();
        final DatabaseManager dbManager = new DatabaseManager();

        // create frame
        JFrame frame = new JFrame("Game Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1920);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JList test = UI.gameList(Library.seelib(), frame);
        frame.add(test);

        // creates a text field and stores it as a variable
        JTextField inf = UI.inputField();
        frame.add(inf);

        JTextField boxsrc = UI.inputField();
        frame.add(boxsrc);

        JLabel box1 = UI.gameBox(imageIcon1);
        frame.add(box1);
        box1.revalidate();
        box1.repaint();
        frame.revalidate();
        frame.repaint();

        test.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                String sql1 = "SELECT title, box, boxart FROM games WHERE title = ?";

                try (Connection conn = dbManager.connect();
                     PreparedStatement stmt = conn.prepareStatement(sql1)) {
                    String selectedGame = (String) test.getSelectedValue();
                    stmt.setString(1, selectedGame);

                    try (ResultSet rs = stmt.executeQuery()) {

                        if (rs.next()) {
                            String title = rs.getString("title");
                            String box = rs.getString("box");
                            String boxart = rs.getString("boxart");

                            System.out.println(title + boxart);

                            imageIcon1 = new ImageIcon(boxart);
                            box1.setIcon(imageIcon1);
                            System.out.println(title + boxart);
                            box1.revalidate();
                            box1.repaint();
                            frame.revalidate();
                            frame.repaint();

                            }
                    } // ResultSet auto-closes here
                } catch (SQLException ex) {
                    throw new RuntimeException("Database error: " + ex.getMessage(), ex);
                } finally {
                    // Connection auto-closes due to try-with-resources
                }
            }
        });

        JButton addGameButton = UI.addGameButton("Add game");

        addGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String capt = inf.getText();
                String capt2 = boxsrc.getText();
                File selectedFile = UI.getSelectedFile();
                Library.addGame(capt, capt2, selectedFile);
                test.setModel(Library.seelib());
                test.revalidate();
                test.repaint();
            }
        });

        UI.Uploadbutton(frame);





        frame.setVisible(true);
        frame.add(addGameButton);
    }
}
