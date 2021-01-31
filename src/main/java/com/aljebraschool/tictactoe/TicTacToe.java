//creating a tictactoe console game
package com.aljebraschool.tictactoe;    //packaged declaration

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
        char[][]gameBoard = {{' ','|',' ','|',' '}, //a 5 x 5 dimensional array
                             {'-','+','-','+','-'},
                             {' ','|',' ','|',' '},
                             {'-','+','-','+','-'},
                             {' ','|',' ','|',' '}};
        
        checkWinner();      //calling method to winner checkWinner
        
       //creating an infinite loop to keep asking for input
        while(true){
            Scanner input = new Scanner(System.in); //declaring the scanner object
            System.out.print("Enter your placement (1-9): ");   //prompt for input between 1-9 
            int playerPos = input.nextInt();                    //read player input and store input in player position
      
       /* check if arrayList playerPosition and cpuPosition contain player input to avoid overwritting on it*/
            while(playerPosition.contains(playerPos) || cpuPosition.contains(playerPos)){
            
                System.out.println("position taken! Enter a correct position"); //return a string telling the user of position taken
                playerPos = input.nextInt();        //read  player input and store input in player position
            }//end while
            placeInput(gameBoard, playerPos, "player"); //after player input then, call the method to place his input
           String winner = checkWinner();               //after placing user input check winner then store it return as a string
           
      //check if "winner" string length is greater than 0     
           if(winner.length() > 0 ){
                System.out.println(winner);     //print user as winner
                printGameBoard(gameBoard);      //print gameBoard again

                break;                          //break out of the while infinite loop

           }//end if
            
            Random rand = new Random();         //randomize the position of the cpu
            int cpuPos = rand.nextInt(9) + 1;   //store random number between 1 and 9 in cpuPos
         
       /* check if arrayList playerPosition and cpuPosition contain cpuPos input to avoid overwritting on it*/
          while(playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)){
            
                cpuPos = rand.nextInt(9) + 1;    //get cpu input and store input in player position   
            }//end while
            
            placeInput(gameBoard,cpuPos, "cpu");    //after cpu input then, call the method to place his input
            
            winner = checkWinner();                 //after placing cpu input check winner then store it return as a string 
           printGameBoard(gameBoard);               //print gameBoard to see output(winner)
           
      //check if "winner" string length is greater than 0     
           if(winner.length() > 0 ){
                    System.out.println(winner);      //print user as winner
                    printGameBoard(gameBoard);       //print gameBoard again to see output(winner)

                    break;                           //break out of the while infinite loop

           }//end if
        
        }//end while
        
        
        
        

    }//end main method
/* Declaration of methods used within this class to implement our program*/
    
    // method that arraged the user and cpu input in a list as arrayList
    private static String checkWinner(){
        
       List<Integer> topRow = Arrays.asList(1,2,3);     //representing elemets in the first row as array viewed as list
       List<Integer> midRow = Arrays.asList(4,5,6);     //representing elemets in the middle row as array viewed as list
       List<Integer> bottomRow = Arrays.asList(7,8,9);  //representing elemets in the bottom row as array viewed as list
       List<Integer> firstCol = Arrays.asList(1,4,7);   //representing elemets in the first column as array viewed as list
       List<Integer> secondCol = Arrays.asList(2,5,8);  //representing elemets in the second column as array viewed as list
       List<Integer> thirdCol = Arrays.asList(3,6,9);   //representing elemets in the third column as array viewed as list
       List<Integer> crossUp = Arrays.asList(1,5,9);    //representing elemets in the first diagonal as array viewe as list
       List<Integer> crossDown = Arrays.asList(7,5,3); //representing elemets in the second diagonal as array viewed as list
       
       List<List> winner = new ArrayList<>();           //creats a list object to add all the possible winning elements above
       winner.add(topRow);                              //adding the elements in the topRow
       winner.add(midRow);                              //adding the elements in the midRow
       winner.add(bottomRow);                           //adding the elements in the bottomRow
       winner.add(firstCol);                            //adding the elements in the firstCol
       winner.add(secondCol);                           //adding the elements in the secondCol
       winner.add(thirdCol);                            //adding the elements in the thirdCol
       winner.add(crossUp);                             //adding the elements in the crossUp
       winner.add(crossDown);                           //adding the elements in the crossDown
       
      
       //loop through the winning list above
       for( List l : winner){
           //check if arraylist player position contains repeated elemets (all) found in 'l'
           if(playerPosition.containsAll(l)){
                return "Congratulations, You Won!";     //return message to user
          
           }//end if
           
           //check if arrayList cpuPosition  contains repeated elemets (all) found in 'l'
            else if(cpuPosition.containsAll(l)){
                      return "CPU wins! Sorry :( ";     //return message to user

           }//else if
            
         //check if playerposition length and cpuPosition length is equal to total lenth of the gameBoard (draw)
          else if(playerPosition.size() + cpuPosition.size() == 9){
                      return "CAT!";        //return message to the user
     
           }//end else if

       }//end for loop
               
        return "";   //return null;
       
  }//end checkWinner method
      
 //method to print gameBoard
    private static void printGameBoard(char[][] gameBoard){
        //looping through the first row
          for(int row = 0; row < gameBoard.length; row++)
        {
            for(int col = 0; col < gameBoard[row].length; col++) //looping though the first column in the first row
            {
              
               System.out.print(gameBoard[row][col]);   //print elements in each column of the first row
               
            }//end inner for loop
                       System.out.println();    //print new line to separate each row 

                
        }//end outer for loop
    }//end method printGameBoard
    
    
//method to place user and cpu input on the gameBoard    
    private static void placeInput(char[][] gameBoard, int pos, String user){
        
        char symbol = ' ';      //initialize empty character
        
        //check if string 'user' is equal to player
        if( user.equals("player")){ 
            symbol = 'X';   //assign new value to symbol variable
            
            playerPosition.add(pos);    //store player position in the arrayList playerPosition
        }//end if
    
                //check if string 'user' is equal to cpu
        else if(user.equals("cpu")){
            symbol = '0';   //assign new value to symbol variable
            cpuPosition.add(pos);   //store cpu position in the arrayList cpuPos
        }//end if
       
//using switch case to consider digit 1- 9 input by the user and the cpu then store the symbol in the gameBoard array accordingly
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
        }//end switch
       

    }//end method placeInput
    
    
}//end class TicTacToe

