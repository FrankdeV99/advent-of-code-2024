package nl.fyct.adventofcode;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
class SimilarityScore {

    private final InputLoader inputLoader;

    SimilarityScore(InputLoader inputLoader) {
        this.inputLoader = inputLoader;
    }

    int getSimilarityScore(String path) {
        SeriesDataHolder seriesDataHolder = inputLoader.loadInputFile(path);
        return seriesDataHolder.seriesOne().stream()
                .map(number -> calculateSimilarityScore(number, seriesDataHolder.seriesTwo()))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int calculateSimilarityScore(int number, List<Integer> series) {
        return number * countNumberOfRepetitionsInSeries(number, series);
    }

    private int countNumberOfRepetitionsInSeries(int number, List<Integer> series) {
        return Collections.frequency(series, number);
    }

}
