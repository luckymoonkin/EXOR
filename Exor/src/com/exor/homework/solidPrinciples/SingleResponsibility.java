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
	 * : 소프트웨어의 각 구성 요소는 하나의, 하나만의 책임을 져야 한다.
	 */
	
	// 1. cohesion(응집도) : 하나의 모듈 내에 구성 요소들의 기능적인 관련성 정도
	public class Square {
		/*
		 * calculateArea(), calculatePerimeter()는 '사각형 측정'에 관련된 기능, draw(), rotate()는 '사각형 이미지 렌더링'에 관련된 기능을
		 * 가지고 있음. 서로 관련성이 높은 기능들끼리만 모여 있도록 두 클래스로 나누어 리팩토링하여 응집도를 높이자.
		 * 
		 * => 높은 응집도를 추구하면 SRP에 가까워짐
		 */
		int side = 5;
		
		// 사각형 면적 측정
		public int calculateArea() {
			return side * side;
		}
		
		// 사각형 둘레의 합 측정
		public int calculatePerimeter() {
			return side * 4;
		}
		
//		// 사각형을 화면에 출력
//		public void draw() {}
//		
//		// 사각형을 회전시켜 출력
//		public void rotate() {}
	}
	
	public class SquareUi{
		public void draw() {}
		
		public void rotate() {}
		
	}
	
	// 2. coupling(결합도) : 모듈 간의 종속 정도
	/*
	 * 추후 DB를 NoSQL로 변경하기로 할 경우 Student 클래스의 save() 메소드를 수정해야 함. 즉, Student 클래스는 DB layer과 강하게 종속되어 있음.
	 * Student 클래스는 학생과 관련된 기본적인 기능만 책임져야지 백엔드 DB에 관한 세부 디테일과는 상관 없어야 함.
	 * DB 관련 코드는 별도의 클래스로 빼서 결합도를 낮추자.
	 * 
	 * => 결합도를 낮추면 SRP에 가까워짐
	 */
	public class Student{
		private String studentId;
		private Date studentDOB;
		private String studentAdress;
		
//		public void save() {
//			// Connection 생성 후 mySQL DB 접근해서 학생 정보 INSERT하는 로직			
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
			// Connection 생성 후 mySQL DB 접근해서 학생 정보 INSERT하는 로직	
		}
	}
	
	// 3. 소프트웨어의 각 구성 요소는 하나의, 하나만의 "바뀌어야 할 이유"를 가져야 한다.
	/*
	 * 변경 전의 Student 클래스가 추후 바뀌어야 할 수도 있는 이유
	 * 1) Student ID 형식의 변경
	 * 2) 법에 의해 이름 형식이 변경
	 * 3) 기술팀이 DB를 변경
	 * 
	 * -> 바뀌어야 할 이유가 여러개 = 변경이 자주 이루어짐 = 버그 증가 = 시간과 노력 = 돈!
	 * 
	 * 위에서와 같이 Student, StudentRepository 클래스로 나누었을 때, Student 클래스는 바뀌어야 할 수도 있는 이유가 2개이지만, 
	 * 이 둘은 서로 밀접하게 관련되어 있으므로 "student profile 형식의 변경"이라는 1개의 이유로 묶을 수 있음.
	 * 
	 * => 논리적으로 묶을 수 있는 책임(responsibility)는 묶어야 함. 그렇지 않으면 무수히 많은 클래스를 생성하여 복잡성만 높이게 됨 
	 */
	
	// 
	public class Employee {
		/*
		 * Employee 클래스가 추후 바뀌어야 할 수도 있는 이유
		 * 1) Employee 속성의 변경
		 * 2) DB 변경
		 * 3) 세금 계산식 변경
		 * 
		 * -> save() 메소드의 DB 관련 로직은 EmployeeRepository 클래스로, calculateTax() 메소드의 세금 계산 로직은 TaxCalculator 클래스로
		 * 나누자.
		 */
		private String employeeId;
		private String employeeName;
		private String employeeAdress;
		private String contactNumber;
		private String employeeType;
		
		public void save() {
			Connection conn = null;
			Statement stmt = null;
			String objectStr = null; // Employee 객체 문자열로 직렬화 (생략)
			
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
				// 정규직 세금 계산 로직
			}
			if(this.getEmployeeType().equals("parttime")) {
				// 아르바이트 세금 계산 로직
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
