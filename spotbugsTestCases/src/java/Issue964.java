import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class Issue964 {

   final class VoteEntry {
      public String ballotId;
      public String owner;
      public String[][] choiceOrdering;
   }

   public void doWithVoteEntry(VoteEntry vote) {
      Collection<String> voteChoices = new ArrayList<>();
      for (String[] choices : vote.choiceOrdering) {
         voteChoices.addAll(Arrays.asList(choices));
         if (!voteChoices.containsAll(Arrays.asList(choices))) {
            throw new RuntimeException("Vote contains choices that are not present in the ballot");
         }
      }
   }
}
