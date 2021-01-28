//creating a tictactoe console game
package com.aljebraschool.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
private static List<Integer> playerPosition = new ArrayList<>();
private static List<Integer> cpuPosition = new ArrayList<>();
   
    
    public static void main(String[] args) {
        char[][]gameBoard = {{' ','|',' ','|',' '},
                             {'-','+','-','+','-'},
                             {' ','|',' ','|',' '},
                             {'-','+','-','+','-'},
                             {' ','|',' ','|',' '}};
        
        checkWinner();
        
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your placement (1-9): ");
            int playerPos = input.nextInt();
            
            while(playerPosition.contains(playerPos) || cpuPosition.contains(playerPos)){
            
                System.out.println("position taken! Enter a correct position");
                playerPos = input.nextInt();
            }
            placeInput(gameBoard, playerPos, "player");
           String winner = checkWinner();
           if(winner.length() > 0 ){
           System.out.println(winner);
           printGameBoard(gameBoard); 

           break;
           
           }
            
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
             while(playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)){
            
                cpuPos = rand.nextInt(9) + 1;
            }
            
            placeInput(gameBoard,cpuPos, "cpu");
            
           printGameBoard(gameBoard); 
           
           winner = checkWinner();
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
