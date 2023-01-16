package game;

import java.util.*;


import main.User;

public class ComPlayer extends User {
    List<Integer> cols = new ArrayList<>();
    String comMode;
    int [][] field;
    int col;
    
    
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

    public void updateField(int[][] field){
        this.field = field;
    }

    public int checkField(){
        
        return 0;
    }

    public int setStone(){
        col = 0;
        Collections.shuffle(cols);
        col = cols.get(0);
        return col;
    }
}
