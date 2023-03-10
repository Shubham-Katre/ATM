import java.io.*;
import java.util.*;

public class TicTacToe {
    //     Two arraylist to store the used key by player and cpu.
    
    static ArrayList<Integer>playerPos=new ArrayList<>();
      static ArrayList<Integer>cpuPos=new ArrayList<>();
    

    public static void main(String[] args) {
//         Gameboard making..
        
       char[][] gameBoard= {{' ','|',' ','|',' '},
                            {'-','+','-','+','-'},
                            {' ','|',' ','|',' '},
                            {'-','+','-','+','-'},
                            {' ','|',' ','|',' '}};
                            
                           
                            
                      
     
        
        while(true){
            System.out.println("Enter the number");
//              Input by the user..
            Scanner sc=new Scanner(System.in);
        int playerMove =sc.nextInt();
        
//             this while loop to avoid replacement ...
            while(playerPos.contains(playerMove) || cpuPos.contains(playerMove)){
                System.out.println("Enter another number");
                playerMove =sc.nextInt();
            }
            index(gameBoard,playerMove,"player");
         
            
           String result= winning();
            if (result.length()>0){
                System.out.println(result);
                break;
            }
            
        Random rand=new Random();
        int cpuMove=rand.nextInt(9)+1;
       
            while(playerPos.contains(cpuMove) || cpuPos.contains(cpuMove)){
                // System.out.println("Enter another number");
                cpuMove =rand.nextInt(9)+1;
            }
             index(gameBoard,cpuMove,"cpu");
        
          printBoard(gameBoard); 
            
           result= winning();
            if (result.length()>0){
                System.out.println(result);
                break;
            }
            
        }
                           
    }
    public static void printBoard(char[][] gameBoard){
         for(int i=0; i<gameBoard.length; i++) {
         for(int j=0; j<gameBoard[0].length; j++) {
        System.out.print(gameBoard[i][j]);
        }
        System.out.println();
        }
    }
    
    public static void index(char[][] gameBoard, int pos,String user){
        char symbol='O';
        if(user.equals("player")){
            symbol='X';
            playerPos.add(pos);
            System.out.println("playerPos"+playerPos);
        }
        
        
        else if(user.equals("cpu")){
            symbol='O';
            cpuPos.add(pos);
            System.out.println("cpuPos"+cpuPos);
        }
        switch(pos){
            case 1:
            gameBoard[0][0]=symbol;
            break;
             case 2:
            gameBoard[0][2]=symbol;
            break; 
             case 3:
            gameBoard[0][4]=symbol;
            break;
             case 4:
            gameBoard[2][0]=symbol;
             break;
             case 5:
            gameBoard[2][2]=symbol;
             break;
             case 6:
            gameBoard[2][4]=symbol;
             break;
             case 7:
            gameBoard[4][0]=symbol;
             break;
             case 8:
            gameBoard[4][2]=symbol;
             break;
             case 9:
            gameBoard[4][4]=symbol;
             break;
                
            default:
            System.out.println(":(");

        }
    }
    public static String winning(){
       List row1=Arrays.asList(1,2,3);
         List row2=Arrays.asList(4,5,6);
         List row3=Arrays.asList(7,8,9);
         List col1=Arrays.asList(1,4,7);
         List col2=Arrays.asList(2,5,8);
         List col3=Arrays.asList(3,6,9);
         List dia1=Arrays.asList(1,5,9);
         List dia2=Arrays.asList(3,5,7);
        
        ArrayList<List>winner=new ArrayList<>();
        winner.add(row1);
        winner.add(row2);
        winner.add(row3);
        winner.add(col1);
        winner.add(col2);
        winner.add(col3);
        winner.add(dia1);
        winner.add(dia2);
        
        for (List val:winner){
            if (playerPos.containsAll(val)){
                return "Congratulation You Win The Game..";
            }
            else if(cpuPos.containsAll(val)){
                return "Sorry ! You Lost the Game..";
            }
            
        }
        if ((playerPos.size()+cpuPos.size())==9){
                    return "Draw :)";
                }
        return "";
    }

}
