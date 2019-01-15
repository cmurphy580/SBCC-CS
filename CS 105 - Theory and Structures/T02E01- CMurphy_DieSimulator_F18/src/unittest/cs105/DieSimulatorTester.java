package unittest.cs105;

import static java.lang.System.out;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.sbcc.cs105.DieSimulator;

public class DieSimulatorTester {
	private static final int maximumScore = 6;
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
	public void dontRollAZero() throws Exception {
		DieSimulator ds = new DieSimulator();

		for (int i = 0; i < 100; i++) {
			assertFalse("A die goes from 1 to 6. It should never be zero.",
					ds.rollTheDie() == 0);
		}
		totalScore += 2;
	}

	@Test
	public void rollASix() throws Exception {
		DieSimulator ds = new DieSimulator();

		boolean rolledASix = false;

		for (int i = 0; i < 100; i++) {
			if (ds.rollTheDie() == 6) {
				rolledASix = true;
			}
		}
		assertTrue("Die must be able to roll a six.", rolledASix);
		totalScore += 2;
	}

	@Test
	public void rollInRange() throws Exception {
		DieSimulator ds = new DieSimulator();

		List<Integer> dieRolls = Arrays.asList(0, 0, 0, 0, 0, 0, 0);

		for (int i = 0; i < 500; i++) {
			int aRoll = ds.rollTheDie();

			if (aRoll < 0 || aRoll > 6) {
				fail("Die roll is out of range. It must be from 1 to 6 inclusive.");
			}

			dieRolls.set(aRoll, dieRolls.get(aRoll) + 1);
		}

		assertTrue("Die must return a number between 1 and 6 inclusive",
				dieRolls.get(0) == 0);

		for (int j = 1; j < 7; j++) {
			assertTrue("Die must return a number between 1 and 6 inclusive",
					dieRolls.get(j) > 0);
		}
		totalScore += 2;
	}
}
