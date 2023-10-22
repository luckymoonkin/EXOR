package com.exor.homework.w1;

import java.util.Scanner;

public class ThreadExamples {
	/*
	 * 스레드 : 프로그램 내에서 실행되는 독립적인 실행 흐름. (실제 작업을 수행하는 작업 단위)
	 * 
	 * 특징
	 * 1. 독립적인 실행 흐름 : 각 스레드는 독립적인 작업 단위를 가짐 -> 하나의 프로세스 내에서 여러 가지 작업 동시 수행 가능
	 * 2. 스택 메모리 : 각 스레드는 자신만의 스택 메모리를 가지며, 함수 호출과 로컬 변수 저장에 사용함
	 * 3. 힙 메모리 공유 : 스레드들은 같은 프로세스 내에서 실행되므로 해당 프로세스의 힙 메모리를 공유함. 때문에 스레드 간의 데이터 공유가 가능하며, 
	 * 					동시성 제어를 위한 메커니즘이 필요
	 * 
	 * 용도
	 * 1. 동시성 : 다중 스레드를 사용해 여러 작업을 동시에 수행할 수 있음
	 * 2. 리소스 효율성 : 스레드는 프로세스보다 메모리와 리소스 사용량이 적으므로, 스레드를 사용하면 시스템 효율성을 높일 수 있음
	 * 3. 응답성 향상 : 백그라운드 스레드를 사용함으로써 메인 스레드는 사용자와의 상호작용에만 집중하게 할 수 있음
	 * 4. 병렬 처리 : 멀티코어 프로세서 환경에서 멀티 스레딩을 통해 여러 코어에서 동시에 작업을 수행하여 처리 속도 향상
	 * 
	 * 멀티 스레딩 주의점
	 * 1. 컨텍스트 스위칭 오버헤드 : 스레드 간 전환이 잦으면 오버헤드가 누적되어 성능이 저하될 수 있음
	 * 2. 데이터 경쟁과 동기화 : 여러 스레드가 동시에 하나의 공유 리소스에 접근할 때 동기화 필요. deadlock 발생하지 않도록 주의
	 * 3. 프로그래밍 복잡성 : 코드의 복잡성이 증가하여 버그의 가능성이 높아질 수 있고, 디버깅이 어려워질 수 있음
	 */
	
	// 숫자 출력
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
	
	// 숫자 합산
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
				System.out.println(studentName + " 님 " + name + " 과목 등록 성공 (잔여석 : " + remainingSeats + ")");
				
				return true;
			} else {
				System.out.println(studentName + " 님 " + name + " 과목 등록 실패 (인원 초과)");
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
