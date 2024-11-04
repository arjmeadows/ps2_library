public class Game {

    private String title;
    private String boxsrc;

   public Game(String title, String boxsrc) {
       this.title = title;
       this.boxsrc = boxsrc;

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
