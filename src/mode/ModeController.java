package mode;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import game.GameModel;
import game.GamePanel;
import main.Controller;

public class ModeController extends Controller {
    ModeModel mm;
    GameModel gm;
    GamePanel gp;

    public ModeController(){
        //System.out.println("modeCon created");
    }

    //add
    public void addModeModel(ModeModel mm){
        this.mm = mm;
    }

    public void addGameModel(GameModel gm){
        this.gm = gm;
    }

    public void addGamePanel(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton)e.getSource();
        String buttonname = jb.getText();
    
        if(buttonname.equals("classic")) {
            System.out.println("classic mode");
            mm.setmodeINVIS();
            gm.setgameVIS();
            gp.changeCounterText("classic mode");
        }

        if(buttonname.equals("timeattack")) {
            System.out.println("time attack mode");
            mm.setmodeINVIS();
            gm.setgameVIS();
            gm.setCounter(10);
            gp.changeCounterText("time attack mode");
            gm.startTimer(1000);  
        }
    }
    
}
