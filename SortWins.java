import java.util.*;

/**
 * A comparator that will sort the winners by the amount of wins they have. This orders the final print out list nicely.
 *
 * @author Kyle Vigil
 */
public class SortWins implements Comparator<Team>{

   /**
    * Sort by wins
    * @param  a first team to compare
    * @param  b second team to compare
    * @return   -1 if a is first, 1 if b is first, 0 if logically equivalent.
    */
   public int compare(Team a, Team b){
      if (a.getWins() > b.getWins())
         return -1;
      if (a.getWins() < b.getWins())
         return 1;
      return 0;
   }
}