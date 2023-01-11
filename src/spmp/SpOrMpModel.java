package spmp;

import main.Observer;

public class SpOrMpModel {
    //vars
    Observer spmpview;

    //visibility
    public void setSpmpVIS() {
        //System.out.println("smp vis");
        spmpview.setVisible(true);
    }

    public void setSpmpINVIS() {
        //System.out.println("smp invis");
        spmpview.setVisible(false);
    }

    //add view
    public void addSPMPObserver(SpOrMpPanel o) {
        this.spmpview  = o; 
        //System.out.println("smp to smm success");
    }
}
