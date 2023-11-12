package com.exor.homework.solidPrinciples;

import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleResponsibility {
	/*
	 * Single Responsibility principle
	 * : ����Ʈ������ �� ���� ��Ҵ� �ϳ���, �ϳ����� å���� ���� �Ѵ�.
	 */
	
	// 1. cohesion(������) : �ϳ��� ��� ���� ���� ��ҵ��� ������� ���ü� ����
	public class Square {
		/*
		 * calculateArea(), calculatePerimeter()�� '�簢�� ����'�� ���õ� ���, draw(), rotate()�� '�簢�� �̹��� ������'�� ���õ� �����
		 * ������ ����. ���� ���ü��� ���� ��ɵ鳢���� �� �ֵ��� �� Ŭ������ ������ �����丵�Ͽ� �������� ������.
		 * 
		 * => ���� �������� �߱��ϸ� SRP�� �������
		 */
		int side = 5;
		
		// �簢�� ���� ����
		public int calculateArea() {
			return side * side;
		}
		
		// �簢�� �ѷ��� �� ����
		public int calculatePerimeter() {
			return side * 4;
		}
		
//		// �簢���� ȭ�鿡 ���
//		public void draw() {}
//		
//		// �簢���� ȸ������ ���
//		public void rotate() {}
	}
	
	public class SquareUi{
		public void draw() {}
		
		public void rotate() {}
		
	}
	
	// 2. coupling(���յ�) : ��� ���� ���� ����
	/*
	 * ���� DB�� NoSQL�� �����ϱ�� �� ��� Student Ŭ������ save() �޼ҵ带 �����ؾ� ��. ��, Student Ŭ������ DB layer�� ���ϰ� ���ӵǾ� ����.
	 * Student Ŭ������ �л��� ���õ� �⺻���� ��ɸ� å�������� �鿣�� DB�� ���� ���� �����ϰ��� ��� ����� ��.
	 * DB ���� �ڵ�� ������ Ŭ������ ���� ���յ��� ������.
	 * 
	 * => ���յ��� ���߸� SRP�� �������
	 */
	public class Student{
		private String studentId;
		private Date studentDOB;
		private String studentAdress;
		
//		public void save() {
//			// Connection ���� �� mySQL DB �����ؼ� �л� ���� INSERT�ϴ� ����			
//		}
		
		public void save() {
			new StudentRepository().save(this);
		}
		
		public String getStudentId() {
			return studentId;
		}
		
		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}
	}
	
	public class StudentRepository {
		public void save(Student student) {
			// Connection ���� �� mySQL DB �����ؼ� �л� ���� INSERT�ϴ� ����	
		}
	}
	
	// 3. ����Ʈ������ �� ���� ��Ҵ� �ϳ���, �ϳ����� "�ٲ��� �� ����"�� ������ �Ѵ�.
	/*
	 * ���� ���� Student Ŭ������ ���� �ٲ��� �� ���� �ִ� ����
	 * 1) Student ID ������ ����
	 * 2) ���� ���� �̸� ������ ����
	 * 3) ������� DB�� ����
	 * 
	 * -> �ٲ��� �� ������ ������ = ������ ���� �̷���� = ���� ���� = �ð��� ��� = ��!
	 * 
	 * �������� ���� Student, StudentRepository Ŭ������ �������� ��, Student Ŭ������ �ٲ��� �� ���� �ִ� ������ 2��������, 
	 * �� ���� ���� �����ϰ� ���õǾ� �����Ƿ� "student profile ������ ����"�̶�� 1���� ������ ���� �� ����.
	 * 
	 * => �������� ���� �� �ִ� å��(responsibility)�� ����� ��. �׷��� ������ ������ ���� Ŭ������ �����Ͽ� ���⼺�� ���̰� �� 
	 */
	
	// 
	public class Employee {
		/*
		 * Employee Ŭ������ ���� �ٲ��� �� ���� �ִ� ����
		 * 1) Employee �Ӽ��� ����
		 * 2) DB ����
		 * 3) ���� ���� ����
		 * 
		 * -> save() �޼ҵ��� DB ���� ������ EmployeeRepository Ŭ������, calculateTax() �޼ҵ��� ���� ��� ������ TaxCalculator Ŭ������
		 * ������.
		 */
		private String employeeId;
		private String employeeName;
		private String employeeAdress;
		private String contactNumber;
		private String employeeType;
		
		public void save() {
			Connection conn = null;
			Statement stmt = null;
			String objectStr = null; // Employee ��ü ���ڿ��� ����ȭ (����)
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "password");
				stmt = conn.createStatement();
				stmt.execute("INSERT INTO EMPLOYEE VALUES (" + objectStr + ")");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void calculateTax() {
			if(this.getEmployeeType().equals("fulltime")) {
				// ������ ���� ��� ����
			}
			if(this.getEmployeeType().equals("parttime")) {
				// �Ƹ�����Ʈ ���� ��� ����
			}
		}
		
		public String getEmployeeId() {
			return employeeId;
		}
		
		public String getEmployeeName() {
			return employeeName;
		}
		
		public String getEmployeeAdress() {
			return employeeAdress;
		}
		
		public String getContactNumber() {
			return contactNumber;
		}
		
		public String getEmployeeType() {
			return employeeType;
		}
		
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		
		public void setEmployeeAdress(String employeeAdress) {
			this.employeeAdress = employeeAdress;
		}
		
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		
		public void setEmployeeType(String employeeType) {
			this.employeeType = employeeType;
		}
	}
}
