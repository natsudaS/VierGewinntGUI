package game;
import java.awt.event.ActionEvent;

import gameover.GameOverModel;
import main.Controller;

public class GameController extends Controller {
    //vars
    GameModel gamemodel;
    GameOverModel gom;
    GamePanel gamepanel;
    ImagePanel imgPan;
    
    public  GameController() {
        //System.out.println ("Gamecontroller created");
    }

    //add
    public void addGameModel(GameModel gm){
        //System.out.println("gm to gmc success");
        this.gamemodel = gm;
    } 

    public void addGamePanel(GamePanel gp){
        //System.out.println("gp to gmc success");
        this.gamepanel = gp;
        imgPan = gamepanel.getInstanceImagePanel();
    }

    public void addGOModel(GameOverModel gom) {
        //System.out.println("gom to gmc success");
        this.gom = gom;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(gamemodel.checkWin() == false){
            if(e.getSource() == gamepanel.one){
                System.out.println("button one works");
                gamemodel.setStone(1);
            } else
            if(e.getSource() == gamepanel.two){
                System.out.println("button two works");
                gamemodel.setStone(2);
            } else
            if(e.getSource() == gamepanel.three){
                System.out.println("button three works");
                gamemodel.setStone(3);
            } else
            if(e.getSource() == gamepanel.four){
                System.out.println("button four works");
                gamemodel.setStone(4);
            } else
            if(e.getSource() == gamepanel.five){
                System.out.println("button five works");
                gamemodel.setStone(5);
            } else
            if(e.getSource() == gamepanel.six){
                System.out.println("button six works");
                gamemodel.setStone(6);
            } else
            if(e.getSource() == gamepanel.seven){
                System.out.println("button seven works");
                gamemodel.setStone(7);
            }
            //gamepanel.changePlayerText(gamemodel.getCurrentUsername() + ", Du bist dran!");
            //gamemodel.printField();
        }
        /*if(gamemodel.checkWin() == true){
            gamepanel.changePlayerText(gamemodel.getCurrentUsername() + ", Du hast gewonnen!");  
            if(gamemodel.timeattack == true){
                gamemodel.endTimer();
            } 
            //gamemodel.setgameINVIS();
            //gom.setgoVIS();
        }*/
    }

}
