package unittest.cs105;

import static org.junit.Assert.assertEquals;
import static java.lang.System.out;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.sbcc.cs105.Multiply;

/**
 * CS 105 Theory and Practice I Assignment Tested: Multiply
 *
 * @author Dean Nevins
 */
public class MultiplyTester {
	private static final int maximumScore = 6;
	private static final int maximumAssignmentScore = 8;
	private static int totalScore;

	@BeforeClass
	public static void beforeTesting() {
		totalScore = 0;
	}

	@AfterClass
	public static void afterTesting() {
		out.printf("Your program's functioning scores %d out of %d.\n\n",
				totalScore, maximumScore);

		int difference = maximumAssignmentScore - maximumScore;
		String correctedPoint = (difference == 1) ? "point" : "points";

		out.printf(
				"The assignment is worth a total of %d where the remainder of %d %s\n",
				maximumAssignmentScore, difference, correctedPoint);
		out.println("comes from grading related to documentation, algorithms, and other");
		out.println("criteria.");
	}

	@Test
	public void testTimesSix() throws Exception {
		Multiply multiply = new Multiply();

		assertEquals("Answer should be 6.", 6, multiply.byTwo(3));
		totalScore += 6;
	}
}
