package task2;

import com.denis.korolev.task2.InsertionSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    @Test
    @DisplayName("Check sorting positive values")
    void checkSorting() {
        InsertionSort insertionSort = new InsertionSort();
        assertAll(
                () -> assertArrayEquals(new int[]{3, 4, 5, 33}, insertionSort.sort(new int[]{33, 3, 4, 5})),
                () -> assertArrayEquals(new int[]{1,3,4,7,9}, insertionSort.sort(new int[]{4,1,3,9,7})),
                () -> assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10}, insertionSort.sort(new int[]{10,9,8,7,6,5,4,3,2,1})),
                () -> assertArrayEquals(new int[]{22, 28, 30, 82, 159, 166, 166, 287, 289, 338, 365, 371, 444, 451, 520, 527, 567, 623, 676, 714, 719, 741, 771, 783, 818, 874, 884, 914, 960, 970, 983},
                        insertionSort.sort(new int[]{444, 520, 166, 874, 676, 22, 338, 783, 365, 970, 623, 30, 287, 451, 914, 371, 741, 818, 527, 714, 166, 159, 960, 289, 567, 82, 771, 983, 719, 884, 28}))
        );
    }

    @Test
    @DisplayName("Check equal values")
    void checkZeros() {
        InsertionSort insertionSort = new InsertionSort();
        assertArrayEquals(new int[]{3,3,3,3,3}, insertionSort.sort(new int[]{3,3,3,3,3}));
    }

    @Test
    @DisplayName("Sort empty array")
    void checkEmpty() {
        InsertionSort insertionSort = new InsertionSort();
        assertArrayEquals(new int[]{}, insertionSort.sort(new int[]{}));
    }

    @Test
    @DisplayName("Check negative values")
    void checkNegativeValues() {
        InsertionSort insertionSort = new InsertionSort();
        assertArrayEquals(new int[]{-5, -4, -3, -2, -1}, insertionSort.sort(new int[]{-5, -1, -4, -3, -2}));
    }

    @Test
    @DisplayName("Check sorting array with null pointer")
    void checkNull() {
        InsertionSort insertionSort = new InsertionSort();
        assertThrows(NullPointerException.class, () -> insertionSort.sort(null));
    }

}
