package decoupe;

import helpers.TimingExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TimingExtension.class)
class DecoupeTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testCasDeBase() {
        int expected = 1;
        int actual = Decoupe.decoupeTige(1);
        assertEquals(expected, actual);
    }

    @Test
    void testCasSlides() {
        int expected = 10;
        int actual = Decoupe.decoupeTige(4);
        assertEquals(expected, actual);
    }

    @Test
    void testCas2() {
        int expected = 5;
        int actual = Decoupe.decoupeTige(2);
        assertEquals(expected, actual);
    }

    @Test
    void testCas3() {
        int expected = 8;
        int actual = Decoupe.decoupeTige(3);
        assertEquals(expected, actual);
    }

    @Test
    void testCas5() {
        int expected = 13;
        int actual = Decoupe.decoupeTige(5);
        assertEquals(expected, actual);
    }

    @Test
    void testCas6() {
        int expected = 17;
        int actual = Decoupe.decoupeTige(6  );
        assertEquals(expected, actual);
    }

    @Test
    void testCas7() {
        int expected = 18;
        int actual = Decoupe.decoupeTige(7);
        assertEquals(expected, actual);
    }

    @Test
    void testCas12() {
        int expected = 35;
        int actual = Decoupe.decoupeTige(12);
        assertEquals(expected, actual);
    }

    @Test
    void testCasCent() {
        int expected = 300;
        int actual = Decoupe.decoupeTige(100);
        assertEquals(expected, actual);
    }

    @Test
    void testCasCinqCent() {
        int expected = 1500;
        int actual = Decoupe.decoupeTige(500);
        assertEquals(expected, actual);
    }

    @Test
    void testCasMille() {
        int expected = 3000;
        int actual = Decoupe.decoupeTige(1000);
        assertEquals(expected, actual);
    }
}