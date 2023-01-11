package mode;

import javax.swing.JButton;

import main.Controller;
import main.Observer;

public class ModePanel extends Observer {
    //vars
    Controller mc;

    JButton classic = new JButton("classic");
    JButton timeattack = new JButton("timeattack");

    public ModePanel(){
        add(classic);
        add(timeattack);
        this.setSize(600, 400);
        this.setVisible(false);
    }

    //add
    public void addController(ModeController mc){
        this.mc = mc;
        classic.addActionListener(mc);
        timeattack.addActionListener(mc);
    }
}