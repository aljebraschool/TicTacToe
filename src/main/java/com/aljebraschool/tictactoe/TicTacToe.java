//creating a tictactoe console game
package com.aljebraschool.tictactoe;

//importing the needed libraries used in this project
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
       //create two arraylist object to keep track of the playerPosition and cpuPosition in the game using list collection
private static List<Integer> playerPosition = new ArrayList<>();
private static List<Integer> cpuPosition = new ArrayList<>();
   
     //declaring the main method method  
    public static void main(String[] args) {
             //creating the game structure(game board) using a 2-D array 
        char[][]gameBoard = {{' ','|',' ','|',' '},
                             {'-','+','-','+','-'},
                             {' ','|',' ','|',' '},
                             {'-','+','-','+','-'},
                             {' ','|',' ','|',' '}};
        
        checkWinner(); //calling method to winner checkWinner
       
       //creating an infinite loop to keep asking for input
       while(true){
            Scanner input = new Scanner(System.in); //declaring the scanner object
            System.out.print("Enter your placement (1-9): "); //prompt for input between 1-9
            int playerPos = input.nextInt();   //read player input and store input in player position
          
       /* check if arrayList playerPosition and cpuPosition contain player input to avoid overwritting on it*/
            
            while(playerPosition.contains(playerPos) || cpuPosition.contains(playerPos)){
            
                System.out.println("position taken! Enter a correct position");//return a string telling the user of position taken
                playerPos = input.nextInt();  //read  player input and store input in player position
            }
            placeInput(gameBoard, playerPos, "player"); //after player input then, call the method to place his input
           String winner = checkWinner();  //after placing user input check winner then store it return as a string
          
                //check if "winner" string length is greater than 0     

           if(winner.length() > 0 ){
           System.out.println(winner);//print user as winner
           printGameBoard(gameBoard); //print gameBoard again

           break;//break out of the while infinite loop
           
           }
            
            Random rand = new Random(); //randomize the position of the cpu
            int cpuPos = rand.nextInt(9) + 1;//store random number between 1 and 9 in cpuPos
          
                 /* check if arrayList playerPosition and cpuPosition contain cpuPos input to avoid overwritting on it*/

             while(playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)){
            
                cpuPos = rand.nextInt(9) + 1; //get cpu input and store input in player position
            }
            
            placeInput(gameBoard,cpuPos, "cpu");//after cpu input then, call the method to place his input
            
           printGameBoard(gameBoard); //print gameBoard to see output(winner)
           
           winner = checkWinner();//after placing cpu input check winner then store it return as a string
           if(winner.length() > 0 ){
           System.out.println(winner);
           printGameBoard(gameBoard); 

           break;
           
           }
        
        }
        
        
        
        

    }

    
    private static String checkWinner(){
        
       List<Integer> topRow = Arrays.asList(1,2,3);
       List<Integer> midRow = Arrays.asList(4,5,6);
       List<Integer> bottomRow = Arrays.asList(7,8,9);
       List<Integer> firstCol = Arrays.asList(1,4,7);
       List<Integer> secondCol = Arrays.asList(2,5,8);
       List<Integer> thirdCol = Arrays.asList(3,6,9);
       List<Integer> crossUp = Arrays.asList(1,5,9);
       List<Integer> crossDown = Arrays.asList(7,5,3);
       
       List<List> winner = new ArrayList<>();
       winner.add(topRow);
       winner.add(midRow);
       winner.add(bottomRow);
       winner.add(firstCol);
       winner.add(secondCol);
       winner.add(thirdCol);
       winner.add(crossUp);
       winner.add(crossDown);
       
      
       for( List l : winner){
           if(playerPosition.containsAll(l)){
                return "Congratulations, You Won!";
          
           }else if(cpuPosition.containsAll(l)){
                      return "CPU wins! Sorry :( ";

           }else if(playerPosition.size() + cpuPosition.size() == 9){
                      return "CAT!";
     
           }

       }
               
        return "";   
       
  }
    
    
    
    private static void printGameBoard(char[][] gameBoard){
          for(int row = 0; row < gameBoard.length; row++)
        {
            for(int col = 0; col < gameBoard[row].length; col++)
            {
              
               System.out.print(gameBoard[row][col]);
               
            }
                       System.out.println();

                
        }
    }
    
    
    private static void placeInput(char[][] gameBoard, int pos, String user){
        
        char symbol = ' ';
        if( user.equals("player")){
            symbol = 'X';
            playerPosition.add(pos);
        }else if(user.equals("cpu")){
            symbol = '0';
            cpuPosition.add(pos);
        }
       
       
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                System.out.println("Wrong input, enter digit (1-9) ");
                break;
        }
       

    }
    
    
}
