package test;

import antlr.SixChar;
import org.junit.Test;

/**
 * Created by Roy-Laptop on 25-4-2016.
 */
public class SixCharTest {
    private static LexerTester tester = new LexerTester(SixChar.class);

    @Test
    public void succeedingTest() {
        tester.correct("a12345 z71234");
        tester.correct("L12345");
        tester.yields("t51hsj  a65gh2", SixChar.IDENTIFIER,
                SixChar.IDENTIFIER);
        tester.wrong("9kajs1");
        tester.wrong("a123456");
    }

    @Test
    public void spacesInKeywordTest() {
        // spaces in keywords are not in the rules
        tester.wrong("a 1 2 345");
        tester.correct(" a12345");
        tester.wrong("a123 45");
    }

    @Test
    public void yieldCountTest() {
        tester.yields("A12345", SixChar.IDENTIFIER);
        tester.yields("A12345 zuisb1", SixChar.IDENTIFIER, SixChar.IDENTIFIER);
    }

    @Test
    public void noSpacesBetweenKeywordsTest() {
        // the following is perfectly fine, so claiming it's wrong will fail
        tester.yields("z1763A", SixChar.IDENTIFIER);
        tester.yields("z1763Au12345", SixChar.IDENTIFIER, SixChar.IDENTIFIER);
    }
}
