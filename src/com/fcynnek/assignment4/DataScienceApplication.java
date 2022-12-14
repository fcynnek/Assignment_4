package com.fcynnek.assignment4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DataScienceApplication {

	public static void main(String[] args) throws IOException {

		String fileName = "master.csv";

		FileService fileService = new FileService();
		UserPOJO userPOJOs = new UserPOJO();

		UserPOJO[] studentData = fileService.readStudentData(fileName);

		UserPOJO[] sortedStudentsByGrade = sortStudentsByGrade(studentData);
		// same thing as studentData but assigning it a different name
		// TODO look up references in Java

		UserPOJO[] compSciStudentData = findStudentsByClass(sortedStudentsByGrade, "COMPSCI");
		
		for (UserPOJO compSciStudentDatum : compSciStudentData) {
			System.out.println(compSciStudentDatum);
		}
		
		
	}
	public static UserPOJO[] sortStudentsByGrade (UserPOJO[] studentData) {
				
		Arrays.sort(studentData, new Comparator<UserPOJO>() {
		// not UserPOJO[] because not comparing 2 arrays but comparing 2 users (objects) at the time
			
			@Override
			public int compare(UserPOJO student1, UserPOJO student2) {
				return student1.getStudentGrade().compareTo(student2.getStudentGrade());
			}
		});
		return  studentData;
	}
	
	public static UserPOJO[] findStudentsByClass (UserPOJO[] studentData, String courseID) {
		
		ArrayList<UserPOJO> filteredStudents = new ArrayList<UserPOJO>();
		// ArrayList<> can grow or expand without the need to know how big the array is
		
		for (UserPOJO studentDatum : studentData) {
			if (studentDatum.getStudentGrade().contains(courseID)) {
				filteredStudents.add(studentDatum);
			}
		}
		
		UserPOJO[] appliedFilter = new UserPOJO[filteredStudents.size()];
		
		filteredStudents.toArray(appliedFilter);
		
		return appliedFilter;
		
		
	}
}
