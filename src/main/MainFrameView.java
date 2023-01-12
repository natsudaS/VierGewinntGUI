package main;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.GamePanel;
import gameover.GameOverPanel;
import login.LoginPanel;
import mode.ModePanel;
import spmp.SpOrMpPanel;

public class MainFrameView {
    JFrame mainframe = new JFrame();

    // creating panels
	    LoginPanel loginpanel = new LoginPanel();
        SpOrMpPanel spmppanel = new SpOrMpPanel();
        ModePanel modepanel = new ModePanel();
        GamePanel gamepanel;
        GameOverPanel gameoverpan = new GameOverPanel();

    public MainFrameView() throws IOException {
        System.out.println("MainFrameView created");
        gamepanel = new GamePanel();
        mainframe.setSize(600, 400);
        mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adding all available panels
            mainframe.add(loginpanel);
            setContent(loginpanel);
            mainframe.add(spmppanel);
            mainframe.add(modepanel);
            mainframe.add(gamepanel);
            mainframe.add(gameoverpan);
    }

    public void setContent(JPanel rightcontent) {
		rightcontent.setVisible(true);
	}
}
