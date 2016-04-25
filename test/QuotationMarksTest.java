package test;

import antlr.QuotationMarks;
import org.junit.Test;

/**
 * Created by Roy-Laptop on 25-4-2016.
 */
public class QuotationMarksTest {
    private static LexerTester tester = new LexerTester(QuotationMarks.class);

    @Test
    public void succeedingTest() {
        tester.correct("\"\"\"\"");
        tester.correct("\"\"");
        tester.correct("\"HAL  LO OO \"\"\"");
        tester.wrong("\"\"\"");
        tester.wrong("\"je moeder\"lalalalla\"");
        tester.wrong("\"aaa\" \"aaa\"aaa\"");
    }

    @Test
    public void yieldCountTest() {
        tester.yields("\"bla\"\"   bla2   \"\"\"", QuotationMarks.IDENTIFIER);
    }
}
