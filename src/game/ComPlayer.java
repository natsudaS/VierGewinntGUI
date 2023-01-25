package game;

import java.util.*;


import main.User;

public class ComPlayer extends User {
    Random random = new Random();
    int [][] field;
    int currPlayer;
    int playerNumber;
    int col;
    
    public ComPlayer(){
        super("ComSpieler");
        System.out.println("com player inistialized");
    }

    public void updateField(int[][] field, int currPlayer){
        System.out.println("field updated");
        this.field = field;
        this.currPlayer = currPlayer;
    }

    public int setStone(){
        System.out.println("com sets stone");
        col = 0;
        if(currPlayer == 0){ //erster Zug, com zieht zuerst
            col = setRandom();
            playerNumber = 1;
            System.out.println("comspieler ist spieler 1");
        }
        if(currPlayer == 1){ //erster Zug, com zieht als zweites
            playerNumber = 2;
            col = setRandom();
            while(col == posPlayer){
                col = setRandom();
            }
        }
        if(currPlayer >= 2){
            col = computeStonePlacement();
        }
        return col;
    }

    private int computeStonePlacement(){
        System.out.println("computeStonePlacement called");
        int number = 0;

        
        return number;
    }

    private int setRandom(){
        System.out.println("setRandom called");
        return random.nextInt(7);
    }
}
