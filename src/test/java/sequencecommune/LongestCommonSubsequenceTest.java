package sequencecommune;

import helpers.TimingExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TimingExtension.class)

class LongestCommonSubsequenceTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    int testCommonSubseq(String first, String second) {
        return new LongestCommonSubsequence<>(first.split(""), second.split("")).longestSize();
    }

    @Test
    void testCasDeBase() {
        int expected = 0;
        int actual = new LongestCommonSubsequence<>(new String[]{}, new String[]{}).longestSize();
        assertEquals(expected, actual);
    }

    @Test
    void testCasSlides() {
        int expected = 4;
        int actual = testCommonSubseq("abracadabra", "chandelier");
        assertEquals(expected, actual);
    }

    @Test
    void testCasSlides2() {
        int expected = 4;
        int actual = testCommonSubseq("BDCABA", "ABCBDAB");
        assertEquals(expected, actual);
    }

    @Test
    void testCasQueDesA() {
        int expected = 6;
        int actual = testCommonSubseq("AAAAAA", "AAAAAA");
        assertEquals(expected, actual);
    }

    @Test
    void testCasExtremitesDebut() {
        int expected = 1;
        int actual = testCommonSubseq("AXEZ", "ABNV");
        assertEquals(expected, actual);
    }

    @Test
    void testCasExtremitesFin() {
        int expected = 1;
        int actual = testCommonSubseq("XEZA", "BNVA");
        assertEquals(expected, actual);
    }

    @Test
    void testCasCommun2() {
        int expected = 2;
        int actual = testCommonSubseq("AXEZA", "BANVA");
        assertEquals(expected, actual);
    }

    @Test
    void testCasCommun3() {
        int expected = 3;
        int actual = testCommonSubseq("AXECZA", "BACNVA");
        assertEquals(expected, actual);
    }
}