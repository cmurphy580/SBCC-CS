package edu.sbcc.cs105;
 
public class Grade {
	private String grade;
	
	public Grade(String grade) {
		this.grade = grade;
	}
	
	public double getNumericGrade() {
		if (grade.equals("A+") || grade.equals("A")) {
			return 4.0;
		} else if (grade.equals("A-")) {
			return 3.7;
		} else if (grade.equals("B+")) {
			return 3.3; 
		} else if (grade.equals("B")) {
			return 3.0;
		} else if (grade.equals("B-")) {
			return 2.7;
		} else if (grade.equals("C+")) {
			return 2.3;
		} else if (grade.equals("C")) {
			return 2.0;
		} else if (grade.equals("C-")) {
			return 1.7;
		} else if (grade.equals("D+")) {
			return 1.3;
		} else if (grade.equals("D")) {
			return 1.0;
		} else if (grade.equals("D-")) {
			return 0.7;
		} else if (grade.equals("F+") || grade.equals("F") || grade.equals("F-")) {
			return 0.0;
		} else {
			return 0.0;
		}
	}

	public String getLetterGrade() {
		return grade;
	}
}