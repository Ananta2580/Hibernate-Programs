package com.java.hms.dao;

import java.util.List;

import com.java.hms.Appointment;

public interface AppointmentDao {
	
	String bookAppointment(Appointment appointment);
	List<Appointment> viewAppointmentBydocId(int docId);

}
