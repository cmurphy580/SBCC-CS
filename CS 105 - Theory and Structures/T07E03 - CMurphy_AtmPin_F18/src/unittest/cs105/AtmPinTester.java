package unittest.cs105;

import static java.lang.System.*;
import static org.junit.Assert.*;

import org.junit.*;

import edu.sbcc.cs105.*;

public class AtmPinTester {
	private static final int maximumScore = 8;
	private static final int maximumAssignmentScore = 12;
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
	public void testGoodPin() {
		AtmPin ap = new AtmPin();

		assertTrue("Should accept 1234.", ap.acceptPinCode("1234"));

		totalScore += 1;
	}

	@Test
	public void testBadPin() {
		AtmPin ap = new AtmPin();

		assertFalse("Should not accept 1234.", ap.acceptPinCode("1337"));

		totalScore += 1;
	}

	@Test
	public void testTooManyAttempts() {
		AtmPin ap = new AtmPin();

		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered.", ap.isBadPassword());
		assertFalse("Not blocked yet. Not enough attempts.", ap.isBlocked());
		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered..", ap.isBadPassword());
		assertFalse("Not blocked yet. Not enough attempts.", ap.isBlocked());
		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered.", ap.isBadPassword());
		assertFalse("Not blocked yet. Not enough attempts.", ap.isBlocked());
		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered.", ap.isBadPassword());
		assertTrue("Blocked. Too many attempts.", ap.isBlocked());

		totalScore += 2;
	}

	@Test
	public void testTooManyAttemptsFollowedByGoodPassword() {
		AtmPin ap = new AtmPin();

		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered.", ap.isBadPassword());
		assertFalse("Not blocked yet. Not enough attempts.", ap.isBlocked());
		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered..", ap.isBadPassword());
		assertFalse("Not blocked yet. Not enough attempts.", ap.isBlocked());
		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered..", ap.isBadPassword());
		assertFalse("Not blocked yet. Not enough attempts.", ap.isBlocked());
		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered.", ap.isBadPassword());
		assertTrue("Blocked. Too many attempts.", ap.isBlocked());
		assertFalse("Should not accept password because it should be blocked.", ap.acceptPinCode("1234"));
		assertFalse("Good password entered.", ap.isBadPassword());
		assertTrue("Blocked. Too many attempts.", ap.isBlocked());

		totalScore += 2;
	}

	@Test
	public void testResetBlocked() {
		AtmPin ap = new AtmPin();

		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered.", ap.isBadPassword());
		assertFalse("Not blocked yet. Not enough attempts.", ap.isBlocked());
		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered..", ap.isBadPassword());
		assertFalse("Not blocked yet. Not enough attempts.", ap.isBlocked());
		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered.", ap.isBadPassword());
		assertFalse("Not blocked yet. Not enough attempts.", ap.isBlocked());
		assertFalse("Should not accept password.", ap.acceptPinCode("1337"));
		assertTrue("Bad password entered..", ap.isBadPassword());
		assertTrue("Should be blocked.", ap.isBlocked());
		assertFalse("Should not accept password because it should be blocked.", ap.acceptPinCode("1234"));
		assertFalse("Good password entered.", ap.isBadPassword());
		assertTrue("Blocked. Too many attempts.", ap.isBlocked());

		ap.resetPasswordAttempts();
		assertTrue("Should accept password after reset.", ap.acceptPinCode("1234"));
		assertFalse("Good password entered.", ap.isBadPassword());
		assertFalse("Blocked. Too many attempts.", ap.isBlocked());

		totalScore += 2;
	}
}
