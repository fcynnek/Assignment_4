package com.fcynnek.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
	// this class will read in the Master List File

	int i = 0; // creating an index to read all lines in the file

	private UserPOJO[] studentDataArray = new UserPOJO[i];

	public String fileInput() throws IOException {

		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader (new FileReader ("master.csv"));

			String line = "";

			int i = 1;

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

			} finally {
				
			}
		} finally {
			try {
				fileReader.close();
			} finally {
				
			}
		}
		return null;
	}
}
