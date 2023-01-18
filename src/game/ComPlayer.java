package game;

import java.util.*;


import main.User;

public class ComPlayer extends User {
    List<Integer> cols = new ArrayList<>();
    List<Integer> placedStones = new ArrayList<>();
    String comMode;
    int [][] field;
    int currPlayer;
    int playerNumber;
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

    public void updateField(int[][] field, int currPlayer){
        System.out.println("field updated");
        this.field = field;
        this.currPlayer = currPlayer;
    }

    public int setStone(){
        System.out.println("com sets stone");
        col = 0;
        if(currPlayer == 0){ //erster Zug zufällig
            col = setRandom();
            playerNumber = 1;
            System.out.println("comspieler ist spieler 1");
        } else
        if(currPlayer == 1){
            col = setRandom();
            playerNumber = 2;
        } else 
        if(currPlayer >= 2){
            col = computeStonePlacement();
        }
        placedStones.add(col);
        return col;
    }

    private int computeStonePlacement(){
        System.out.println("computeStonePlacement called");

        List<Integer> possMoves = new ArrayList<>();
        List<Integer> possRowHori = new ArrayList<>();

        for(int i = 0; i<7; i++){
            if(field[5][i]==0 || field[5][i]==playerNumber){
                possRowHori.add(i);
                System.out.println(i + " added to list of possible moves");
            } else
            if(field[5][i]==playerNumber){
                if(possRowHori.size()<4){
                    System.out.println(possRowHori.size());
                    possRowHori.removeAll(possRowHori);
                    System.out.println(possRowHori.size());
                } else {
                    System.out.println("nothing happend");
                }
            }
        }
        if(possRowHori.size()==0){
            System.out.println("waagerecht row 5 keine 4 in a row möglich");
            return placedStones.get(0);
        } else {
            Collections.shuffle(possRowHori);
            return possRowHori.get(0);
        }
    }

    private int setRandom(){
        System.out.println("setRandom called");
        List<Integer> clone = cols;
        Collections.shuffle(clone);
        return clone.get(0);
    }
}
