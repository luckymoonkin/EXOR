package com.exor.homework.w1;

import java.util.Scanner;

public class SingletonUtil{
	/*
	 * Singleton Design Pattern : 프로세스 내에서 특정 클래스의 인스턴스가 하나만 존재하도록 하고, 이 하나의 인스턴스를
	 * 								다른 모든 클래스에서 공유하여 사용하는 디자인 패턴
	 * 
	 * 사용하는 이유
	 * - 제한된 인스턴스 생성 -> 특정 클래스의 인스턴스가 딱 하나만 필요할 떄
	 * - 자원 공유 -> 여러 부분에서 공유되는 리소스나 설정 정보에 대해 중앙 집중화된 접근이 필요할 때
	 * - 메모리 절약 -> 동일한 객체를 여러번 생성하지 않음
	 * - 전역 상태 관리 -> 전역 상태나 데이터 관리에 용이
	 * 
	 * 싱글턴 패턴이 적합한 사용 예시
	 * 1. 설정 관리 : 애플리케이션의 설정 정보를 중앙에서 관리
	 * 2. 풀링 : 데이터베이스 연결 풀링과 같이 제한된 리소스를 관리/공유
	 * 3. 로깅 : 전체 시스템에서 로깅을 처리하는데 사용할 로거 객체를 중앙에서 관리
	 * 4. 캐싱 : 중앙에서 캐시 관리
	 * 5. 하드웨어 인터페이스 접근 : 특정 하드웨어 장치에 대한 단일 인터페이스 접근 포인트가 필요
	 * 
	 * 한줄요약 = 하나의 인스턴스만 필요하거나, 공유되는 리소스에 대한 중앙 집중화된 접근이 필요할 때.
	 * 
	 * 구현 조건
	 * 1) 생성자는 private(해당 클래스에서만 인스턴스 생성이 가능해야 함)
	 * 2) 생성된 인스턴스를 리턴해주는 public 메소드
	 * 3) 인스턴스 타입은 private static 
	 * 
	 */
	private static SingletonUtil instance = new SingletonUtil();
	
	private SingletonUtil() {}
	
	public static SingletonUtil getInstance() {
		return instance;
	}
	
	private Scanner sc = new Scanner(System.in);
	
	public void printInput() {		
		System.out.println(sc.nextLine());
	}
	
}