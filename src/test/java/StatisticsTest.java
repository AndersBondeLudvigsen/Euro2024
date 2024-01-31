import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.FileNotFoundException;

class StatisticsTest {

    private Statistics statistics;

    @BeforeEach
    void setUp() {
        try {
            statistics = new Statistics("Euro2024QualifyingRound (2).csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getGoalScorers() {
        int expectedResult = 8;
            int actualResult = statistics.getGoalScores().size();
            assertEquals(expectedResult, actualResult);
        }

        @Test
        void getGoalScoresWithTotalsSize(){
        int expectedResult = 8;
        int actualResult = statistics.getGoalScorersWithTotals().size();
        assertEquals(expectedResult,actualResult);
        }

        @Test
        void getTotalGoalsScoresWithTotalsContains(){
        String spiller = "Delaney";
        int expectedValue = 1;
        int actualValue = statistics.getGoalScorersWithTotals().get(spiller);
        assertEquals(expectedValue,actualValue);
        }

        @Test
        void getTotalGoalsScoresWithTotalsDoesNotContain(){
        String spiller = "Ludvigsen";
        Integer actualValue = statistics.getGoalScorersWithTotals().get(spiller);
        assertNull(actualValue);
        }


        @Test
    void getNumberOfGoals(){
        int expectedResult = 7;
        int actualResult = statistics.getNumberOfGoals("Højlund");
        assertEquals(expectedResult,actualResult);
        }

    }

