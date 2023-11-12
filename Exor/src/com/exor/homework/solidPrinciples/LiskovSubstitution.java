package com.exor.homework.solidPrinciples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiskovSubstitution {
	/*
	 * Liskov Substitution principle
	 * : �θ� Ÿ���� ���Ǵ� ��� ������ ���α׷��� ������ ����Ű�� �ʰ� �ڽ� Ÿ������ ��ü�� �� �־�� �Ѵ�.
	 */
	
	/*
	 * ��Ӱ� 'Is-A' ��� ���
	 * 	1) ���̽�ī is a �ڵ���
	 * 	2) Ÿ�� is a ��
	 * 	3) ���ָ� is a ����
	 * 	-> 2�� ���ÿ��� Ÿ���� ���� ������, ��κ��� ���� �� �� �ִ� ���� �ɷ��� ����.
	 * 	-> �ٸ� �� �ν��Ͻ����� Ÿ���� ��ü�� �� ����(fly() �޼ҵ� ȣ�� �� ���� �߻�)
	 * 
	 * => LSP�� 'Is-A' �׽�Ʈ���� �����ϴ�.
	 */
	public class Bird {
		public void fly() {}
	}
	
	public class Ostrich extends Bird{
		@Override
		public void fly() {
			// �� �� �����Ƿ� �������� ���� -> �������� �ʴ� �޼ҵ�� ���� ������ ������ ������ �ǹ��Ѵ�.
			throw new RuntimeException();
		}
	}
	
	// �ַ�� 1. ���� �ı�(Breaking Hierarchy)
//	public class Car {
//		// ���� ����(cabin) �ʺ�
//		public double getCabinWidth() {
//			return 0;
//		}
//	}
	
//	public class RacingCar extends Car {
//		@Override
//		public double getCabinWidth() {
//			// ���̽�ī���� cabin�� �����Ƿ� �������� ����
//		}
//		
//		// ���̽�ī�� cabin ��� cockpit�� ����
//		public double getCockpitWidth() {
//			return 0;
//		}
//	}
	
	// Car �ν��Ͻ� ��� �� RacingCar ��ü�� getCabinWidth() �޼ҵ带 ����ϴ� ���� ���� �߻��� ��.
	// -> RacingCar�� Car�� ��� ���踦 ���߸���, �� ����� ����� �θ�� ����� �� �ִ� ������ ã�� ���ο� Ŭ���� ���� �� �̸� ����ϵ��� ������.
	public class Vehicle{
		// ���� ����(interior) �ʺ�
		public double getInteriorWidth() {
			return 0;
		}
	}
	
	public class Car extends Vehicle {
		@Override
		public double getInteriorWidth() {
			return this.getCabinWidth();
		}
		
		// ���� ����(cabin) �ʺ�
		public double getCabinWidth() {
			return 0;
		}		
	}
	
	public class RacingCar extends Vehicle {
		@Override
		public double getInteriorWidth() {
			return this.getCockpitWidth();
		}
		
		// ���̽�ī�� cabin ��� cockpit�� ����
		public double getCockpitWidth() {
			return 0;
		}
	}
	
	// �ַ�� 2. Tell, don't ask
	// �ڻ� �귣�带 ���� ���� ���� �ǸŻ簡 ������ �ϴµ�, �ڻ� �귣�� ��ǰ�� �������� 1.5��� ��
	public class Product {
		protected double discount;
		
		public double getDiscount() {
			return discount;
		}
	}
	
//	public class InHouseProduct extends Product {
//		// �ڻ� �귣�� ������ 1.5�� ����
//		public void applyExtraDiscount() {
//			discount = discount * 1.5;
//		}
//	}
	
	public class PricingUtils {
		// ��ǰ�� ������ ���
		public void pricingUtils(List<Product> productList) {
			for (Product product : productList) {
				// �ڻ� �귣�� ��ǰ���� Ȯ���Ͽ� ������ ����
				if(product instanceof InHouseProduct) {
					((InHouseProduct) product).applyExtraDiscount();
				}
				System.out.println(product.getDiscount());
			}
		}
	}
	
	// Product ��ü�� ����Ͽ� ������ ������ ������ InHouseProduct ��ü���� Ȯ��(ASK) �۾� �ʿ� = bad code..
	// -> InHouseProduct Ŭ���� ���ο��� getDiscount() �޼ҵ带 �������̵��ϸ鼭, �� �ȿ��� applyExtraDiscount() �޼ҵ带 ȣ���ϵ��� ������(TELL)
	// => PricingUtils Ŭ�������� Product ��ü�� ����� ��, subtype Ȯ�� �۾� ���� �׳� ����ϸ� ��
	public class InHouseProduct extends Product {
		@Override
		public double getDiscount() {
			this.applyExtraDiscount();
			return discount;
		}
		
		// �ڻ� �귣�� ������ 1.5�� ����
		public void applyExtraDiscount() {
			discount = discount * 1.5;
		}
	}

}
