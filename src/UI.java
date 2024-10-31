import javax.swing.*;

public class UI {


    public void plainmodal(String modaltitle, String modalmessage) {
        modaltitle = modaltitle;
        modalmessage = modalmessage;
        JOptionPane.showMessageDialog(null, modalmessage, modaltitle, JOptionPane.PLAIN_MESSAGE);
    }

}