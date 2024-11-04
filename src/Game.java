import javax.swing.*;

public class Game {

    private String title;
    private String boxsrc;
    private DefaultListModel<String> list;


    public DefaultListModel getList() {
        return list;
    }

    public void setList(DefaultListModel list) {
        this.list = list;
    }


   public Game(String title, String boxsrc, DefaultListModel<String> list) {
       this.title = title;
       this.boxsrc = boxsrc;
       this.list = list;

   }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBoxsrc() {
        return boxsrc;
    }

    public void setBoxsrc(String boxsrc) {
        this.boxsrc = boxsrc;
    }

}
