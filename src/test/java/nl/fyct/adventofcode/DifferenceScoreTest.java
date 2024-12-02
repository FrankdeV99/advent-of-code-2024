package nl.fyct.adventofcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DifferenceScoreTest {

    private static final String inputFilePath = "src/main/resources/input.txt";
    private static final String inputFilePathExample = "src/main/resources/example.txt";

    private DifferenceScore differenceScore;

    @BeforeEach
    void setup() {
        this.differenceScore = new DifferenceScore(new InputLoader());
    }

    @Test
    void readFile() {
        var map = differenceScore.getDifferenceScore(inputFilePath);
        System.out.println(map);
    }

    @Test
    void readExampleFile() {
        var totalDistance = differenceScore.getDifferenceScore(inputFilePathExample);

        assertThat(totalDistance).isEqualTo(11);
    }

}