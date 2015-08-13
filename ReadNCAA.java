import java.util.*;
import java.io.*;

/**
 * A class to read the data out of the csv file and put it into a list of teams.
 *
 * @author Kyle Vigil
 */
public class ReadNCAA {
   /**
    * Reads the teams out of the data.csv file and puts them into an array of teams
    * @return the array of teams length 64
    * @throws FileNotFoundException due to reading file
    */
   public static Team[] readTeams() throws FileNotFoundException {
      Scanner reader = new Scanner(new File("data.csv"));
      Team[] teams = new Team[64];
      int i=0;
      String[] values;

      while (reader.hasNextLine() && i<64){
         values = (reader.nextLine()).split(",");
         teams[i] = new Team(Integer.valueOf(values[1]),values[2],Double.parseDouble(values[3]),values[4]);
         i++;
      }
      return teams;
   }
}