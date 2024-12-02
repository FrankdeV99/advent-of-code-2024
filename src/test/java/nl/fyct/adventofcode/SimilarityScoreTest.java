package nl.fyct.adventofcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimilarityScoreTest {

    private static final String inputFilePath = "src/main/resources/input.txt";
    private static final String inputFilePathExample = "src/main/resources/example.txt";

    private SimilarityScore similarityScore;

    @BeforeEach
    void setup() {
        similarityScore = new SimilarityScore(new InputLoader());
    }

    @Test
    void getSimilarityScore_withExampleInput() {
        int result = similarityScore.getSimilarityScore(inputFilePathExample);

        assertThat(result).isEqualTo(31);
    }

    @Test
    void getSimilarityScore_withInput() {
        int result = similarityScore.getSimilarityScore(inputFilePath);

        System.out.println(result);
    }

}