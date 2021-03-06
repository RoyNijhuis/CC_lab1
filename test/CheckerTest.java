package test;

import static dfa.State.DFA_LALA;
import static dfa.State.ID6_DFA;

import dfa.MyChecker;
import org.junit.Assert;
import org.junit.Test;

import dfa.Checker;
import dfa.State;

/** Test class for Checker implementation. */
public class CheckerTest {
	private Checker myChecker = new MyChecker();// instantiate your Checker implementation

	private State dfa;

	@Test
	public void testID6() {
		this.dfa = ID6_DFA;
		accepts("a12345");
		rejects("");
		rejects("a12 45");
		rejects("a12 456");
		rejects("a123456");
		rejects("123456");
	}

	@Test
	public void testLaLa() {
		this.dfa = DFA_LALA;
		accepts("La");
		accepts("La La");
		accepts("La La  Laaaaaa    Li");
		rejects("La Li");
		rejects("aL");
	}


	private void accepts(String word) {
		if (!this.myChecker.accepts(this.dfa, word)) {
			Assert.fail(String.format(
					"Word '%s' is erroneously rejected by %s", word, this.dfa));
		}
	}

	private void rejects(String word) {
		if (this.myChecker.accepts(this.dfa, word)) {
			Assert.fail(String.format(
					"Word '%s' is erroneously accepted by %s", word, this.dfa));
		}
	}
}
