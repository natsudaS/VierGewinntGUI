package gameover;

public class GameOverModel {
    //vars
    GameOverPanel gop;

    //add
    public void addObserver(GameOverPanel gop){
        this.gop = gop;
    }

    public void setgoVIS() {
        gop.setVisible(true);
    }

    public void setgoINVIS() {
        gop.setVisible(false);
    }
    
}
