package com.codeinsight.invoiceproject;

import java.util.Scanner;

import com.codeinsight.invoiceproject.dao.CompanyInfoDAO;
import com.codeinsight.invoiceproject.dao.EmployeeDAO;
import com.codeinsight.invoiceproject.dao.InvoiceDAO;
import com.codeinsight.invoiceproject.dao.ProductsDAO;
import com.codeinsight.invoiceproject.dao.ServicesDAO;
import com.codeinsight.invoiceproject.dao.TaxInfoDAO;
import com.codeinsight.invoiceproject.db.DbConnector;

public class UserInteractor {

	public void chooseOperation() {
		Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println(
						"View Data for : \n 1 - Company Info \n 2 - Products \n 3 - Services \n 4 - Employees \n 5 - Invoice \n 6 - Hardware cost \n 7 - Service cost \n 8 - Tax Info \n 0 - EXIT");
				Integer userChoice = scanner.nextInt();
				if (userChoice == 1) {
					System.out.println("COMPANY INFO");
					CompanyInfoDAO companyInfoDAO = new CompanyInfoDAO();
					companyInfoDAO.retrive();
				} else if (userChoice == 2) {
					System.out.println("PRODUCTS");
					ProductsDAO productsDAO = new ProductsDAO();
					productsDAO.retrive();
				} else if (userChoice == 3) {
					System.out.println("SERVICES");
					ServicesDAO servicesDAO = new ServicesDAO();
					servicesDAO.retrive();
				} else if (userChoice == 4) {
					System.out.println("EMPLOYEE");
					EmployeeDAO employeeDAO = new EmployeeDAO();
					employeeDAO.retrive();
				} else if (userChoice == 5) {
					System.out.println("INVOICE");
					InvoiceDAO invoiceDAO = new InvoiceDAO();
					invoiceDAO.retrive();
				} else if (userChoice == 6) {
					System.out.println("HARDWARE COST work in progess");
				} else if (userChoice == 7) {
					System.out.println("SERVICE COST work in progess");
				} else if (userChoice == 8) {
					System.out.println("TAX INFO");
					TaxInfoDAO taxInfoDAO = new TaxInfoDAO();
					taxInfoDAO.retrive();
				} else if (userChoice == 0) {
					System.out.println("EXIT");
					DbConnector.closeConnection();
					scanner.close();
					System.exit(0);
				} else {
					System.out.println("--WRONG INPUT--");
				}
			}
		}
	}

