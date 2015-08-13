/**
 * A class representing one team in the NCAA tournament bracket.
 *
 * @author Kyle Vigil
 */
public class Team {
   private int seed, tournyWins;
   private double winPer;
   private String name, region;

   /**
    * One team in the march madness tournament
    * 
    * @param  seed   The seed of the team
    * @param  name   The name of the team
    * @param  winPer The win percentage of that teams season
    * @param  region The region of the team
    */
   public Team(int seed, String name, double winPer, String region){
      this.seed = seed;
      this.winPer = winPer;
      this.name = name;
      this.region = region;
   }

   /**
    * Adds one win to a teams current wins
    */
   public void addWin(){ tournyWins++; }

   /**
    * returns the seed of the team
    * @return int seed
    */
   public int getSeed(){ return seed; }

   /**
    * returns the win percentage of the team
    * @return double win percentage
    */
   public double getWinPer(){ return winPer; }

   /**
    * returns the name of the team
    * @return String team name
    */
   public String getName(){ return name; }

   /**
    * returns the number of times the team has been simulated to win the tournament
    * @return int tournment wins
    */
   public int getWins(){ return tournyWins; }

   /**
    * returns the region of the team
    * @return String region
    */
   public String getRegion(){ return region; }

   /**
    * equals method that only compares the name
    * @param  o object to compare
    * @return boolean if the object is equal or not
    */
   public boolean equals(Object o){
      if (o == null)
         return false;

      if (!this.getClass().equals(o.getClass()))
         return false;

      Team t = (Team)o;

      return name.equals(t.name);
   }
}