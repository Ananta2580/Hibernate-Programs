package com.java.hms.Main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.java.hms.Appointment;
import com.java.hms.Doctor;
import com.java.hms.Patient;
import com.java.hms.dao.AppointmentDao;
import com.java.hms.dao.DoctorDao;
import com.java.hms.dao.HmsDaoImpl;
import com.java.hms.dao.PatientDao;

public class HmsMain {
	
	public static void addPatientMain() {
		Scanner sc = new Scanner(System.in);
        Patient patient = new Patient();
        PatientDao patientDao = new HmsDaoImpl();

        System.out.print("Enter Patient ID: ");
        patient.setPatientId(sc.nextInt());
        sc.nextLine();  

        System.out.print("Enter Patient Name: ");
        patient.setPatientName(sc.nextLine());

        System.out.print("Enter Age: ");
        patient.setAge(sc.nextInt());
        sc.nextLine();  

        System.out.print("Enter Gender: ");
        patient.setGender(sc.nextLine());

        System.out.print("Enter Patient Address: ");
        patient.setPatientAddress(sc.nextLine());

        System.out.print("Enter Disease: ");
        patient.setDisease(sc.nextLine());

        System.out.print("Enter Patient Phone: ");
        patient.setPatientPhone(sc.nextLong());
        
        String res = patientDao.addPatient(patient);
        
        System.out.println(res);
	}
	
	public static void showPatient() {
		PatientDao patientDao = new HmsDaoImpl();
		List<Patient> patientList = patientDao.showAllPatient();
		
		for (Patient patient : patientList) {
			System.out.println(patient);
		}
	}
	
	public static void getPatientMain() {
		Scanner sc = new Scanner(System.in);
        PatientDao patientDao = new HmsDaoImpl();
        
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        
        Patient patient = patientDao.getPatientById(patientId);
        System.out.println(patient);
	}
	
	public static void addDoctor() {
		Scanner sc = new Scanner(System.in);
        Doctor doctor = new Doctor();
        DoctorDao doctorDao = new HmsDaoImpl();

        System.out.print("Enter Doctor ID: ");
        doctor.setDoctorId(sc.nextInt());
        sc.nextLine(); 

        System.out.print("Enter Doctor Name: ");
        doctor.setDoctorName(sc.nextLine());

        System.out.print("Enter Specialization: ");
        doctor.setSpecialization(sc.nextLine());

        System.out.print("Enter Doctor Phone: ");
        doctor.setDoctorPhone(sc.nextLong());
        
        String res = doctorDao.addDoctor(doctor);
        System.out.println(res);
        
	}
	
	public static void showDoctorsMain() {
		DoctorDao doctorDao = new HmsDaoImpl();
		List<Doctor> doctorList = doctorDao.showDoctors();
		
		for (Doctor doctor : doctorList) {
			System.out.println(doctor);
		}
	}
	public static void getDoctorbySpecializationMain() {
		DoctorDao doctorDao = new HmsDaoImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Specialization: ");
		String specialization = sc.nextLine();
		List<Doctor> doctorList = doctorDao.getDoctorbySpecialization(specialization);
		
		for (Doctor doctor : doctorList) {
			System.out.println(doctor);
		}
	}
	
	public static void bookAppointmentMain() {
		Scanner sc = new Scanner(System.in);
        Appointment appointment = new Appointment();
        AppointmentDao ap = new HmsDaoImpl();

        System.out.print("Enter Appointment ID: ");
        appointment.setAppointmentId(sc.nextInt());

        System.out.print("Enter Patient ID: ");
        appointment.setPatientId(sc.nextInt());

        System.out.print("Enter Doctor ID: ");
        appointment.setDoctorId(sc.nextInt());

        System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
        String dateInput = sc.next();
        appointment.setDate(Date.valueOf(dateInput));
        
        System.out.println(ap.bookAppointment(appointment));
	}
	
	public static void viewAppointmentBydocId() {
		Scanner sc = new Scanner(System.in);
        
        AppointmentDao ap = new HmsDaoImpl();
        
		System.out.print("Enter Doctor ID: ");
		int docId = sc.nextInt();
		
		List<Appointment> apList = ap.viewAppointmentBydocId(docId);
		
		for (Appointment appointment : apList) {
			System.out.println(appointment);
		}
	}
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n===== Hospital Management System Menu =====");
	            System.out.println("1. Add Patient");
	            System.out.println("2. Show All Patients");
	            System.out.println("3. Get Patient by ID");
	            System.out.println("4. Add Doctor");
	            System.out.println("5. Show All Doctors");
	            System.out.println("6. Get Doctor by Specialization");
	            System.out.println("7. Book Appointment");
	            System.out.println("8. View Appointment by Doctor ID");
	            System.out.println("9. Exit");
	            System.out.print("Enter your choice: ");
	            
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    addPatientMain();
	                    break;
	                case 2:
	                    showPatient();
	                    break;
	                case 3:
	                    getPatientMain();
	                    break;
	                case 4:
	                    addDoctor();
	                    break;
	                case 5:
	                    showDoctorsMain();
	                    break;
	                case 6:
	                    getDoctorbySpecializationMain();
	                    break;
	                case 7:
	                    bookAppointmentMain();
	                    break;
	                case 8:
	                    viewAppointmentBydocId();
	                    break;
	                case 9:
	                    System.out.println("Exiting... Thank you!");
	                    break;
	                default:
	                    System.out.println("Invalid choice! Try again.");
	            }

	        } while (choice != 9);
	        
	        sc.close();
	}

}

