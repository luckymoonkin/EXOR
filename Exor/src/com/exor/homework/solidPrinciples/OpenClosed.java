package com.exor.homework.solidPrinciples;

public class OpenClosed {
	/*
	 * Open-Closed principle
	 * : ����Ʈ������ ���� ��Ҵ� ���濡�� �����(closed)�̰�, Ȯ�忡�� ������(open)�̾�� �Ѵ�.
	 * 
	 * - visualization) ���ٵ� wii
	 * 	���ٵ� wii = �ܼ� + ������
	 * 	�پ��� �߰� �Ǽ��縮(zapper, steering wheel, ..)
	 * 	> �߰� �Ǽ��縮�� ������ �� �ܼ��� �����ϴ� ���� �������� ��ȭ�� ���� �ʿ� ����, �������� ����⸸ �ϸ� ��
	 * 
	 * ����Ʈ������� OCP�� �ǹ�
	 * - closed for modification : ���� ��ҿ� ���ο� ���� �߰��� �� ������ �ڵ带 ������ �ʿ䰡 ����� ��
	 * - open for extension : ���� ��ҿ� ���ο� Ư��, �Ӽ� ���� �߰��� �� �ֵ��� Ȯ�强�� �־�� ��
	 * 
	 * ����
	 * 	1) Ȯ�强
	 * 	2) ��������� ����/�׽�Ʈ ��� ����
	 * 	3) OCP�� �����ٺ��� ���յ��� ���ߴ� �������� ���� �Ǵ� ������ �ִ�. 
	 * 		-> SRP�� ��Ű�� ��(SOLID ��Ģ���� ���� �����ϰ� �����ְ� ��ȣ �������̸�, ���յǾ� ����� �� �� ȿ������)
	 * 
	 * ������
	 * 	1) ���������� OCP�� �������ٰ� ��û�� ������ Ŭ������ ������ �ʵ��� ����
	 *  2) ���׸� ��ĥ �� OCP�� ������ð� ������ �ڵ� ����(modification) ��� �������� �����ϴ� ���� �׻� ������ �ƴ� �� ����
	 *  3) 1, 2������ �� �� �ֵ��� OCP�� ������ �ټ� �ְ����� �κ��� ����
	 */
	
//	// �ǰ� ���� ȸ�� - ��� ������ ���� ����
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
//		// ������ �ڵ忡 �ڵ��� ���迡 ���� ���� �߰��ؾ� ��(modification)
//		public int calculatePremiumDiscountPercent(VehicleInsuranceCustomerProfile customer) {
//			if(customer.isLoyalCustomer()) {
//				return 20;
//			}
//			return 0;
//		}
//	}
//	
//	// ȸ�簡 ����� Ȯ���� �ڵ��� ���赵 ������
//	public class VehicleInsuranceCustomerProfile{
//		public boolean isLoyalCustomer() {
//			return true;
//		}
//	}
	
	// ��� Ȯ���� �߰��� �̷����ٸ�..? 
	// -> �Ź� ������ �ڵ带 �����ؾ� �� = OCP ����
	// -> CustomerProfile �������̽��� ����� isLoyal() �޼ҵ� ���� ��, �ǰ�, �ڵ���, ���� ���� �� ���� ����ϵ��� ������. 
	// ���� �߰��� ��� Ȯ���� �־ ���� �ڵ� ������ �ʿ� ���� �� Ŭ���� ���� �� CustomerProfile ��ӹ����� �� = OCP! 
	
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
