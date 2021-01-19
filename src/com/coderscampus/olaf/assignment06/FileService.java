package com.coderscampus.olaf.assignment06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

	public List<SalesReport> readCSV(String file) {
		List<SalesReport> salesData = new ArrayList<>();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));) {
			fileReader.readLine(); // skip 1st line
			String line;
			while ((line = fileReader.readLine()) != null) {
				String[] data = line.split(",");
				salesData.add(new SalesReport(data[0], data[1]));
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please check file location!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return salesData;
	}
}