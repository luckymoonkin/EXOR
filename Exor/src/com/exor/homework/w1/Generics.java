package com.exor.homework.w1;

public class Generics<T> {
	/*
	 * Generics : 클래스, 인터페이스, 메소드를 정의할 때 타입을 매개변수로 사용할 수 있도록 하는 기능. 
	 * 
	 * 용도
	 * - 타입 안정성 : 컴파일 시 타입 체크되어 잘못된 타입을 쓰거나 타입 캐스팅 에러를 방지해줌
	 * - 코드 재사용성 : 하나의 클래스로 여러 타입의 객체를 만들 수 있고, 만들어진 객체를 사용할 때 타입 캐스팅을 생략할 수 있음
	 */
	
	private T item;
	
	public Generics() {
	}
	
	public Generics(T item) {
		this.item = item;
	}
	
	public T getItem() {		
		return item;
	}
	
	public void setItem(T item) {
		this.item = item;
	}
}

