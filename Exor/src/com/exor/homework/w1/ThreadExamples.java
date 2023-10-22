package com.exor.homework.w1;

import java.util.Scanner;

public class ThreadExamples {
	/*
	 * ������ : ���α׷� ������ ����Ǵ� �������� ���� �帧. (���� �۾��� �����ϴ� �۾� ����)
	 * 
	 * Ư¡
	 * 1. �������� ���� �帧 : �� ������� �������� �۾� ������ ���� -> �ϳ��� ���μ��� ������ ���� ���� �۾� ���� ���� ����
	 * 2. ���� �޸� : �� ������� �ڽŸ��� ���� �޸𸮸� ������, �Լ� ȣ��� ���� ���� ���忡 �����
	 * 3. �� �޸� ���� : ��������� ���� ���μ��� ������ ����ǹǷ� �ش� ���μ����� �� �޸𸮸� ������. ������ ������ ���� ������ ������ �����ϸ�, 
	 * 					���ü� ��� ���� ��Ŀ������ �ʿ�
	 * 
	 * �뵵
	 * 1. ���ü� : ���� �����带 ����� ���� �۾��� ���ÿ� ������ �� ����
	 * 2. ���ҽ� ȿ���� : ������� ���μ������� �޸𸮿� ���ҽ� ��뷮�� �����Ƿ�, �����带 ����ϸ� �ý��� ȿ������ ���� �� ����
	 * 3. ���伺 ��� : ��׶��� �����带 ��������ν� ���� ������� ����ڿ��� ��ȣ�ۿ뿡�� �����ϰ� �� �� ����
	 * 4. ���� ó�� : ��Ƽ�ھ� ���μ��� ȯ�濡�� ��Ƽ �������� ���� ���� �ھ�� ���ÿ� �۾��� �����Ͽ� ó�� �ӵ� ���
	 * 
	 * ��Ƽ ������ ������
	 * 1. ���ؽ�Ʈ ����Ī ������� : ������ �� ��ȯ�� ������ ������尡 �����Ǿ� ������ ���ϵ� �� ����
	 * 2. ������ ����� ����ȭ : ���� �����尡 ���ÿ� �ϳ��� ���� ���ҽ��� ������ �� ����ȭ �ʿ�. deadlock �߻����� �ʵ��� ����
	 * 3. ���α׷��� ���⼺ : �ڵ��� ���⼺�� �����Ͽ� ������ ���ɼ��� ������ �� �ְ�, ������� ������� �� ����
	 */
	
	// ���� ���
	public class PrintNumbers implements Runnable{
		private int number;
		public PrintNumbers(int number) {
			this.number = number;
		}
		
		@Override
		public void run() {
			for (int i = 1; i <= number; i++) {
				System.out.println("number : " + i); 
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	// ���� �ջ�
	public class SumUp implements Runnable{
		private int number;
		public SumUp(int number) {
			this.number = number;
		}

		@Override
		public void run() {
			int sum = 0;
			for (int i = 1; i <= number; i++) {
				sum += i;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("sum : " + sum);
		}
		
	}
	
	public class Course{
		private String name;
		private int remainingSeats;
		
		public Course(String name, int remainingSeats) {
			this.name = name;
			this.remainingSeats = remainingSeats;
		}
		
		public synchronized boolean register(String studentName) {
			if(remainingSeats > 0) {
				remainingSeats--;
				System.out.println(studentName + " �� " + name + " ���� ��� ���� (�ܿ��� : " + remainingSeats + ")");
				
				return true;
			} else {
				System.out.println(studentName + " �� " + name + " ���� ��� ���� (�ο� �ʰ�)");
				return false;
			}
		}
	}
	
	public class Registration implements Runnable{
		private final Course course;
		private final String studentName;
		
		public Registration(Course course, String studentName) {
			this.course = course;
			this.studentName = studentName;
		}
		
		@Override
		public void run() {
			course.register(studentName);
		}
		
	}
	
	
}
