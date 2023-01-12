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
	JLabel passtext = new JLabel("Enter Password");
	JTextField passfield = new JTextField(10);
    JButton loginbutton = new JButton("login");
	JButton registerbutton = new JButton("register");

    // errorcodes
	JLabel registerror = new JLabel("Registerung fehlgeschlagen, Nutzername bereits belegt");
	JLabel registerok = new JLabel("Registriereung erfolgreich");
	JLabel loginerror = new JLabel("Login fehlgeschlafen");
	JLabel loginok = new JLabel("Login erfolgreich");

    public LoginPanel(){
        System.out.println("loginPanel created");
        // the normal panel stuff
		this.add(logintext);
        this.add(loginfield);
		this.add(passtext);
		this.add(passfield);
		this.add(loginbutton);
		this.add(registerbutton);
        loginbutton.setName("login");
		registerbutton.setName("register");

        // error messages
        this.add(registerror);
		registerror.setVisible(false);
		this.add(registerok);
		registerok.setVisible(false);
		this.add(loginerror);
		loginerror.setVisible(false);
		this.add(loginok);
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
        registerbutton.addActionListener(controller);
    }

    //throw error message
    public void throwregistererror() {
		clearmsg();
		registerror.setVisible(true);
	}

	public void throwregisterokay() {
		clearmsg();
		registerok.setVisible(true);
	}

	public void throwloginerror() {
		clearmsg();
		loginerror.setVisible(true);
	}

	public void throwloginok() {
		clearmsg();
		loginok.setVisible(true);

	}

	public void clearmsg() {
		registerror.setVisible(false);
		registerok.setVisible(false);
		loginerror.setVisible(false);
		loginerror.setVisible(false);
	}
}
