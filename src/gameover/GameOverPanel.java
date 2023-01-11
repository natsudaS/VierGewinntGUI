package gameover;

import javax.swing.JLabel;

import game.GamePanel;
import main.Observer;

public class GameOverPanel extends Observer {
    //vars
    GameOverController goc;

    JLabel text = new JLabel("game over");

    public GameOverPanel(){
        add(text);
        setSize(600,400);
        setVisible(false);
    }

    //add
    public void addController(GameOverController goc){
        this.goc = goc;
    }

    public void addObserver(GamePanel gamepanel) {
    }
}
