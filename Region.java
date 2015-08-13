/**
 * A class to model a region of the bracket
 *
 * @author Kyle Vigil
 */
public class Region {
   private Team[] roundOf64 = new Team[16];
   private Team[] roundOf32 = new Team[8];
   private Team[] roundOf16 = new Team[4];
   private Team[] roundOf8 = new Team[2];
   private Team regionWinner;
   private String regionName;

   /**
    * One region of the bracket
    * @param  teams the teams in the region
    * @param  name  name of the region
    */
   public Region(Team[] teams, String name){
      regionName = name;
      orderTeams(teams);
      playRegion();
   }

   /**
    * Sets up the teams so that they are in order of how the seeds are on the bracket.
    * @param teams unordered list of teams in the bracket
    */
   private void orderTeams(Team[] teams){
      for(Team t : teams){
         switch(t.getSeed()){
            case 1: 
               roundOf64[0] = teams[0];
            break;
            case 2:
               roundOf64[14] = teams[1];
            break;
            case 3:
               roundOf64[10] = teams[2];
            break;
            case 4:
               roundOf64[6] = teams[3];
            break;
            case 5:
               roundOf64[4] = teams[4];
            break;
            case 6:
               roundOf64[8] = teams[5];
            break;
            case 7:
               roundOf64[12] = teams[6];
            break;
            case 8:
               roundOf64[2] = teams[7];
            break;
            case 9:
               roundOf64[3] = teams[8];
            break;
            case 10:
               roundOf64[13] = teams[9];
            break;
            case 11:
               roundOf64[9] = teams[10];
            break;
            case 12:
               roundOf64[5] = teams[11];
            break;
            case 13:
               roundOf64[7] = teams[12];
            break;
            case 14:
               roundOf64[11] = teams[13];
            break;
            case 15:
               roundOf64[15] = teams[14];
            break;
            case 16:
               roundOf64[1] = teams[15];
            break;
         }
      }
   }

   /**
    * Simulates each round of the region.
    */
   public void playRegion(){
      simRoundOf64();
      simRoundOf32();
      simRoundOf16();
      simRoundOf8();
   }

   /**
    * Simulates the round of 64
    */
   public void simRoundOf64(){
      for(int i=0, j=0; i<16; i=i+2, j++){
         Game game = new Game(roundOf64[i], roundOf64[i+1]);
         roundOf32[j] = game.playGame();
      }
   }

   /**
    * Simulates the round of 32
    */
   public void simRoundOf32(){
      for(int i=0, j=0; i<8; i=i+2, j++){
         Game game = new Game(roundOf32[i], roundOf32[i+1]);
         roundOf16[j] = game.playGame();
      }
   }

   /**
    * Simulates the sweet sixteen
    */
   public void simRoundOf16(){
      for(int i=0, j=0; i<4; i=i+2, j++){
         Game game = new Game(roundOf16[i], roundOf16[i+1]);
         roundOf8[j] = game.playGame();
      }
   }

   /**
    * Simulates the elite eight
    */
   public void simRoundOf8(){
      Game game = new Game(roundOf8[0],roundOf8[1]);
      regionWinner = game.playGame();
   }

   /**
    * returns the winner of the region
    * @return Team winner of the region
    */
   public Team winner(){return regionWinner;}
}