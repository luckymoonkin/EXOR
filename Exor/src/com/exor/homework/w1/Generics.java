package com.exor.homework.w1;

public class Generics<T> {
	/*
	 * Generics : Ŭ����, �������̽�, �޼ҵ带 ������ �� Ÿ���� �Ű������� ����� �� �ֵ��� �ϴ� ���. 
	 * 
	 * �뵵
	 * - Ÿ�� ������ : ������ �� Ÿ�� üũ�Ǿ� �߸��� Ÿ���� ���ų� Ÿ�� ĳ���� ������ ��������
	 * - �ڵ� ���뼺 : �ϳ��� Ŭ������ ���� Ÿ���� ��ü�� ���� �� �ְ�, ������� ��ü�� ����� �� Ÿ�� ĳ������ ������ �� ����
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

