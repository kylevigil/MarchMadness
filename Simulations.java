import java.util.*;
import java.io.*;

/**
 * This simulates a bracket and winner for the 2013 NCAA March Madness tournament.
 * 
 * @author Kyle Vigil
 */
public class Simulations {
   
   /**
    * Runs the simulation
    * @param  args              
    * @throws FileNotFoundException 
    */
   public static void main(String[] args) throws FileNotFoundException {
      Team[] tournamentTeams = ReadNCAA.readTeams();
      Scanner s = new Scanner(System.in);
      ArrayList<Team> winners = new ArrayList<Team>();
      int runs;
      String listResults;
      
      //Queries the user for simulations and if they want the results printed
      System.out.println("How many tournament simulations would you like to run? ");
      runs = s.nextInt();
      System.out.println("Would you like to print every result? (y/n) ");
      listResults = s.next();

      //Runs the simulations the specified number of times
      for (int i=0; i<runs; i++){
         Bracket ncaa2013 = new Bracket(tournamentTeams);
         Team winner = ncaa2013.getWinner();

         if(!winners.contains(winner)){
            winners.add(winner);
         }

         //if the user wants each result printed then print results
         if(listResults.equals("y"))
            System.out.println("The winner of simulation " + (i+1) + " is: " + winner.getName());
      }
      System.out.println();

      //Sorts the winners by number of wins
      Collections.sort(winners,new SortWins());
      
      //Prints to the screen the number of wins of each team and their tournament win percentage.
      System.out.println("Number of wins for each team (if not listed then 0): ");
      for (Team t : winners){
         int wins = t.getWins();
         double winPercent = ((double)wins/runs);
         System.out.println(t.getName() + " wins: " + wins + ", Win percentage: " + (double)Math.round(winPercent * 10000)/100 + "%." );
      }
   }
}