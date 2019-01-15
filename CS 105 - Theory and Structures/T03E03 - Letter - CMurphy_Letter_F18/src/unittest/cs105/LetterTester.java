package unittest.cs105;

import static java.lang.System.*;
import static org.junit.Assert.*;

import org.junit.*;

import edu.sbcc.cs105.*;

public class LetterTester {
	private static final int maximumScore = 6;
	private static final int maximumAssignmentScore = 8;
	private static int totalScore;

	@BeforeClass
	public static void beforeTesting() {
		totalScore = 0;
	}

	@AfterClass
	public static void afterTesting() {
		out.printf("Your program's functionality scores %d out of %d.\n\n", totalScore, maximumScore);

		int difference = maximumAssignmentScore - maximumScore;
		String correctedPoint = (difference == 1) ? "point" : "points";

		out.printf("The assignment is worth a total of %d where the remainder of %d %s\n", maximumAssignmentScore,
				difference, correctedPoint);
		out.println("comes from grading related to documentation, algorithms, and other");
		out.println("criteria.");
	}

	@Test
	public void checkWithoutBody() throws Exception {
		Letter l = new Letter("Another Person", "Person");

		assertEquals("There must be no text in the body of the letter.",
				"Dear Person:\n\n\nSincerely,\n\nAnother Person", l.getText());

		totalScore += 3;
	}

	@Test
	public void checkWithBody() throws Exception {
		Letter l = new Letter("Another Person", "Person");
		l.addLine("The quick brown fox.");
		l.addLine("Jumps over the lazy dog.");
		l.addLine("And couldn't be put back together again.");
		assertEquals("There must be no text in the body of the letter.",
				"Dear Person:\n\nThe quick brown fox.\nJumps over the lazy dog.\n"
						+ "And couldn't be put back together again.\n\nSincerely,\n\nAnother Person", l.getText());

		totalScore += 3;
	}
}
