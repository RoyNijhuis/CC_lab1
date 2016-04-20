package dfa;

/**
 * Created by Roy-Laptop on 20-4-2016.
 */
public class MyChecker implements Checker {
    @Override
    public boolean accepts(State start, String word) {
        for (int i=0; i<word.length();i++)
        {
            start = start.getNext(word.charAt(i));

            if (start == null)
            {
                return false;
            }
        }

        return start.isAccepting();
    }
}
