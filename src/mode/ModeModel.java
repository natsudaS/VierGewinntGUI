package mode;

public class ModeModel {
    //vars
    ModePanel modepan;

    public ModeModel (){
        //System.out.println("modeModel created");
    }

    //add view
    public void addObserver( ModePanel mp) {
    	//System.out.println("lp to lm success");
        modepan = mp;
    }

    //visibility 
    public void setmodeVIS() {
        //System.out.println("mp vis");
        modepan.setVisible(true);
    }

    public void setmodeINVIS() {
        //System.out.println("mp invis");
        modepan.setVisible(false);
    }
}
