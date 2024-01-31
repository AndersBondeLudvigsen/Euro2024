import java.util.List;

public class MatchResult {
    private String teams;
    private List <String> goalScores;

    public MatchResult(String teams,List<String> goalScores){
        this.teams = teams;
        this.goalScores = goalScores;
    }

    public List<String> getGoalScores(){
        return goalScores;
    }
}
