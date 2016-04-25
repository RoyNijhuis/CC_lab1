package antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

/**
 * Created by Roy-Laptop on 25-4-2016.
 */
public class SixCharUsage {
    public static void main(String[] args) {
        scan("a12345");
        scan("K1234A");
        scan("KAJEyt");
        scan("A123 123");
    }

    public static void scan(String text) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new SixChar(stream);
        for (Token token : lexer.getAllTokens()) {
            System.out.print(token.toString() + " ");
        }
        System.out.println();
    }
}
