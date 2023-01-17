package game;
import java.util.*;

import login.LoginModel;
import main.User;

public class GameModel {
    //vars
    GamePanel gameview;
    ImagePanel imgPan;
    LoginModel lm;
    List<User> userList;
    ComPlayer com;

    boolean singleplayer = false;
    boolean timeattack = false;
    boolean comturn = false;
    int [][] field = new int [6][7];
    int currPlayer = 0;
    int check; 
    int countWin;
    Timer timer;
    TimerTask task;
    int counter;

    public GameModel (){
        //System.out.println("GameModel created");
    }

    //add
    public void addObserver( GamePanel o ) {
        this.gameview  = o;
        imgPan = gameview.getInstanceImagePanel();
        //System.out.println("lm lp success");
    }

    public void addLoginModel(LoginModel lm) {
        this.lm = lm;
        userList = lm.getUserList();
    }

    //visibility
    public void setgameVIS() {
        System.out.println("gp vis");
        gameview.setVisible(true);
        startGame();
    }

    public void setgameINVIS() {
        //System.out.println("gp invis");
        gameview.setVisible(false);
    }
    
    //game start
    private void startGame(){
        initializeField();

        if(timeattack == true){
            //System.out.println("called timer");
            gameview.changeCounterText("Time Attack Mode");
            startTimer(500);
        }

        if(userList.size() == 1){
            singleplayer = true;
            System.out.println("singleplayer: "+singleplayer);
            com = new ComPlayer();
            userList.add(com);   
        }

        System.out.println("userList before shuffel: "+userList.get(0).getUsername()+" "+userList.get(1).getUsername());
        Collections.shuffle(userList);
        System.out.println("userList after shuffel: "+userList.get(0).getUsername()+" "+userList.get(1).getUsername());
        
        if(singleplayer == true && userList.get(0).getUsername().equals("ComSpieler")){
            setStone(0);
        } else {
            gameview.changePlayerText(getCurrentUsername() + ", Du bist dran!");
        }
    }

    //player
    public int getCurrentPlayer(){
        int player = 0;

        if(currPlayer%2 == 0){
            player = 1;
        } else {
            player = 2;
        }
        return player;
    }

    public String getCurrentUsername(){
        int currentPlayer = getCurrentPlayer(); 
        return userList.get(currentPlayer-1).getUsername();
    }

    //field
    public void setStone(int column){
        int r = field.length-1; // r -> row 
        int c; // c -> column, could be 0 to 6 
        int p = getCurrentPlayer(); //could be 1 or 2 

        if(singleplayer==true && getCurrentUsername().equals("ComSpieler")){
            com.updateField(field,currPlayer);
            gameview.changePlayerText(getCurrentUsername() + " setzt!");
            System.out.println("com setzt");
            comturn = true;
            c = com.setStone();
        } else {
            System.out.println("spieler hat gesetzt");
            c = column-1;
        }

        if (c >= 0 && c <= 6) { //if that's not the case: IndexOutOfBound Exception
            if (field [r][c] == 0) { 
                field [r][c] = p; 
                System.out.println("index: " +r+"/"+c);
            } else {  
                while (field [r][c] != 0){ 
                    r--; //decreases the index of the row to climb higher on the board
                    System.out.println("row: "+r);
                } 
                field [r][c] = p; 
                System.out.println("index: " +r+"/"+c);
            } 
        } else {
            System.out.println("Da kannst du nicht setzen!!!");
        }

        if(timeattack==true){
            endTimer();
            startTimer(500);
        }

        if(comturn == true){
            Timer delay = new Timer();
            TimerTask delayTask = new TimerTask(){
                @Override
                public void run(){
                    imgPan.repaintField();
                    if (checkWin() == false){
                        currPlayer++;
                        gameview.changePlayerText(getCurrentUsername() + ", Du bist dran!");
                    } else {
                        System.out.println("Spieler " + userList.get(p-1).getUsername() + " gewinnt.");
                        gameview.changePlayerText(getCurrentUsername() + " gewinnt!");
                    }
                    delay.cancel();
                }
            };
            delay.schedule(delayTask, 1000);
        } else {
            imgPan.repaintField();
            System.out.println(checkWin());
            if (checkWin() == false){
                currPlayer++;
                gameview.changePlayerText(getCurrentUsername() + ", Du bist dran!");
                if (singleplayer == true && comturn == false){
                    setStone(0);
                } 
            } else {
                System.out.println("Spieler " + userList.get(p-1).getUsername() + " gewinnt.");
                gameview.changePlayerText(getCurrentUsername() + " gewinnt!");
            }
            
        }
        printField();
        comturn = false;
    }

    public int[][] getField() {
        return field;
    }

    private void printField(){
        for(int i=0; i<field.length; i++){ 
            for(int j=0; j<field.length+1; j++){ 
                System.out.print(field[i][j]); 
            } 
            System.out.println();
        } 
    }

    private void initializeField(){
        System.out.println("field initialized");
        for(int i=0; i<field.length; i++){ 
            for(int j=0; j<field.length+1; j++){ 
                field[i][j] = 0; 
            } 
        } 
    }

    //timer for time attack mode
    public void setCounter(int sec){
        System.out.println("counter set");
        timeattack = true;
        System.out.println("timeattack: "+timeattack);
        counter = sec;
        System.out.println("counter: "+counter);
    }

    public void startTimer(int delay){
        System.out.println("timer started");
        System.out.println("counter: "+counter);
        timer = new Timer();
        task = new TimerTask(){
            int time = counter;
            @Override
            public void run() {
                if(time >=0){
                    System.out.println(time);
                    if(time>=10){
                        gameview.changeCounterText("verbleibende Zeit: 00:"+time);
                    } else
                    if(time<10){
                        gameview.changeCounterText("verbleibende Zeit: 00:0"+time);
                    }
                    time--;
                } else {
                    System.out.println("times up");
                    gameview.changeCounterText("times up, you missed your chance");
                    currPlayer++;
                    gameview.changePlayerText(getCurrentUsername() + ", Du bist dran!");
                    endTimer();
                    startTimer(500);
                }
            }
        };
        timer.schedule(task, delay, 1000);
    }

    public void endTimer(){
        timer.cancel();
        timer.purge();
    }

    //win conditions
    boolean checkWin(){
        boolean winnerFound = false;
        int p = 0; //player for differantiating between stones of p1 and p2
        int rowIndex;
        int colIndex;

        for(int i=5;i>=0;i--){
            for(int j=0;j<7;j++){ 
                if(field[i][j]==1){
                    p = 1; 
                    rowIndex = i; 
                    colIndex = j; 

                    if(checkHori(field, rowIndex, colIndex, p)!=true){   
                        if(checkVert(field, rowIndex, colIndex, p)!=true){ 
                            if(checkDiagR(field, rowIndex, colIndex, p)!=true){ 
                                checkDiagL(field, rowIndex, colIndex, p);
                            } 
                        } 
                    }  
                } else
                if(field[i][j]==2){
                    p = 2; 
                    rowIndex = i; 
                    colIndex = j;

                    if(checkHori(field, rowIndex, colIndex, p)!=true){   
                        if(checkVert(field, rowIndex, colIndex, p)!=true){ 
                            if(checkDiagR(field, rowIndex, colIndex, p)!=true){ 
                                checkDiagL(field, rowIndex, colIndex, p);
                            } 
                        } 
                    }
                }
                if(check==4){
                    winnerFound = true;
                    break;
                }
            }
            if(check==4){
                winnerFound = true;
                break;
            }
        }
        return winnerFound;
    }

    private boolean checkDiagR(int[][] field, int rowInd, int colInd, int p) { 
        countWin = 1; 
        
        while(countWin>0 && countWin<4){  
            rowInd--; 
            colInd++; 
       
            if(rowInd<0||rowInd>5||colInd<0||colInd>6){ 
                // wirft Fehlermeldung (IndexOutOfBound) evtl. in einem Popup? 
                countWin=0; 
            } else 
            if(field[rowInd][colInd]==p){    //check if next is same marker 
                countWin++; 
            } else { 
                countWin=0; 
            }  
        } 
        
        if(countWin==4){        
            check=4; 
            countWin=0;            
            return true;         
        } else {        
            check=1; 
            countWin=0;         
            return false;        
        } 
    } 
        
    private boolean checkDiagL(int[][] field, int rowInd, int colInd, int p) { 
        countWin = 1; 
        
        while(countWin>0 && countWin<4){ 
            rowInd--; 
            colInd--; 
        
            if(rowInd<0||rowInd>5||colInd<0||colInd>6){ 
                // wirft Fehlermeldung (IndexOutOfBound) evtl. in einem Popup? 
                countWin=0;        
            } else         
            if(field[rowInd][colInd]==p){ //check if next is same marker        
                countWin++;       
            } else {        
               countWin=0;  
            } 
        } 
        
        if(countWin==4){        
            check=4; 
            countWin=0;            
            return true;         
        } else {        
            check=1; 
            countWin=0;         
            return false;        
        }
    } 
            
    private boolean checkHori(int[][] field, int rowInd, int colInd, int p) { 
        countWin = 1; 

        while(countWin>0 && countWin<4){ 
            colInd++;        
            if(rowInd<0||rowInd>5||colInd<0||colInd>6){ 
                // wirft Fehlermeldung (IndexOutOfBound) evtl. in einem Popup? 
                countWin=0; 
            } else 
            if(field[rowInd][colInd]==p){ //check if next is same marker 
                countWin++;        
            } else {       
                countWin=0; 
            }        
        } 
        
        if(countWin==4){        
            check=4; 
            countWin=0;            
            return true;         
        } else {        
            check=1; 
            countWin=0;         
            return false;        
        } 
    }  
             
    private boolean checkVert(int[][] field, int rowInd, int colInd, int p) {  
        countWin = 1; 

        while(countWin>0 && countWin<4){    
            rowInd--; 
            if(rowInd<0||rowInd>5||colInd<0||colInd>6){       
                // wirft Fehlermeldung (IndexOutOfBound) evtl. in einem Popup?         
                countWin=0; 
            } else 
            if(field[rowInd][colInd]==p){ //check if next is same marker 
                countWin++; 
            } else { 
                countWin=0; 
            } 
        } 
        
        if(countWin==4){        
            check=4; 
            countWin=0;            
            return true;         
        } else {        
            check=1; 
            countWin=0;         
            return false;        
        }
    }
}
