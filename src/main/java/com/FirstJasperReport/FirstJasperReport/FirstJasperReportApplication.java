package com.FirstJasperReport.FirstJasperReport;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class FirstJasperReportApplication {

	public static void main(String[] args) throws JRException {

		SpringApplication.run(FirstJasperReportApplication.class, args);
		String filePath="C:\\Users\\LATITUDE 3450\\Desktop\\MyCodeProjects\\JAVA\\First-Jasper-Report\\src\\main\\resources\\templates\\FirstReport.jrxml";

		Employee employee1 = new Employee("John Smith", "Software Engineer", 75000);
		Employee employee2 = new Employee("Alice Johnson", "Data Analyst", 60000);
		Employee employee3 = new Employee("Michael Brown", "Project Manager", 90000);
		Employee employee4 = new Employee("Emily Davis", "QA Tester", 55000);
		Employee employee5 = new Employee("Daniel Wilson", "Product Manager", 85000);
		Employee employee6 = new Employee("Olivia Lee", "Marketing Specialist", 62000);
		Employee employee7 = new Employee("Matthew Turner", "UI Designer", 68000);
		Employee employee8 = new Employee("Sophia Martinez", "Business Analyst", 72000);
		Employee employee9 = new Employee("James Johnson", "Systems Administrator", 80000);
		Employee employee10 = new Employee("Emma Harris", "Sales Manager", 58000);
		Employee employee11 = new Employee("Adam DeMamp", "Sales Representative", 28000);
		Employee employee12 = new Employee("Blake Henderson", "Sales Representative", 30000);
		Employee employee13 = new Employee("Anders Holmvik", "Sales Representative", 32000);

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);
		employeeList.add(employee6);
		employeeList.add(employee7);
		employeeList.add(employee8);
		employeeList.add(employee9);
		employeeList.add(employee10);
		employeeList.add(employee11);
		employeeList.add(employee12);
		employeeList.add(employee13);

		JRBeanCollectionDataSource employeeDataSource = new JRBeanCollectionDataSource(employeeList);

		Map<String,Object> parameters = new HashMap<>();
		parameters.put("company","TelAmeriCorp");
		parameters.put("departmentName", "Development");
		parameters.put("EmployeeDataset", employeeDataSource);

		JasperReport report = JasperCompileManager.compileReport(filePath);
		JasperPrint print = JasperFillManager.fillReport(report,parameters, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\LATITUDE 3450\\Desktop\\MyCodeProjects\\JAVA\\First-Jasper-Report\\src\\main\\resources\\static\\FirstReport.pdf");
		System.out.println("Report generated, Great success!");
		System.out.println(employeeList);

	}
}
