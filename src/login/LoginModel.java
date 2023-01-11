package login;
import java.util.ArrayList;
import java.util.List;

import main.User;

public class LoginModel {
    //vars
    LoginPanel loginview;
    List<User> loggedin;
    
    public LoginModel () {
        //System.out.println("loginModel created");
        loggedin = new ArrayList<>();
    }

    //add view
    public void addLoginView( LoginPanel lp) {
    	//System.out.println("lp to lm success");
        loginview = lp;
    }

    //visibility 
    public void setloginVIS() {
        //System.out.println("lp vis");
        loginview.setVisible(true);
    }

    public void setloginINVIS() {
        //System.out.println("lp invis");
        loginview.setVisible(false);
    }

    //register user (database access)
    //find user (database access)

    //add user to list
    public void loginprocess(String user){
        loggedin.add(new User(user));
        loginview.throwloginok();
    }

    //get user list
    public List<User> getUserList() {
        if(loggedin.isEmpty()){
            System.out.println("no users registered yet");
        } else {
            //System.out.println("success");
        }
        return loggedin;
    }
}
