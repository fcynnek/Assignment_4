package com.fcynnek.assignment4;

public class UserPOJO {
// this class will be used to store user data from the Master List File
	
	private String studentID;
	private String studentName;
	private String courseID;
	private String studentGrade;
	
	
	// getters
	public String getStudentID() {
		return studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getCourseID() {
		return courseID;
	}
	public String getStudentGrade() {
		return studentGrade;
	}
	
	
	// setters
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}
	
	
}
