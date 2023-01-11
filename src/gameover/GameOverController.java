package gameover;

import java.awt.event.ActionEvent;

import main.Controller;

public class GameOverController extends Controller {
    //vars
    GameOverModel gom;

    @Override
    public void actionPerformed(ActionEvent e) {
        // not yet needed
    }

    public void addGOModel(GameOverModel gom) {
        this.gom = gom;
    }
    
}
