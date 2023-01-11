package main;

import game.GameController;
import game.GameModel;
import gameover.GameOverController;
import gameover.GameOverModel;
import login.LoginController;
import login.LoginModel;
import mode.ModeController;
import mode.ModeModel;
import spmp.SpOrMpController;
import spmp.SpOrMpModel;

public class Main {
    public static void main(String[] args) throws Exception {
        //Frame
		    MainFrameView mf = new MainFrameView();

        //models
            LoginModel lm = new LoginModel();
            SpOrMpModel smm = new SpOrMpModel();
            ModeModel mm = new ModeModel();
            GameModel gm = new GameModel();
            GameOverModel gom = new GameOverModel();

        //controllers
            LoginController lc = new LoginController();
            SpOrMpController smc = new SpOrMpController();
            ModeController mc = new ModeController();
            GameController gmc = new GameController();
            GameOverController goc = new GameOverController();

        //login stuff
            mf.loginpanel.addController(lc);
            lm.addLoginView(mf.loginpanel); 
            lc.addLoginPanel(mf.loginpanel); 
            lc.addLoginModel(lm);
            lc.addSMModel(smm); 
            lc.addModeModel(mm); 

        // Singelplayer/Multiplayer stuff
            mf.spmppanel.addController(smc); 
            smm.addSPMPObserver(mf.spmppanel); 
            smc.addSPMPModel(smm); 
            smc.addLoginModel(lm); 
            smc.addModeModel(mm); 

        //ModeSelect stuff
            mf.modepanel.addController(mc);
            mm.addObserver(mf.modepanel);
            mc.addModeModel(mm);
            mc.addGameModel(gm);
            mc.addGamePanel(mf.gamepanel);
            
        //Gamepanel stuff
            mf.gamepanel.addController(gmc);
            mf.gamepanel.addGameModel(gm);
            mf.gamepanel.getInstanceImagePanel().addGameModel(gm);
            gm.addObserver(mf.gamepanel);
            gm.addLoginModel(lm);
            gmc.addGameModel(gm);
            gmc.addGamePanel(mf.gamepanel);
            gmc.addGOModel(gom);
        
        //GameOver stuff
            mf.gameoverpan.addController(goc);
            gom.addObserver(mf.gameoverpan);
            goc.addGOModel(gom);
    
    }
}
