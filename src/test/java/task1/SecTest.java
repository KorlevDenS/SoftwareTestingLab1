package task1;

import com.denis.korolev.task1.Sec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecTest {

    @ParameterizedTest(name = "sec({0})")
    @DisplayName("Check PI dots")
    @ValueSource(doubles = {-80, -60, -45, -30, -10, 0, 10, 30, 45, 60, 80})
    void checkPiDots(double param) {
        Sec sec = new Sec(100, 20);
        assertAll(
                () -> assertEquals(1 / Math.cos(degreesToDoubleRadians(param)),
                        sec.calculateSec(param).doubleValue(), 0.0001)
        );
    }

    @ParameterizedTest(name = "sin({0}) = {1}")
    @DisplayName("Check double dots")
    @CsvFileSource(resources = "/values.csv", numLinesToSkip = 1, delimiter = ';')
    void checkCsvDoubleDots(double paramX, double paramY) {
        Sec sec = new Sec(100, 20);
        assertAll(
                () -> assertEquals(sec.calculateSec(paramX).doubleValue(), paramY, 0.0001)
        );
    }

    public static double degreesToDoubleRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

}
