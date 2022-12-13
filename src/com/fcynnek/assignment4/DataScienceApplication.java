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

		UserPOJO[] sortedStudentsByClass = sortStudentsByClass(studentData);
		// same thing as studentData but assigning it a different name
		// TODO look up references in Java

		UserPOJO[] compSciStudentData = findStudentsByClass(studentData, "COMPSCI");
		
		for (UserPOJO compSciStudentDatum : compSciStudentData) {
			System.out.println(compSciStudentDatum);
		}
		
		
	}
	public static UserPOJO[] sortStudentsByClass (UserPOJO[] studentData) {
				
		Arrays.sort(studentData, new Comparator<UserPOJO>() {
		// not UserPOJO[] because not comparing 2 arrays but comparing 2 users at the time
			
			@Override
			public int compare(UserPOJO student1, UserPOJO student2) {
				return student1.getCourseID().compareTo(student2.getCourseID());
			}
		});
		return  studentData;
	}
	
	public static UserPOJO[] findStudentsByClass (UserPOJO[] studentData, String courseID) {
		
		ArrayList<UserPOJO> filteredStudents = new ArrayList<UserPOJO>();
		// ArrayList<> can grow or expand without the need to know how big the array is
		
		//	filteredStudents.add(studentData[0]);
		
		for (UserPOJO studentDatum : studentData) {
			if (studentDatum.getCourseID().contains(courseID)) {
				filteredStudents.add(studentDatum);
			}
		}
		
		UserPOJO[] ans = new UserPOJO[filteredStudents.size()];
		
		filteredStudents.toArray(ans);
		
		return ans;
		
		
	}
}
