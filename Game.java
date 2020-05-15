//Jeffrey Carino

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Game{

    public static void main(String[] args){
	int Player = 0;
	int num1;
	int num2;
	int numberOfGames = 0;
	int P1Wins = 0;
	int P2Wins = 0;
	int P1PairsFound = 0;
	int P2PairsFound = 0;
	int numberGuesses = 0;
	int totalGuesses = 0;

	numberOfGames = (int)(Math.random()*40);

	try{
	    PrintWriter output = new PrintWriter(new FileOutputStream("Results.txt"));
	    output.println("numberGames");
	    output.println(numberOfGames);

	    for(int i = 0; i < numberOfGames; i++){
		Deck deck = new Deck();
		int currNum = (int)(Math.random()*deck.size());

		while(deck.isEmpty() == false){
		    if(Player == 0){
			num1 = (int)(Math.random()*deck.size());
			num2 = (int)(Math.random()*deck.size());
			
			if(num1 == num2){
			    num2 = (int)(Math.random()*deck.size());
			}
			
			do{
			    num1 = (int)(Math.random()*deck.size());
			    num2 = (int)(Math.random()*deck.size());
			    
			}while(deck.FoundAlready(num1,num2));
			
			deck.RemoveCard(num1,num2);
			
			numberGuesses++;
			totalGuesses++;

			if(deck.Check() == true){
			    P1PairsFound++;
			    Player = 0;
			}else{
			    Player = 1;
			}
			
			deck.print();
			System.out.println();

		    }
		    else{
			do{
			    currNum = (int)(Math.random()*deck.size());
			}while(deck.Found(currNum));
			num2 = (int)(Math.random()*deck.size());
			
			if(currNum == num2){
			    num2 = (int)(Math.random()*deck.size());
			}
			
			do{
			    currNum = (int)(Math.random()*deck.size());
			    num2 = (int)(Math.random()*deck.size());
			    
			}while(deck.FoundAlready(currNum,num2));
			
			deck.RemoveCard(currNum,num2);
			
			numberGuesses++;
			totalGuesses++;

			if(deck.Check() == true){
			    P2PairsFound++;
			    Player = 1;
			}else{
			    Player = 0;
			}
			
			deck.print();
			System.out.println();
						
		    }
		}
		if(P1PairsFound > P2PairsFound){
		    P1Wins++;
		}else{
		    P2Wins++;
		}
		output.println("Game");
		output.println(numberGuesses);
		
		numberGuesses = 0;
	    }
	    output.println("Pairs");
	    output.println(P1PairsFound);
	    output.println(P2PairsFound);
	    output.println("Wins");
	    output.println(P1Wins);
	    output.println(P2Wins);
	    output.println("TotalGuesses");
	    output.println(totalGuesses);
	    
	    output.close();
	}catch(Exception ex){
	    System.out.println("Error");
	}
    }    
}