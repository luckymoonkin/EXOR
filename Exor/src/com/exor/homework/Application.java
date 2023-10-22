package com.exor.homework;

import java.util.Scanner;

import com.exor.homework.w1.Generics;
import com.exor.homework.w1.Inherit;
import com.exor.homework.w1.SingletonUtil;
import com.exor.homework.w1.ThreadExamples;
import com.exor.homework.w1.ThreadExamples.Course;

public class Application {

	public static void main(String[] args) {
//		// Ŭ���� vs �ν��Ͻ�
//		Runtime runtime = Runtime.getRuntime();
//		
//		long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
//		System.out.println("��ü ���� �� �޸� ��뷮 : " + beforeMemory);
//		
//		for (int i = 0; i < 1000000; i++) {
//			Object obj = new Object();
//		}
//		
//		long afterMemory = runtime.totalMemory() - runtime.freeMemory();
//		System.out.println("��ü ���� �� �޸� ��뷮 : " + afterMemory);
		
//		// ���
//		Inherit inherit = new Inherit();
//		Inherit.TV tv1 = inherit.new TV("������ �÷��� QT115", "LG����", 4000000);
//		
//		tv1.turnOn();
//		tv1.volumeUp();
//		
//		// ���׸���
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
		
		// �̱���
//		SingletonUtil util = SingletonUtil.getInstance();
//		util.printInput();
		
		// ������
		ThreadExamples te = new ThreadExamples();
		
		// ������ - ��� + �ջ��ϱ�
//		Scanner sc = new Scanner(System.in);
//		int number = Integer.valueOf(sc.nextLine());
//		
//		Thread printNumbers = new Thread(te.new PrintNumbers(number));
//		Thread sumUp = new Thread(te.new SumUp(number));
//		
//		printNumbers.start();
//		sumUp.start();
		
		// ������ - ���� ��û
		Course physics = te.new Course("������", 3);
		
		Thread student1 = new Thread(te.new Registration(physics, "���Ϲ�"));
		Thread student2 = new Thread(te.new Registration(physics, "���̹�"));
		Thread student3 = new Thread(te.new Registration(physics, "����"));
		Thread student4 = new Thread(te.new Registration(physics, "����"));
		
		student1.start();
		student2.start();
		student3.start();
		student4.start();
		
	}

}
