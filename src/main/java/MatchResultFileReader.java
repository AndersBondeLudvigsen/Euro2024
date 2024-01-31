import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MatchResultFileReader {
    private File euroFileList = new File("Euro2024QualifyingRound (2).csv");


    public List<MatchResult> readFile() throws FileNotFoundException {
        List<MatchResult> matchResultList = new ArrayList<>();
        String matchResult;
        Scanner scanner = new Scanner(this.euroFileList);
        while (scanner.hasNext()) {
            matchResult = scanner.nextLine();
            matchResultList.add(parseLine(matchResult));
        }
        return matchResultList;
    }

    private MatchResult parseLine (String line){
        String[] tokens = line.split(";");
        String teams = tokens[0].trim();
        List<String> goaslScores = new ArrayList<>();
        if (tokens.length == 2){
            goaslScores = Arrays.asList(tokens[1].trim().split(","));
        }
        return new MatchResult(teams, goaslScores);
    }
}

