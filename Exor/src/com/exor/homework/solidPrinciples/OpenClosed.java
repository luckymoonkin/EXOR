package com.exor.homework.solidPrinciples;

public class OpenClosed {
	/*
	 * Open-Closed principle
	 * : 소프트웨어의 구성 요소는 변경에는 폐쇄적(closed)이고, 확장에는 개방적(open)이어야 한다.
	 * 
	 * - visualization) 닌텐도 wii
	 * 	닌텐도 wii = 콘솔 + 리모컨
	 * 	다양한 추가 악세사리(zapper, steering wheel, ..)
	 * 	> 추가 악세사리를 적용할 때 콘솔을 분해하는 등의 직접적인 변화를 가할 필요 없이, 리모컨을 끼우기만 하면 됨
	 * 
	 * 소프트웨어에서의 OCP의 의미
	 * - closed for modification : 구성 요소에 새로운 것이 추가될 때 기존의 코드를 수정할 필요가 없어야 함
	 * - open for extension : 구성 요소에 새로운 특성, 속성 등을 추가할 수 있도록 확장성이 있어야 함
	 * 
	 * 장점
	 * 	1) 확장성
	 * 	2) 장기적으로 개발/테스트 비용 절감
	 * 	3) OCP를 따르다보면 결합도를 낮추는 방향으로 가게 되는 경향이 있다. 
	 * 		-> SRP도 지키게 됨(SOLID 원칙들은 서로 밀접하게 얽혀있고 상호 의존적이며, 결합되어 적용될 때 더 효과적임)
	 * 
	 * 주의점
	 * 	1) 무지성으로 OCP를 따르려다가 엄청난 숫자의 클래스를 만들어내지 않도록 주의
	 *  2) 버그를 고칠 때 OCP를 따른답시고 무조건 코드 수정(modification) 대신 디자인을 변경하는 것이 항상 정답은 아닐 수 있음
	 *  3) 1, 2번에서 알 수 있듯이 OCP의 적용은 다소 주관적인 부분이 있음
	 */
	
//	// 건강 보험 회사 - 우수 고객에게 할인 제공
//	public class HealthInsuranceCustomerProfile{
//		public boolean isLoyalCustomer() {
//			return true;
//		}
//	}
//	
//	public class InsurancePremiumDiscountCalculator{
//		public int calculatePremiumDiscountPercent(HealthInsuranceCustomerProfile customer) {
//			if(customer.isLoyalCustomer()) {
//				return 20;
//			}
//			return 0;
//		}
//		
//		// 기존의 코드에 자동차 보험에 관한 로직 추가해야 함(modification)
//		public int calculatePremiumDiscountPercent(VehicleInsuranceCustomerProfile customer) {
//			if(customer.isLoyalCustomer()) {
//				return 20;
//			}
//			return 0;
//		}
//	}
//	
//	// 회사가 사업을 확장해 자동차 보험도 시작함
//	public class VehicleInsuranceCustomerProfile{
//		public boolean isLoyalCustomer() {
//			return true;
//		}
//	}
	
	// 사업 확장이 추가로 이뤄진다면..? 
	// -> 매번 기존의 코드를 수정해야 함 = OCP 위반
	// -> CustomerProfile 인터페이스를 만들고 isLoyal() 메소드 정의 후, 건강, 자동차, 자택 보험 고객 등이 상속하도록 만들자. 
	// 이후 추가로 사업 확장이 있어도 기존 코드 수정할 필요 없이 새 클래스 만든 후 CustomerProfile 상속받으면 됨 = OCP! 
	
	public interface CustomerProfile {
		public boolean isLoyalCustomer();
	}
	
	public class HealthInsuranceCustomerProfile implements CustomerProfile{
		@Override
		public boolean isLoyalCustomer() {
			return true;
		}
	}
	
	public class VehicleInsuranceCustomerProfile implements CustomerProfile{
		@Override
		public boolean isLoyalCustomer() {
			return true;
		}
	}
	
	public class HomeInsuranceCustomerProfile implements CustomerProfile{
		@Override
		public boolean isLoyalCustomer() {
			return true;
		}
	}
	
	public class InsurancePremiumDiscountCalculator{
		public int calculatePremiumDiscountPercent(CustomerProfile customer) {
			if(customer.isLoyalCustomer()) {
				return 20;
			}
			return 0;
		}
	}
}
