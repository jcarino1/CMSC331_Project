local file = io.open("Results.txt", "r");
local arr = {}
 for line in file:lines() do
    table.insert (arr, line);
 end

 local numberOfGames
 local Guesses = {}
 local P1Pairs
 local P2Pairs
 local P1Wins
 local P2Wins
 local totalGuesses 
 local AveragePairsP1 = 0.0
 local AveragePairsP2 = 0.0
 local GameMostGuesses 
 local GameLeastGuesses
 local AverageGuesses = 0.0

  for arrCount = 1, table.getn(arr) do
      if(arr[arrCount] == "numberGames") then
    	  numberOfGames = arr[arrCount+1];
	  --print(numberOfGames);
      elseif(arr[arrCount] == "Game") then
  	  table.insert(Guesses, arr[arrCount+1]); 
	  --print(arr[arrCount+1]);
      elseif(arr[arrCount] == "Pairs") then
          P1Pairs = arr[arrCount + 1];
	  P2Pairs = arr[arrCount + 2];
      	  --print(P1Pairs ..  " " ..  P2Pairs);
      elseif(arr[arrCount] == "Wins") then
          P1Wins = arr[arrCount + 1];
	  P2Wins = arr[arrCount + 2];
      	  --print(P1Wins .. " " .. P2Wins);
      elseif(arr[arrCount] == "TotalGuesses") then
          totalGuesses = arr[arrCount + 1];
	  --print(totalGuesses);
      end      
   end

   AveragePairsP1 = (P1Pairs/numberOfGames);
   AveragePairsP2 = (P2Pairs/numberOfGames);
   AverageGuesses = (totalGuesses/numberOfGames);
   
   GameMostGuesses = math.max(unpack(Guesses));
   GameLeastGuesses = math.min(unpack(Guesses));

   print("Total Numbers Of Games Played " .. numberOfGames);
   print("Average Number of Matched Found by Player One: " .. AveragePairsP1);
   print("Average Number of Matched Found by Player Two: " .. AveragePairsP2);   
   print("Game That Took the Most Guesses: " .. GameMostGuesses);
   print("Game That Took the Least Guesses: " .. GameLeastGuesses);
   print("Average number of Guesses Per Game: " .. AverageGuesses);

   if(P1Wins > P2Wins) then 
       print("Player One Won the Most");
   else
       print("Player Two Won the Most");
   end