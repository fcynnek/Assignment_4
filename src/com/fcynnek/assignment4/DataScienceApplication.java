package com.fcynnek.assignment4;

import java.io.IOException;

public class DataScienceApplication {

	public static void main(String[] args) throws IOException {
		
		String fileName = "master.csv";

		FileService fileService = new FileService();
		
		fileService.readStudentData(fileName);
	}

}
