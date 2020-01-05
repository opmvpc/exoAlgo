package cartons;

import helpers.TimingExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TimingExtension.class)
class DecoupeCartonTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    int testDecoupeCarton(int[][] dessins) {
        return new DecoupeCarton(dessins).prixMinimum();
    }

    @Test
    void testVide() {
        int[][] dessins = new int[][]{};

        int expected = Integer.MAX_VALUE;
        int actual = testDecoupeCarton(dessins);
        assertEquals(expected, actual);
    }

    @Test
    void testCasDeBase() {
        int[][] dessins = new int[][]{
                {1, 1},
        };

        int expected = 1;
        int actual = testDecoupeCarton(dessins);
        assertEquals(expected, actual);
    }

    @Test
    void testCasSlides() {
        int[][] dessins = new int[][]{
            {3, 3},
            {4, 4},
            {7, 2},
            {2, 8},
        };

        int expected = 44;
        int actual = testDecoupeCarton(dessins);
        assertEquals(expected, actual);
    }

    @Test
    void testCasSlides2() {
        int[][] dessins = new int[][]{
            {3, 3},
            {3, 5},
            {4, 4},
            {5, 3},
            {7, 2},
            {2, 8},
        };

        int expected = 51;
        int actual = testDecoupeCarton(dessins);
        assertEquals(expected, actual);
    }

    @Test
    void testCasSlides3() {
        int[][] dessins = new int[][]{
            {3, 3},
            {7, 2},
            {5, 3},
            {3, 5},
            {2, 8},
        };

        int expected = 45;
        int actual = testDecoupeCarton(dessins);
        assertEquals(expected, actual);
    }
}