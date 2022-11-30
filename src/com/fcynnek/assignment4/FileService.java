package com.fcynnek.assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
	// this class will read in the Master List File

	String fileName = "master.csv";
	
	public static Integer countLines (String fileName) {

		BufferedReader fileReader = null;

		int numberOfLines = 0;

		try {
			fileReader = new BufferedReader(new FileReader(fileName));

			try {
				while ((fileReader.readLine()) != null) {
					numberOfLines = numberOfLines + 1;
				}
			} catch (IOException e) {
				System.out.println("I/O Exception ocurred");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(".txt File not found");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return numberOfLines;
	} 


	public UserPOJO[] readStudentData(String fileName) throws IOException {

		BufferedReader fileReader = null;
		
		Integer numberOfLines = countLines(fileName);
		
		UserPOJO[] studentDataArray = new UserPOJO[numberOfLines];
		
		int i = 0;

		try {
			fileReader = new BufferedReader(new FileReader(fileName));

			String line = null;

			try {
				while ((line = fileReader.readLine()) != null) {
					System.out.println(line);

					String[] parsedLine = line.split(",");
					String parsedStudentID = parsedLine[0];
					String parsedStudentName = parsedLine[1];
					String parsedCourseID = parsedLine[2];
					String parsedStudentGrade = parsedLine[3];

					UserPOJO studentData = new UserPOJO();
					studentData.setStudentID(parsedStudentID);
					studentData.setStudentName(parsedStudentName);
					studentData.setCourseID(parsedCourseID);
					studentData.setStudentGrade(parsedStudentGrade);

					studentDataArray[i] = studentData;
					i = i + 1;
				}  
			} catch (IOException e) {
				System.out.println("I/O Exception ocurred");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(".txt File not found");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return studentDataArray;
	}
}