package spmp;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import login.LoginModel;
import main.Controller;
import mode.ModeModel;

public class SpOrMpController extends Controller {
    //vars
    SpOrMpModel smm;
    LoginModel loginmodel;
    ModeModel mm;

    public  SpOrMpController() {
        //System.out.println ("SpOrMp-Controller created");
    }

    //add
    public void addSPMPModel(SpOrMpModel smm){
        //System.out.println("smm to smc success");
        this.smm = smm;
    } 

    public void addLoginModel(LoginModel lm){
        //System.out.println("lm to smc success");
        this.loginmodel = lm;
    } 

    public void addModeModel(ModeModel mm) {
    	this.mm= mm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton)e.getSource();
        String buttonname = jb.getName();
        if(buttonname.equals("multiplayer")) {
            System.out.println("mp choosen");
        	smm.setSpmpINVIS();
        	loginmodel.setloginVIS();
        }
        if(buttonname.equals("singleplayer")) {
        	System.out.println("sp choosen");
            smm.setSpmpINVIS();
        	mm.setmodeVIS();
        }
    }
}
