package game;

import java.util.*;


import main.User;

public class ComPlayer extends User {
    List<Integer> cols = new ArrayList<>();
    String comMode;
    int [][] field;
    int currPlayer;
    int playerNumber;
    int col;
    List<Integer> placedStones = new ArrayList<>();
    
    
    public ComPlayer(){
        super("ComSpieler");
        cols.add(0);
        cols.add(1);
        cols.add(2);
        cols.add(3);
        cols.add(4);
        cols.add(5);
        cols.add(6);
        System.out.println("com player inistialized");
    }

    public void updateField(int[][] field, int currPlayer){
        this.field = field;
        this.currPlayer = currPlayer;
    }

    public int setStone(){
        col = 0;
        if(currPlayer == 0 || currPlayer == 1){ //erster Zug zufällig
            col = setRandom();
        } else {
            col = computeStonePlacement();
        }
        placedStones.add(col);
        return col;
    }

    private int computeStonePlacement(){
        placedStones.get(0); //vertikal+
        for(int i = 0; i<6; i++){}
        return 0;
    }

    private int setRandom(){
        List<Integer> clone = cols;
        Collections.shuffle(clone);
        return clone.get(0);
    }
}
