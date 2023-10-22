package com.exor.homework;

import java.util.Scanner;

import com.exor.homework.w1.Generics;
import com.exor.homework.w1.Inherit;
import com.exor.homework.w1.SingletonUtil;
import com.exor.homework.w1.ThreadExamples;
import com.exor.homework.w1.ThreadExamples.Course;

public class Application {

	public static void main(String[] args) {
//		// 클래스 vs 인스턴스
//		Runtime runtime = Runtime.getRuntime();
//		
//		long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
//		System.out.println("객체 생성 전 메모리 사용량 : " + beforeMemory);
//		
//		for (int i = 0; i < 1000000; i++) {
//			Object obj = new Object();
//		}
//		
//		long afterMemory = runtime.totalMemory() - runtime.freeMemory();
//		System.out.println("객체 생성 후 메모리 사용량 : " + afterMemory);
		
//		// 상속
//		Inherit inherit = new Inherit();
//		Inherit.TV tv1 = inherit.new TV("오브제 컬렉션 QT115", "LG전자", 4000000);
//		
//		tv1.turnOn();
//		tv1.volumeUp();
//		
//		// 제네릭스
//		Generics<String> strBox = new Generics<>();
//		strBox.setItem("String!");
//		System.out.println(strBox.getItem());
//		
//		Generics<Integer> intBox = new Generics<>();
//		intBox.setItem(123);
//		System.out.println(intBox.getItem());	
//		
//		Generics<Inherit.Product> productBox = new Generics<>();
//		productBox.setItem(tv1);
//		productBox.getItem().turnOff();
		
		// 싱글턴
//		SingletonUtil util = SingletonUtil.getInstance();
//		util.printInput();
		
		// 스레드
		ThreadExamples te = new ThreadExamples();
		
		// 스레드 - 출력 + 합산하기
//		Scanner sc = new Scanner(System.in);
//		int number = Integer.valueOf(sc.nextLine());
//		
//		Thread printNumbers = new Thread(te.new PrintNumbers(number));
//		Thread sumUp = new Thread(te.new SumUp(number));
//		
//		printNumbers.start();
//		sumUp.start();
		
		// 스레드 - 수강 신청
		Course physics = te.new Course("물리학", 3);
		
		Thread student1 = new Thread(te.new Registration(physics, "김일번"));
		Thread student2 = new Thread(te.new Registration(physics, "김이번"));
		Thread student3 = new Thread(te.new Registration(physics, "김삼번"));
		Thread student4 = new Thread(te.new Registration(physics, "김사번"));
		
		student1.start();
		student2.start();
		student3.start();
		student4.start();
		
	}

}
