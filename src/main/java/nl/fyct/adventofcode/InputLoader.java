package nl.fyct.adventofcode;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Component
class InputLoader {

    private static final String REGEX = " {3}";

    private final ArrayList<Integer> seriesOne = new ArrayList<>();
    private final ArrayList<Integer> seriesTwo = new ArrayList<>();

    SeriesDataHolder loadInputFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                splitValuesToSeries(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + path);
        }
        return new SeriesDataHolder(seriesOne, seriesTwo);
    }

    private void splitValuesToSeries(String line) {
        seriesOne.add(Integer.valueOf(line.split(REGEX)[0]));
        seriesTwo.add(Integer.valueOf(line.split(REGEX)[1]));
    }
}
