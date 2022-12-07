package com.fcynnek.assignment4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class DataScienceApplication {

	public static void main(String[] args) throws IOException {
		
		String fileName = "master.csv";

		FileService fileService = new FileService();
		UserPOJO userPOJOs = new UserPOJO();
		
		fileService.readStudentData(fileName);
		
		String sortedGrades = null;

		UserPOJO[] users = new UserPOJO[FileService.countLines(fileName)];

		Arrays.sort(users, new Comparator<UserPOJO>() {

			@Override
			public int compare(UserPOJO studentGrade1, UserPOJO studentGrade2) {

				return studentGrade1.getStudentGrade().compareTo(studentGrade2.getStudentGrade());
			}
		});
		for (UserPOJO studentGrade : studentGrades) {
			System.out.println(sortedGrade);
		}
	}

}
