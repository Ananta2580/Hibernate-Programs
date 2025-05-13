package com.java.hib.dao;

import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.java.hib.model.Employee;
import com.java.hib.model.Otp;
import com.java.hib.util.MailSend;
import com.java.hib.util.SessionHelper;

public class EmployeeDaoImpl implements EmployeeDao{
	
	Session session;
	
	public int generateOtp() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	@Override
	public String addEmployee(Employee employee) {
		session = SessionHelper.getConnection().openSession();
		Transaction trans = session.beginTransaction();
		session.save(employee);
		trans.commit();
		Otp otp = new Otp();
		int code = generateOtp();
		otp.setOtpNo(code);
		otp.setStatus("INACTIVE");
		otp.setUserName(employee.getUserName());
		trans = session.beginTransaction();
		session.save(otp);
		trans.commit();
		String subject = "Hi " +employee.getUserName() + " Your acccount created ";
		String body = "Your Otp Code is " +code + " Please Use for Password Generation";
		MailSend.sendInfo(employee.getEmail(), subject, body);
		return "Employee Record Added and Send opt By Mail...";
	}
	
	public String getAlphaNumericString()
	 {
	 
	  // choose a Character random from this String
	  String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	         + "0123456789"
	         + "abcdefghijklmnopqrstuvxyz";
	 
	  // create StringBuffer size of AlphaNumericString
	  StringBuilder sb = new StringBuilder(10);
	 
	  for (int i = 0; i < 10; i++) {
	 
	   // generate a random number between
	   // 0 to AlphaNumericString variable length
	   int index
	    = (int)(AlphaNumericString.length()
	      * Math.random());
	 
	   // add Character one by one in end of sb
	   sb.append(AlphaNumericString
	      .charAt(index));
	  }
	 
	  return sb.toString();
	 }

	
	@Override
	public String generatePassword(String user, int otp) {
		session = SessionHelper.getConnection().openSession();
		Criteria cr = session.createCriteria(Otp.class);
		cr.add(Restrictions.eq("userName", user));
		cr.add(Restrictions.eq("otpNo", otp));
		cr.add(Restrictions.eq("status", "INACTIVE"));
		Otp objOtp = (Otp)cr.uniqueResult();
		if (objOtp != null) {
			Query query = session.createQuery("from Employee where userName='"+user+"'");
			Employee employee = (Employee)query.uniqueResult();
			String pwd = getAlphaNumericString();
			objOtp.setStatus("ACTIVE");
			objOtp.setnPassword(pwd);
			Transaction trans = session.beginTransaction();
			session.update(objOtp);
			trans.commit();
			String body = "Your One-Time Password for Login is " +pwd;
			MailSend.sendInfo(employee.getEmail(), "One Time Password", body);
			return "Your One-Time password Generated and Emailed to you...";
		}
		return "Employ Record Not Found...Otp or username wrong...";
	}

	@Override
	public String validatePassword(String user, String password) {
		session = SessionHelper.getConnection().openSession();
		Criteria cr = session.createCriteria(Otp.class);
		cr.add(Restrictions.eq("userName", user));
		cr.add(Restrictions.eq("nPassword", password));
		Otp otp = (Otp) cr.uniqueResult();
		if(otp != null) {
			return "Thanks for logging in";
		}
		else {
			return "Enter Correct Password";
		}
	}

	@Override
	public String updatePassword(String user, String pwd) {
		session = SessionHelper.getConnection().openSession();
		Transaction tx = null;
		Criteria cr = session.createCriteria(Employee.class);
        cr.add(Restrictions.eq("userName", user));
        Employee emp = (Employee) cr.uniqueResult();

        if (emp != null) {
            tx = session.beginTransaction();
            
            emp.setPassCode(pwd);
            emp.setStatus("Active");
            session.update(emp);

            Query query = session.createQuery("from Otp where userName='"+user+"'");
            Otp otp = (Otp)query.uniqueResult();

            if (otp != null) {
                session.delete(otp);
            }

            tx.commit();
            return "Employee Updated Successfully";
        } else {
            return "No Employee Found for Update";
        }
	}
	
	

}
