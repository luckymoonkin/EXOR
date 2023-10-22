package com.exor.homework.w1;

public class Inherit {
	/*
	 * 상속
	 * 
	 * 목적 : 클래스 재사용. 연관성이 있는 클래스들에 대한 공통 규약 정의
	 * 
	 * 장점 : 코드량 감소. 공통으로 관리되므로 코드의 추가/변경 용이. 코드의 중복 제거로 생산성과 유지보수 용이성 상승
	 * 
	 * 1) 단일 상속(extends)
	 * 	- java에서 자식 클래스는 하나의 상위 클래스만 상속 받을 수 있음
	 * 	- 여러 대상의 공통 속성을 정의 후 이를 상속하여 표현
	 * 
	 * 2) 다중 상속(implements)
	 * 	- java에서 직접 다중 상속은 지원하지 않으므로 인터페이스를 통해 간접 구현
	 * 	- 각 하위 대상의 속성/기능을 표현하는 데에 적합
	 * 
	 * 
	 * cf. 추상 클래스 vs 인터페이스
	 * 추상 클래스 : 공통 기능의 기본 구현이 필요할 떄, 또는 서로 관련된 클래스들의 공통된 로직/데이터를 모아두고 싶을 때
	 * 인터페이스 : 여러 클래스에서 공통적으로 사용되는 기능을 정의할 때, 또는 다중 상속이 필요할 때. (인터페이스는 참조 용도로 내부에서의 구현은 없음)
	 */
	
	// 전자제품의 공통 특성
	public class Product{
		public String name;
		public String brandName;
		public int price;
		
		public void turnOn() {
			System.out.println(name + " 전원을 켭니다.");
		}
		public void turnOff() {
			System.out.println(name + " 전원을 끕니다.");
		}
	}
	
	// 화면on/off 기능
	public interface ControlDisplay{
		void displayOn();
		void displayOff();
	}
	
	// 온도 조절 기능
	public interface AdjustTemperature{
		void tempUp();
		void tempDown();
	}
	
	// 볼륨 조절 기능
	public interface AdjustVolume{
		void volumeUp();
		void volumeDown();
	}
	
	// TV는 전자제품이며 화면on/off, 볼륨 조절 기능이 있다.
	public class TV extends Product implements ControlDisplay, AdjustVolume{

		public TV() {}
		
		public TV(String name, String brandName, int price) {		
			this.name = name;
			this.brandName = brandName;
			this.price = price;
		}

		@Override
		public void volumeUp() {
			System.out.println(name + " 볼륨을 올립니다.");
		}

		@Override
		public void volumeDown() {
			System.out.println(name + " 볼륨을 내립니다.");
		}

		@Override
		public void displayOn() {	
			System.out.println(name + " 화면을 켭니다.");
		}

		@Override
		public void displayOff() {
			System.out.println(name + " 화면을 끕니다.");
		}
		
	}
}
