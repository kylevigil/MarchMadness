/**
 * A class to model a single game.
 *
 * @author Kyle Vigil
 */
public class Game {
   private Team teamA, teamB;

   /**
    * A simulation of a single game
    * @param  teamA the first team in the game
    * @param  teamB the second team in the game
    */
   public Game(Team teamA, Team teamB) {
      this.teamA = teamA;
      this.teamB = teamB;
   }

   /**
    * returns the team that wins based off both of the teams win percentage and a random number generator to account for the random nature of sports.
    * @return winning team
    */
   public Team playGame() {
      double winPercentA = teamA.getWinPer();
      double winPercentB = teamB.getWinPer();
      double aVersesB = (winPercentA*(1-winPercentB))/(winPercentA*(1-winPercentB) + winPercentB*(1-winPercentA));
      if(aVersesB >= (double)(Math.random()*1.0)) {
         return teamA;
      }
      return teamB;
   }
}