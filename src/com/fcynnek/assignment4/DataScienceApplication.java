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

//		UserPOJO[] sortedStudentsByClass = sortStudentsByClass(studentData);
		// same thing as studentData but assigning it a different name
		// TODO look up references in Java

		UserPOJO[] compSciStudentData = findStudentsByClass(studentData, "COMPSCI");
		UserPOJO[] APMthStudentData = findStudentsByClass(studentData, "APMTH");
		UserPOJO[] statsStudentData = findStudentsByClass(studentData, "STAT");
		
//		UserPOJO[] sortedCompSci = sortStudentsByGrade(compSciStudentData);
//		
//		for (UserPOJO compSciStudentDatum : sortedCompSci) {
//			System.out.println(compSciStudentDatum);
//		}
		
		fileService.outputSortedStudents(compSciStudentData, "CompSci.csv");
//		fileService.outputSortedStudents(APMthStudentData, "APMth.csv");
//		fileService.outputSortedStudents(statsStudentData, "Stat.csv");
		
	}
	
	public static UserPOJO[] sortStudentsByClass (UserPOJO[] studentData) {
		
		Arrays.sort(studentData, new Comparator<UserPOJO>() {
		// not UserPOJO[] because not comparing 2 arrays but comparing 2 users (objects) at the time
			
			@Override
			public int compare(UserPOJO student1, UserPOJO student2) {
				return student1.getCourseID().compareTo(student2.getCourseID());
				// natural sort (A-Z)
			}
		});
		return  studentData;
	}
	
	
	public static UserPOJO[] sortStudentsByGrade (UserPOJO[] studentData) {
				
		Arrays.sort(studentData, new Comparator<UserPOJO>() {
		// not UserPOJO[] because not comparing 2 arrays but comparing 2 users (objects) at the time
			
			@Override
			public int compare(UserPOJO student1, UserPOJO student2) {
				return student2.getStudentGrade().compareTo(student1.getStudentGrade());
				// sorting from highest to lowest
			}
		});
		return  studentData;
	}
	
	
	public static UserPOJO[] findStudentsByClass (UserPOJO[] studentData, String courseID) {
		
		ArrayList<UserPOJO> filteredStudents = new ArrayList<UserPOJO>();
		// ArrayList<> can grow or expand without the need to know how big the array is
		
		for (UserPOJO studentDatum : studentData) {
			if (studentDatum.getCourseID().contains(courseID)) {
				filteredStudents.add(studentDatum);
			}
		}
		
		UserPOJO[] appliedFilter = new UserPOJO[filteredStudents.size()];
		
		filteredStudents.toArray(appliedFilter);
		
		return appliedFilter;
	}
}
