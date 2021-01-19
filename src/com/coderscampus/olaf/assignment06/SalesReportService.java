package com.coderscampus.olaf.assignment06;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesReportService {
	
	public void salesStatistics (String model , List<SalesReport> report) {
		System.out.println(model + " Yearly Sales Report \n---------------------------");		
		
		// sales by year
		Map<Integer, List<SalesReport>> salesByYear = report.stream()
															.collect(Collectors.groupingBy(x -> x.getDate().getYear()));
		
		System.out.println(salesByYear.entrySet().stream()
											     .map(x -> x.getKey() + " : " + x.getValue().stream()
											    		  									.collect(Collectors.summingInt(y -> y.getSales())))
											     .collect(Collectors.joining("\n")));	

		System.out.println();
		
		// best/worst month _ preliminary work
		IntSummaryStatistics salesStatistics = report.stream()
												     .mapToInt(teslaSales -> teslaSales.getSales().intValue())
													 .summaryStatistics();
		// best month 
		String bestMonth = report.stream()
								 .filter(x -> x.getSales() == salesStatistics.getMax())
								 .map(y -> y.getDate().toString())
								 .collect(Collectors.joining(", "));
		// worst month
		String worstMonth = report.stream()
								  .filter(x -> x.getSales() == salesStatistics.getMin())
								  .map(y -> y.getDate().toString())
								  .collect(Collectors.joining(", "));
		
		System.out.println("The best month for " + model + " was: " + bestMonth);
		System.out.println("The worst month for " + model + " was: " + worstMonth + "\n");
	}
}
