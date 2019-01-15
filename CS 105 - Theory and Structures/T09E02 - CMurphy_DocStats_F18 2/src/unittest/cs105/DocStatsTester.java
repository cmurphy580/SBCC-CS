package unittest.cs105;

import static java.lang.System.*;
import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

import edu.sbcc.cs105.*;

public class DocStatsTester {
	private static final int maximumScore = 8;
	private static final int maximumAssignmentScore = 10;
	private static int totalScore;

	@BeforeClass
	public static void beforeTesting() throws IOException {
		totalScore = 0;

		PrintWriter out = new PrintWriter("seuss.txt");
		out.println("One fish");
		out.println("Two fish");
		out.println("Red fish");
		out.println("Blue fish");
		out.close();
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
	public void testGoblin() {
		try {
			DocStats ds = new DocStats("goblin.txt");
			totalScore += 1;

			assertEquals("Number of characters is incorrect.", 1450,
					ds.getNumberOfCharacters());
			totalScore += 1;

			assertEquals("Number of words is incorrect.", 257,
					ds.getNumberOfWords());
			totalScore += 1;

			assertEquals("Number of lines is incorrect.", 49,
					ds.getNumberOfLines());
			totalScore += 1;
		} catch (FileNotFoundException e) {
			fail("The file \"goblin.txt\" is not present in your project.");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSeuss() {
		try {
			DocStats ds = new DocStats("seuss.txt");
			totalScore += 1;

			assertEquals("Number of characters is incorrect.", 37,
					ds.getNumberOfCharacters());
			totalScore += 1;

			assertEquals("Number of words is incorrect.", 8,
					ds.getNumberOfWords());
			totalScore += 1;

			assertEquals("Number of lines is incorrect.", 4,
					ds.getNumberOfLines());
			totalScore += 1;
		} catch (FileNotFoundException e) {
			fail("The file \"goblin.txt\" is not present in your project.");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
