package game;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JPanel {
    //vars
    GameModel gm;
    List<Point> stoneListRed = new ArrayList<>();
    List<Point> stoneListGreen = new ArrayList<>();
    int stoneSize = 35;

    public ImagePanel() throws IOException{
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        BufferedImage img = ImageIO.read(new File("FeldT.png"));
        Image image = img.getScaledInstance(320, 276, Image.SCALE_SMOOTH);
        JLabel pic = new JLabel(new ImageIcon(image));
        add(pic);
    }

    //add
    public void addGameModel(GameModel model){
        this.gm = model;
    }

    //paint stones
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Point p : stoneListRed){ //sorgt dafür, dass alle punkte der liste zu sehen sind
            g.setColor(Color.RED);
            g.fillOval(p.x-stoneSize/2, p.y-stoneSize/2, stoneSize, stoneSize);
        }
        for (Point p : stoneListGreen){ //sorgt dafür, dass alle punkte der liste zu sehen sind
            g.setColor(Color.BLUE);
            g.fillOval(p.x-stoneSize/2, p.y-stoneSize/2, stoneSize, stoneSize);
        }
    }

    public void repaintField(){
        System.out.println("repaints called");
        int[][] gameField = gm.getField();
        
        for(int i=0; i<gameField.length; i++){ 
            for(int j=0; j<gameField.length+1; j++){ 
                if(gameField[i][j] == 1){
                    printStone(1,getCoordinates("x",j),getCoordinates("y",i));
                } else 
                if(gameField[i][j] == 2){
                    printStone(2,getCoordinates("x",j),getCoordinates("y",i));
                }
            } 
        } 
        repaint();
    }

    private int getCoordinates(String id, int index) {
        int value = 0;
        if(id.equals("x")){
            if(index == 0){
                value = 164;
            }
            if(index == 1){
                value = 210;
            }
            if(index == 2){
                value = 254;
            }
            if(index == 3){
                value = 299;
            }
            if(index == 4){
                value = 345;
            }
            if(index == 5){
                value = 390;
            }
            if(index == 6){
                value = 436;
            }
        } else
        if(id.equals("y")){
            if(index == 0){
                value = 30;
            }
            if(index == 1){
                value = 75;
            }
            if(index == 2){
                value = 121;
            }
            if(index == 3){
                value = 168;
            }
            if(index == 4){
                value = 214;
            }
            if(index == 5){
                value = 259;
            }
        }
        return value;
    }

    private void printStone(int player, int x, int y) {
        if(player == 1){ 
            Point newStone = new Point(x,y);
            stoneListRed.add(newStone);
            //System.out.println("new stone added to red");
        } else
        if(player == 2){
            Point newStone = new Point(x,y);
            stoneListGreen.add(newStone);
            //System.out.println("new stone added to green");
        }
    }
}
