package com.exor.homework.solidPrinciples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiskovSubstitution {
	/*
	 * Liskov Substitution principle
	 * : 부모 타입이 사용되는 모든 곳에서 프로그램에 오류를 일으키지 않고 자식 타입으로 대체할 수 있어야 한다.
	 */
	
	/*
	 * 상속과 'Is-A' 사고 방식
	 * 	1) 레이싱카 is a 자동차
	 * 	2) 타조 is a 새
	 * 	3) 가솔린 is a 연료
	 * 	-> 2번 예시에서 타조는 새가 맞지만, 대부분의 새가 할 수 있는 비행 능력이 없다.
	 * 	-> 다른 새 인스턴스들을 타조로 대체할 수 없음(fly() 메소드 호출 시 오류 발생)
	 * 
	 * => LSP가 'Is-A' 테스트보다 엄격하다.
	 */
	public class Bird {
		public void fly() {}
	}
	
	public class Ostrich extends Bird{
		@Override
		public void fly() {
			// 날 수 없으므로 구현하지 않음 -> 구현되지 않는 메소드는 거의 언제나 디자인 오류를 의미한다.
			throw new RuntimeException();
		}
	}
	
	// 솔루션 1. 계층 파괴(Breaking Hierarchy)
//	public class Car {
//		// 차량 내부(cabin) 너비
//		public double getCabinWidth() {
//			return 0;
//		}
//	}
	
//	public class RacingCar extends Car {
//		@Override
//		public double getCabinWidth() {
//			// 레이싱카에는 cabin이 없으므로 구현하지 않음
//		}
//		
//		// 레이싱카는 cabin 대신 cockpit이 있음
//		public double getCockpitWidth() {
//			return 0;
//		}
//	}
	
	// Car 인스턴스 사용 중 RacingCar 객체로 getCabinWidth() 메소드를 사용하는 순간 오류 발생할 것.
	// -> RacingCar와 Car의 상속 관계를 깨뜨리고, 둘 모두의 공통된 부모로 사용할 수 있는 개념을 찾아 새로운 클래스 생성 후 이를 상속하도록 만들자.
	public class Vehicle{
		// 차량 내부(interior) 너비
		public double getInteriorWidth() {
			return 0;
		}
	}
	
	public class Car extends Vehicle {
		@Override
		public double getInteriorWidth() {
			return this.getCabinWidth();
		}
		
		// 차량 내부(cabin) 너비
		public double getCabinWidth() {
			return 0;
		}		
	}
	
	public class RacingCar extends Vehicle {
		@Override
		public double getInteriorWidth() {
			return this.getCockpitWidth();
		}
		
		// 레이싱카는 cabin 대신 cockpit이 있음
		public double getCockpitWidth() {
			return 0;
		}
	}
	
	// 솔루션 2. Tell, don't ask
	// 자사 브랜드를 가진 대형 유통 판매사가 할인을 하는데, 자사 브랜드 상품은 할인율이 1.5배로 들어감
	public class Product {
		protected double discount;
		
		public double getDiscount() {
			return discount;
		}
	}
	
//	public class InHouseProduct extends Product {
//		// 자사 브랜드 할인율 1.5배 적용
//		public void applyExtraDiscount() {
//			discount = discount * 1.5;
//		}
//	}
	
	public class PricingUtils {
		// 상품의 할인율 출력
		public void pricingUtils(List<Product> productList) {
			for (Product product : productList) {
				// 자사 브랜드 상품인지 확인하여 할인율 적용
				if(product instanceof InHouseProduct) {
					((InHouseProduct) product).applyExtraDiscount();
				}
				System.out.println(product.getDiscount());
			}
		}
	}
	
	// Product 객체를 사용하여 할인율 가져올 때마다 InHouseProduct 객체인지 확인(ASK) 작업 필요 = bad code..
	// -> InHouseProduct 클래스 내부에서 getDiscount() 메소드를 오버라이딩하면서, 그 안에서 applyExtraDiscount() 메소드를 호출하도록 만들자(TELL)
	// => PricingUtils 클래스에서 Product 객체를 사용할 때, subtype 확인 작업 없이 그냥 사용하면 됨
	public class InHouseProduct extends Product {
		@Override
		public double getDiscount() {
			this.applyExtraDiscount();
			return discount;
		}
		
		// 자사 브랜드 할인율 1.5배 적용
		public void applyExtraDiscount() {
			discount = discount * 1.5;
		}
	}

}
