package dfa;

import java.util.ArrayList;
import java.util.List;

import static dfa.State.DFA_LALA;
import static dfa.State.ID6_DFA;

/**
 * Created by Roy-Laptop on 20-4-2016.
 */
public class MyScanner implements Scanner {

    @Override
    public List<String> scan(State dfa, String text)
    {
        int previousAccepting = -1;
        State initalState = DFA_LALA;
        boolean error = false;
        List<String> strings = new ArrayList<>();

        while (text.length() > 0)
        {
            System.out.println(text + "\n");
            for (int i=0; i<text.length();i++)
            {
                dfa = dfa.getNext(text.charAt(i));

                if(dfa == null)
                {
                    error = true;
                    break;
                }
                else if (dfa.isAccepting())
                {
                    previousAccepting = i;
                }
            }

            if(error)
            {
                error = false;
                strings.add(text.substring(0, previousAccepting+1));
                text = text.substring(previousAccepting+1, text.length());
                dfa = initalState;
            }
            else if (dfa.isAccepting())
            {
                strings.add(text);
                break;
            }
            else
            {
                break;
            }
        }

        return strings;
    }
}
