package com.java.jstl.util;

public class CalcBean {
	
	private int firstno;
	private int secondno;
	private int result;
	
	public int sum() {
		return firstno + secondno;
	}
	public int sub() {
		return firstno - secondno;
	}

	public int mul() {
		return firstno * secondno;
	}

	public int getFirstno() {
		return firstno;
	}
	public void setFirstno(int firstno) {
		this.firstno = firstno;
	}
	public int getSecondno() {
		return secondno;
	}
	public void setSecondno(int secondno) {
		this.secondno = secondno;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public CalcBean(int firstno, int secondno, int result) {
		super();
		this.firstno = firstno;
		this.secondno = secondno;
		this.result = result;
	}
	public CalcBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
