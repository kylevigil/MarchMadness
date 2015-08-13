/**
 * A class to model a bracket. Contains 4 regions as well as two finalists and a champion.
 *
 * @author Kyle Vigil
 */
public class Bracket {
   private Region midWest, west, south, east;
   private Team finalist1, finalist2, winner;

   /**
    * Constructor of the bracket
    * @param  teams All of the teams in the tournament
    */
   public Bracket(Team[] teams){
      midWest = setBracket(teams,"Midwest");
      west = setBracket(teams,"West");
      south = setBracket(teams,"South");
      east = setBracket(teams,"East");

      final4();
      championship();
   }

   /**
    * Organizes the list of teams into each bracket
    * @param  teams All of the teams in the tournament
    * @param  name  String name of the region
    * @return       Region of whatever type is specified by the name
    */
   private Region setBracket(Team[] teams, String name){
      Team[] bracketTeams = new Team[16];
      int i = 0;

      for (Team t : teams){
         if(t.getRegion().equals(name)){
            bracketTeams[i] = t;
            i++;
         }
      }
      return new Region(bracketTeams,name);
   }

   /**
    * Simulates the final four
    */
   private void final4(){
      Game mwVerseW = new Game(midWest.winner(),west.winner());
      Game sVerseE = new Game(south.winner(),east.winner());
      finalist1 = mwVerseW.playGame();
      finalist2 = sVerseE.playGame(); 
   }

   /**
    * Simulates the championship
    */
   private void championship(){
      Game finals = new Game(finalist1,finalist2);
      winner = finals.playGame();
      winner.addWin();
   }

   /**
    * Returns the winner of the tournament
    * @return winner of the tournament
    */
   public Team getWinner(){ return winner; }
}