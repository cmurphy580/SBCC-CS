package unittest.cs105;

import static java.lang.System.*;
import static org.junit.Assert.*;

import org.junit.*;

import edu.sbcc.cs105.*;

public class GaussianEasterTester {
	private static final int maximumScore = 5;
	private static final int maximumAssignmentScore = 8;
	private static int totalScore;

	@BeforeClass
	public static void beforeTesting() {
		totalScore = 0;
	}

	@AfterClass
	public static void afterTesting() {
		out.printf("Your program's functionality scores %d out of %d.\n\n",
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
	public void check2001() throws Exception {
		GaussianEaster ge = new GaussianEaster(2001);

		assertEquals("The month must be 4.", 4, ge.getN());
		assertEquals("The day must be 15.", 15, ge.getP());

		totalScore += 1;
	}

	@Test
	public void check2005() throws Exception {
		GaussianEaster ge = new GaussianEaster(2005);

		assertEquals("The month must be 3.", 3, ge.getN());
		assertEquals("The day must be 27.", 27, ge.getP());

		totalScore += 1;
	}

	@Test
	public void check2009() throws Exception {
		GaussianEaster ge = new GaussianEaster(2009);

		assertEquals("The month must be 4.", 4, ge.getN());
		assertEquals("The day must be 12.", 12, ge.getP());

		totalScore += 1;
	}

	@Test
	public void check2013() throws Exception {
		GaussianEaster ge = new GaussianEaster(2013);

		assertEquals("The month must be 3.", 3, ge.getN());
		assertEquals("The day must be 31.", 31, ge.getP());

		totalScore += 1;
	}

	@Test
	public void check2014() throws Exception {
		GaussianEaster ge = new GaussianEaster(2014);

		assertEquals("The month must be 4.", 4, ge.getN());
		assertEquals("The day must be 20.", 20, ge.getP());

		totalScore += 1;
	}

}
