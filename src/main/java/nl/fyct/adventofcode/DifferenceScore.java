package nl.fyct.adventofcode;

import org.springframework.stereotype.Component;

@Component
class DifferenceScore {

    private final InputLoader inputLoader;

    DifferenceScore(InputLoader inputLoader) {
        this.inputLoader = inputLoader;
    }

    int getDifferenceScore(String path) {
        SeriesDataHolder seriesDataHolder = inputLoader.loadInputFile(path);
        sortSeries(seriesDataHolder);
        return compareBothListsAndReturnDifference(seriesDataHolder);
    }

    private void sortSeries(SeriesDataHolder series) {
        series.seriesOne().sort(Integer::compareTo);
        series.seriesTwo().sort(Integer::compareTo);
    }

    private int compareBothListsAndReturnDifference(SeriesDataHolder series) {
        int sum = 0;
        for (int i = 0; i < series.seriesOne().size(); i++) {
            sum += Math.abs(series.seriesOne().get(i) - series.seriesTwo().get(i));
        }
        return sum;
    }
}
