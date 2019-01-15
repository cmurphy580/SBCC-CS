package unittest.cs105;

import static java.lang.System.*;
import static org.junit.Assert.*;

import org.junit.*;

import edu.sbcc.cs105.*;

public class TemperatureStatsTester {
	private static final int maximumScore = 8;
	private static final int maximumAssignmentScore = 12;
	private static int totalScore;

	private TemperatureStats ts;

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

	@Before
	public void setUp() {
		this.ts = new TemperatureStats();
		ts.addTemperature(0);
		ts.addTemperature(100);
		ts.addTemperature(73);
		ts.addTemperature(90);
		ts.addTemperature(120);
		ts.addTemperature(32);
		ts.addTemperature(45);
		ts.addTemperature(80);
	}

	@After
	public void tearDown() {
		this.ts = null;
	}

	@Test
	public void testMaximum() {
		assertEquals("Maximum not correct.", 120.0, ts.getMaximumTemperature(),
				0.1);
		totalScore += 1;
	}

	@Test
	public void testMinimum() {
		assertEquals("Minimum not correct.", 0.0, ts.getMinimumTemperature(),
				0.1);
		totalScore += 2;
	}

	@Test
	public void testAverage() {
		assertEquals("Average not correct.", 67.5, ts.getAverageTemperature(),
				0.1);
		totalScore += 2;
	}

	@Test
	public void testClear() {
		assertEquals("Maximum not correct.", 120.0, ts.getMaximumTemperature(),
				0.1);
		assertEquals("Minimum not correct.", 0.0, ts.getMinimumTemperature(),
				0.1);
		assertEquals("Average not correct.", 67.5, ts.getAverageTemperature(),
				0.1);

		ts.clearTemperatures();

		ts.addTemperature(10);
		ts.addTemperature(110);
		ts.addTemperature(60);

		assertEquals("Maximum not correct.", 110.0, ts.getMaximumTemperature(),
				0.1);
		assertEquals("Minimum not correct.", 10.0, ts.getMinimumTemperature(),
				0.1);
		assertEquals("Average not correct.", 60.0, ts.getAverageTemperature(),
				0.1);

		totalScore += 3;
	}
}
