package spmp;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.Controller;
import main.Observer;

public class SpOrMpPanel extends Observer {
    private static final long serialVersionUID = 1L;
    
    //vars
        Controller smc;

        JLabel spormptext = new JLabel("Einzel oder Mehrspieler");	
        JButton spbutton = new JButton("Singleplayer");
        JButton mpbutton = new JButton("Multiplayer");
     
    
    public SpOrMpPanel() {
        this.add(spormptext);
        this.add(spbutton);
        spbutton.setName("singleplayer");
        this.add(mpbutton);
        mpbutton.setName("multiplayer");
        this.setSize(600, 400);
        this.setVisible(false);
    }

    //add Controller
	@Override
    public void addController(Controller controller) {
        //System.out.println("spmpcont to spmppan success");
        this.smc = controller;
        spbutton.addActionListener(controller);
        mpbutton.addActionListener(controller);
    }

}
