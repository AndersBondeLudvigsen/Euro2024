import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    private List<MatchResult> matchResultList;

    public Statistics(String fileName) throws FileNotFoundException {
        MatchResultFileReader matchResultFileReader = new MatchResultFileReader();
        matchResultList = matchResultFileReader.readFile();
    }

    public Set<String> getGoalScores() {
        Set<String> goalScorers = new HashSet<>();
        for (MatchResult matchResult : matchResultList) {
            for (String goalscorer : matchResult.getGoalScores()) {
                goalScorers.add(goalscorer);
            }
        }
        return goalScorers;
    }

    public Map<String, Integer> getGoalScorersWithTotals(){
        Map<String, Integer> goalScorersWithTotals = new HashMap<>();

        for (MatchResult matchResult: matchResultList){
            for (String goalscorer : matchResult.getGoalScores()){
                goalScorersWithTotals.put(goalscorer, goalScorersWithTotals.getOrDefault(goalscorer, 0) + 1);
            }
        }return goalScorersWithTotals;

            }
            public int getNumberOfGoals(String goalscorer){
        int totalGoals = 0;
        for (MatchResult matchResult : matchResultList){
            totalGoals += Collections.frequency(matchResult.getGoalScores(), goalscorer);
        }
        return totalGoals;
            }
        }


