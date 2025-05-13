package com.java.pms;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.EmployeeNotFoundException;
import com.java.pms.MyException.FinancialRecordException;
import com.java.pms.MyException.InvalidInputException;
import com.java.pms.MyException.PayrollGenerationException;
import com.java.pms.MyException.TaxCalculationException;
import com.java.pms.bal.EmployeeValidation;
import com.java.pms.bal.FinanceRecordValidation;
import com.java.pms.bal.PayrollValidation;
import com.java.pms.bal.TaxValidation;
import com.java.pms.dao.ITaxService;
import com.java.pms.model.Employee;
import com.java.pms.model.FinancialRecord;
import com.java.pms.model.Payroll;
import com.java.pms.model.Tax;

public class PayExpertMain {
	static Scanner sc = null;
	static EmployeeValidation val = null;
	static PayrollValidation payrollValidation = null;
	static TaxValidation taxValidation = null;
	static FinanceRecordValidation fValidation = null;
	
	public static void getEmployeeMain() {
		sc = new Scanner(System.in);
		System.out.println("Enter your emp Id ");
		int empId = sc.nextInt();
		val = new EmployeeValidation();
		
		try {
			System.out.println(val.getEmployeeValid(empId));
		} catch (DatabaseConnectionException e) {
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
	}
	
	public static void getAllEmployeeMain() {
		val = new EmployeeValidation();
		try {
			List<Employee> empList = val.getAllEmployeeValid();
//			System.out.println(empList);
			for (Employee employee : empList) {
				System.out.println(employee);
			}
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void addEmployeeMain() {
		sc = new Scanner(System.in);
		Employee emp = new Employee();
		val = new EmployeeValidation();
		
		
		System.out.print("Enter Employee ID: ");
        emp.setEmpId(sc.nextInt());
        
        sc.nextLine();

        System.out.print("Enter First Name: ");
        emp.setfName(sc.nextLine());

        System.out.print("Enter Last Name: ");
        emp.setlName(sc.nextLine());

        System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
        emp.setDOB(java.sql.Date.valueOf(sc.nextLine()));

        System.out.print("Enter Gender: ");
        emp.setGender(sc.nextLine());

        System.out.print("Enter Email: ");
        emp.setEmail(sc.nextLine());

        System.out.print("Enter Mobile Number: ");
        emp.setMobNo(sc.nextLong());
        
        sc.nextLine();

        System.out.print("Enter Address: ");
        emp.setAddress(sc.nextLine());

        System.out.print("Enter Position: ");
        emp.setPosition(sc.nextLine());

        System.out.print("Enter Joining Date (yyyy-mm-dd): ");
        emp.setJoinDate(java.sql.Date.valueOf(sc.nextLine()));

        System.out.print("Enter Termination Date (yyyy-mm-dd) or press Enter if not applicable: ");
        String termDate = sc.nextLine();
        if (!termDate.isEmpty()) {
            emp.setTerminationDate(java.sql.Date.valueOf(termDate));
        } else {
            emp.setTerminationDate(null);
        }
        
        try {
			System.out.println(val.addEmployeeValid(emp));
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateEmployeeMain() {
		sc = new Scanner(System.in);
		Employee emp = new Employee();
		val = new EmployeeValidation();
		
		System.out.println("Enter the details you want to update...");
		
		System.out.print("Enter Employee ID: ");
        emp.setEmpId(sc.nextInt());
        
        sc.nextLine();

        System.out.print("Enter First Name: ");
        emp.setfName(sc.nextLine());

        System.out.print("Enter Last Name: ");
        emp.setlName(sc.nextLine());

        System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
        emp.setDOB(java.sql.Date.valueOf(sc.nextLine()));

        System.out.print("Enter Gender: ");
        emp.setGender(sc.nextLine());

        System.out.print("Enter Email: ");
        emp.setEmail(sc.nextLine());

        System.out.print("Enter Mobile Number: ");
        emp.setMobNo(sc.nextLong());
        
        sc.nextLine();

        System.out.print("Enter Address: ");
        emp.setAddress(sc.nextLine());

        System.out.print("Enter Position: ");
        emp.setPosition(sc.nextLine());

        System.out.print("Enter Joining Date (yyyy-mm-dd): ");
        emp.setJoinDate(java.sql.Date.valueOf(sc.nextLine()));

        System.out.print("Enter Termination Date (yyyy-mm-dd) or press Enter if not applicable: ");
        String termDate = sc.nextLine();
        if (!termDate.isEmpty()) {
            emp.setTerminationDate(java.sql.Date.valueOf(termDate));
        } else {
            emp.setTerminationDate(null);
        }
        
        try {
			System.out.println(val.updateEmployeeValid(emp));
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public static void removeEmployeeMain() {
		
		sc = new Scanner(System.in);
		System.out.println("Enter your emp Id ");
		int empId = sc.nextInt();
		val = new EmployeeValidation();
		
		try {
			System.out.println(val.removeEmployeeValid(empId));
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	
	
	public static void generatePayrollMain() {
		Scanner sc = new Scanner(System.in);
		Payroll payroll = new Payroll();
		payrollValidation = new PayrollValidation();
		
		System.out.print("Enter Employee ID: ");
        payroll.setEmpId(Integer.parseInt(sc.nextLine()));

        System.out.print("Enter Pay Period Start Date (yyyy-mm-dd): ");
        payroll.setPayPeriodStartDate(java.sql.Date.valueOf(sc.nextLine()));

        System.out.print("Enter Pay Period End Date (yyyy-mm-dd): ");
        payroll.setPayPeriodEndDate(java.sql.Date.valueOf(sc.nextLine()));

        System.out.print("Enter Overtime Hours: ");
        int hrs = sc.nextInt();
        
        System.out.print("Enter Overtime Payment you take per hour: ");
        double pay = sc.nextDouble();
        
        double overtimeSal = hrs * pay;
        
        payroll.setOverTimePay(overtimeSal);
        
        try {
			System.out.println(payrollValidation.generatePayrollValid(payroll));
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (PayrollGenerationException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	public static void getPayrollIdMain() {
		sc = new Scanner(System.in);
		System.out.println("Enter your Payroll Id ");
		int payrollId = sc.nextInt();
		payrollValidation = new PayrollValidation();
		
		try {
			System.out.println(payrollValidation.getPayrollIdValid(payrollId));
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getPayrollByEmpMain() {
		sc = new Scanner(System.in);
		System.out.println("Enter your emp Id ");
		int empId = sc.nextInt();
		payrollValidation = new PayrollValidation();
		
		try {
			List<Payroll> payList = payrollValidation.getPayrollByEmpValid(empId);
			for (Payroll payroll : payList) {
				System.out.println(payroll);
			}
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getPayrollByDateMain() {
		sc = new Scanner(System.in);
		
		System.out.print("Enter Pay Period Start Date (yyyy-mm-dd): ");
        Date start = java.sql.Date.valueOf(sc.nextLine());

        System.out.print("Enter Pay Period End Date (yyyy-mm-dd): ");
        Date end = java.sql.Date.valueOf(sc.nextLine());
        
        payrollValidation = new PayrollValidation();
        
        try {
			List<Payroll> payList = payrollValidation.getPayrollByDateValid(start, end);
			for (Payroll payroll : payList) {
				System.out.println(payroll);
			}
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PayrollGenerationException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	public static void calculeteTax() {
		 Scanner sc = new Scanner(System.in);
		 TaxValidation taxValidation = new TaxValidation();
		 
		 System.out.print("Enter Employee ID: ");
	     int empId = sc.nextInt();

	     System.out.print("Enter Tax Year (e.g., 2024): ");
	     int taxYear = sc.nextInt();
	     
	     sc.nextLine();

	     Tax tax = new Tax();
	     tax.setEmpId(empId);
	     tax.setTaxYear(taxYear);
	     
	     try {
			System.out.println(taxValidation.calculateTaxValid(tax));
		} catch (TaxCalculationException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PayrollGenerationException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	public static void getTaxById() {
		sc = new Scanner(System.in);
		System.out.println("Enter your Tax Id ");
		int taxId = sc.nextInt();
		taxValidation = new TaxValidation();
		try {
			Tax tax = taxValidation.getTaxByIdValid(taxId);
			System.out.println(tax);
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getTaxByEmpId() {
		sc = new Scanner(System.in);
		System.out.println("Enter your emp Id ");
		int empId = sc.nextInt();
		taxValidation = new TaxValidation();
		
		try {
			List<Tax> taxList = taxValidation.getTaxByempIdValid(empId);
			for (Tax tax : taxList) {
				System.out.println(tax);
			}
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getTaxByYear() {
		sc = new Scanner(System.in);
		System.out.println("Enter your Tax Year ");
		int taxYear = sc.nextInt();
		taxValidation = new TaxValidation();
		
		try {
			List<Tax> taxList = taxValidation.getTaxByYearValid(taxYear);
			for (Tax tax : taxList) {
				System.out.println(tax);
			}
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addFinancialMain() {
		sc = new Scanner(System.in);
		FinancialRecord fRecord = new FinancialRecord();
		System.out.print("Enter Employee ID: ");
        fRecord.setEmpId(sc.nextInt());
        
        sc.nextLine();

        System.out.print("Enter Description: ");
        fRecord.setDesc(sc.nextLine());

        System.out.print("Enter Amount: ");
        fRecord.setAmount(sc.nextDouble());
        
        sc.nextLine();

        System.out.print("Enter Type (income, expense, tax payment): ");
        fRecord.setRecordType(sc.nextLine());
        
        FinanceRecordValidation fValidation = new FinanceRecordValidation();
        
        try {
			System.out.println(fValidation.addFinanceValid(fRecord));
		} catch (FinancialRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}
	
	public static void getFinancialRecordIdMain() {
		sc = new Scanner(System.in);
		System.out.println("Enter your record Id ");
		int recordId = sc.nextInt();
		
		fValidation = new FinanceRecordValidation();
		try {
			System.out.println(fValidation.getFinanceRecordValid(recordId));
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getFinancialRecordEmpIdMain() {
		sc = new Scanner(System.in);
		System.out.println("Enter your Employee Id ");
		int empId = sc.nextInt();
		fValidation = new FinanceRecordValidation();
		
		try {
			List<FinancialRecord> recordList = fValidation.getFinanceRecordByEmpValid(empId);
			for (FinancialRecord financialRecord : recordList) {
				System.out.println(financialRecord);
			}
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getFinancialRecordDateMain() {
		sc = new Scanner(System.in);
		System.out.println("Enter the Date");
		Date date = java.sql.Date.valueOf(sc.nextLine());
		fValidation = new FinanceRecordValidation();
		
		try {
			List<FinancialRecord> recordList = fValidation.getFinanceRecordByDateValid(date);
			for (FinancialRecord financialRecord : recordList) {
				System.out.println(financialRecord);
			}
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== Payroll Management System ====");
            System.out.println("1. Get Employee");
            System.out.println("2. Get All Employees");
            System.out.println("3. Add Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Remove Employee");
            System.out.println("6. Generate Payroll");
            System.out.println("7. Get Payroll by ID");
            System.out.println("8. Get Payroll by Employee");
            System.out.println("9. Get Payroll by Date");
            System.out.println("10. Calculate Tax");
            System.out.println("11. Get Tax by ID");
            System.out.println("12. Get Tax by Employee ID");
            System.out.println("13. Get Tax by Year");
            System.out.println("14. Add Financial Record");
            System.out.println("15. Get Financial Record by ID");
            System.out.println("16. Get Financial Records by Employee ID");
            System.out.println("17. Get Financial Records by Date");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    getEmployeeMain();
                    break;
                case 2:
                    getAllEmployeeMain();
                    break;
                case 3:
                    addEmployeeMain();
                    break;
                case 4:
                    updateEmployeeMain();
                    break;
                case 5:
                    removeEmployeeMain();
                    break;
                case 6:
                    generatePayrollMain();
                    break;
                case 7:
                    getPayrollIdMain();
                    break;
                case 8:
                    getPayrollByEmpMain();
                    break;
                case 9:
                    getPayrollByDateMain();
                    break;
                case 10:
                	System.out.println(); 
                    calculeteTax();
                    System.out.println(); 
                    break;
                case 11:
                    getTaxById();
                    break;
                case 12:
                    getTaxByEmpId();
                    break;
                case 13:
                    getTaxByYear();
                    break;
                case 14:
                    addFinancialMain();
                    break;
                case 15:
                    getFinancialRecordIdMain();
                    break;
                case 16:
                    getFinancialRecordEmpIdMain();
                    break;
                case 17:
                    getFinancialRecordDateMain();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting the application.");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

		
		
	}
}
