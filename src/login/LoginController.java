package login;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import main.Controller;
import mode.ModeModel;
import spmp.SpOrMpModel;

public class LoginController extends Controller {
    //vars
    LoginModel lm;
    LoginPanel lp;
    SpOrMpModel smm;
    ModeModel mm;
    
    public LoginController() {
        //System.out.println ("LoginController created");
    }

    //add
    public void addLoginModel(LoginModel lm){
        //System.out.println("lm to lc success");
        this.lm = lm;
    }

    public void addLoginPanel(LoginPanel lp) {
        //System.out.println("lp to lc success");
        this.lp = lp;
    }

    public void addSMModel(SpOrMpModel smm){
        this.smm = smm;
    }

    public void addModeModel(ModeModel mm){
        this.mm = mm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton)e.getSource();
        String buttonname = jb.getName();
    
        if(buttonname.equals("register")) {
            //lm.registerUser(lp.loginfield.getText(), lp.passfield.getText());
            System.out.println("no connection to database");
        }
            
        if (buttonname.equals("login")) {
            System.out.println("login btn pressed");
            lm.loginprocess(lp.loginfield.getText());
            if (lm.loggedin.size()==2) {
                System.out.println("choose game mode");
                //System.out.println(lm.loggedin.size());
                lm.setloginINVIS();
                mm.setmodeVIS();
            } else {
                System.out.println("sp/mp choose");
                //System.out.println(lm.loggedin.size());
                lm.setloginINVIS();
                smm.setSpmpVIS();
            }      
        }	
    }
}


