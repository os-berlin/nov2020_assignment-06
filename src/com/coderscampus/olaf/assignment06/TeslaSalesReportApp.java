package com.coderscampus.olaf.assignment06;

import java.util.List;

public class TeslaSalesReportApp {

	public static void main(String[] args) {

		FileService fileService = new FileService();
		SalesReportService sales = new SalesReportService();

		List<SalesReport> model3Sales = fileService.readCSV("model3.csv");
		List<SalesReport> modelSSales = fileService.readCSV("modelS.csv");
		List<SalesReport> modelXSales = fileService.readCSV("modelX.csv");

		sales.salesStatistics("Model 3", model3Sales);
		sales.salesStatistics("Model S", modelSSales);
		sales.salesStatistics("Model X", modelXSales);

	}

}
