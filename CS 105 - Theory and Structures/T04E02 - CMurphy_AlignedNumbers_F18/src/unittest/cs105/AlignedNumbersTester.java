package unittest.cs105;

import static java.lang.System.*;
import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

import edu.sbcc.cs105.*;

public class AlignedNumbersTester {
	private static final int maximumScore = 6;
	private static final int maximumAssignmentScore = 10;
	private static int totalScore;

	private PrintStream oldOut;
	private PrintStream stringStream;
	private ByteArrayOutputStream baos;

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

	@Before
	public void setUp() {
		this.baos = new ByteArrayOutputStream();
		this.stringStream = new PrintStream(baos);
		this.oldOut = System.out;
		setOut(this.stringStream);

	}

	@After
	public void tearDown() {
		setOut(this.oldOut);
	}

	@Test
	public void testIndividualStats() throws Exception {
		AlignedNumbers an = new AlignedNumbers();

		an.setFirstNumber(7);
		an.setSecondNumber(4);
		assertEquals("Sum of 4 and 7 should equal 11", 11, an.getSum());
		assertEquals("Difference of 4 and 7 should equal -3", -3, an.getDifference());
		assertEquals("Average of 4 and 7 should equal 5.5", 5.5, an.getAverage(), 0.01);
		assertEquals("Product of 4 and 7 should equal 28", 28, an.getProduct());
		assertEquals("Distance of 4 and 7 should equal 3", 3, an.getDistance());
		assertEquals("Maximum of 4 and 7 should equal 7", 7, an.getMaximum());
		assertEquals("Minimum of 4 and 7 should equal 4", 4, an.getMinimum());

		totalScore += 3;

	}

	@Test
	public void testStatPrintout() throws Exception {
		AlignedNumbers an = new AlignedNumbers();
		an.setFirstNumber(25);
		an.setSecondNumber(20);
		an.printStats();
		System.out.flush();

		StringBuilder answer = new StringBuilder();
		answer.append("Sum:                        45\n");
		answer.append("Average:                    22.50\n");
		answer.append("Difference:                 -5\n");
		answer.append("Product:                   500\n");
		answer.append("Distance:                    5\n");
		answer.append("Maximum:                    25\n");
		answer.append("Minimum:                    20\n");

		assertEquals("The strings need to match.", answer.toString(), this.baos.toString());

		this.baos.reset();

		totalScore += 3;
	}

}
