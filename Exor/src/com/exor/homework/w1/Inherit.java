package com.exor.homework.w1;

public class Inherit {
	/*
	 * ���
	 * 
	 * ���� : Ŭ���� ����. �������� �ִ� Ŭ�����鿡 ���� ���� �Ծ� ����
	 * 
	 * ���� : �ڵ差 ����. �������� �����ǹǷ� �ڵ��� �߰�/���� ����. �ڵ��� �ߺ� ���ŷ� ���꼺�� �������� ���̼� ���
	 * 
	 * 1) ���� ���(extends)
	 * 	- java���� �ڽ� Ŭ������ �ϳ��� ���� Ŭ������ ��� ���� �� ����
	 * 	- ���� ����� ���� �Ӽ��� ���� �� �̸� ����Ͽ� ǥ��
	 * 
	 * 2) ���� ���(implements)
	 * 	- java���� ���� ���� ����� �������� �����Ƿ� �������̽��� ���� ���� ����
	 * 	- �� ���� ����� �Ӽ�/����� ǥ���ϴ� ���� ����
	 * 
	 * 
	 * cf. �߻� Ŭ���� vs �������̽�
	 * �߻� Ŭ���� : ���� ����� �⺻ ������ �ʿ��� ��, �Ǵ� ���� ���õ� Ŭ�������� ����� ����/�����͸� ��Ƶΰ� ���� ��
	 * �������̽� : ���� Ŭ�������� ���������� ���Ǵ� ����� ������ ��, �Ǵ� ���� ����� �ʿ��� ��. (�������̽��� ���� �뵵�� ���ο����� ������ ����)
	 */
	
	// ������ǰ�� ���� Ư��
	public class Product{
		public String name;
		public String brandName;
		public int price;
		
		public void turnOn() {
			System.out.println(name + " ������ �մϴ�.");
		}
		public void turnOff() {
			System.out.println(name + " ������ ���ϴ�.");
		}
	}
	
	// ȭ��on/off ���
	public interface ControlDisplay{
		void displayOn();
		void displayOff();
	}
	
	// �µ� ���� ���
	public interface AdjustTemperature{
		void tempUp();
		void tempDown();
	}
	
	// ���� ���� ���
	public interface AdjustVolume{
		void volumeUp();
		void volumeDown();
	}
	
	// TV�� ������ǰ�̸� ȭ��on/off, ���� ���� ����� �ִ�.
	public class TV extends Product implements ControlDisplay, AdjustVolume{

		public TV() {}
		
		public TV(String name, String brandName, int price) {		
			this.name = name;
			this.brandName = brandName;
			this.price = price;
		}

		@Override
		public void volumeUp() {
			System.out.println(name + " ������ �ø��ϴ�.");
		}

		@Override
		public void volumeDown() {
			System.out.println(name + " ������ �����ϴ�.");
		}

		@Override
		public void displayOn() {	
			System.out.println(name + " ȭ���� �մϴ�.");
		}

		@Override
		public void displayOff() {
			System.out.println(name + " ȭ���� ���ϴ�.");
		}
		
	}
}
