package login;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Controller;
import main.Observer;

public class LoginPanel extends Observer{
    private static final long serialVersionUID = 1L;

    //vars
    Controller lc;

    JLabel logintext = new JLabel("Enter Username");
		JTextField loginfield = new JTextField(10);
    JButton loginbutton = new JButton("login");

    // errorcodes
		JLabel loginok = new JLabel("Login erfolgreich");

    public LoginPanel(){
      System.out.println("loginPanel created");
      
			// the normal panel stuff
			this.add(logintext);
			this.add(loginfield);
			this.add(loginbutton);
		
			loginbutton.setName("login");
		

      // error messages
			loginok.setVisible(false);

      //visibility
      this.setSize(600,400);
      this.setVisible(true);
    }

    //add Controller
		@Override
    public void addController(Controller controller) {
        //System.out.println("lc to lp success");
        this.lc = controller;
        loginbutton.addActionListener(controller);
    }

		public void throwloginok() {
			clearmsg();
			loginok.setVisible(true);

		}

		public void clearmsg() {
			loginok.setVisible(false);
		}
}
