package game;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

import main.Controller;
import main.Observer;

public class GamePanel extends Observer{
    //vars
    Controller gmc;
    GameModel gm;

    JLabel playerText = new JLabel("game start");
    JLabel counterText = new JLabel("Classic Mode");
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");

    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
        ImagePanel imagePanel;
        JPanel buttonPanel = new JPanel();
    

    public GamePanel() throws IOException {
        //Layout
        imagePanel  = new ImagePanel();
        setLayout(new BorderLayout());
        setSize(new Dimension(600,650));
        setVisible(false);

        northPanel.setLayout(new GridLayout(2,1));
        northPanel.add(counterText);
        northPanel.add(playerText);
        counterText.setHorizontalAlignment(JLabel.CENTER);
        playerText.setHorizontalAlignment(JLabel.CENTER);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(imagePanel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);

        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        imagePanel.setSize(new Dimension(600,400));

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setSize(new Dimension(600,100));
        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);
        buttonPanel.add(four);
        buttonPanel.add(five);
        buttonPanel.add(six);
        buttonPanel.add(seven);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    //add
    @Override
    public void  addController(Controller controller){
        this.gmc = controller;

        one.addActionListener(gmc);
        two.addActionListener(gmc);
        three.addActionListener(gmc);
        four.addActionListener(gmc);
        five.addActionListener(gmc);
        six.addActionListener(gmc);
        seven.addActionListener(gmc);
    }
    
    public void addGameModel(GameModel model){
        this.gm = model;
    }

    //perform changes
    public void changePlayerText(String newText){
        playerText.setText(newText);
    }

    public void changeCounterText(String newText){
        counterText.setText(newText);
    }

    public ImagePanel getInstanceImagePanel(){
        return imagePanel;
    }

}
