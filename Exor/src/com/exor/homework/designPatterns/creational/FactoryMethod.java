package com.exor.homework.designPatterns.creational;

public class FactoryMethod {
	/*
	 * 디자인 패턴
	 * - OOP에서 자주 발생하는 문제들을 해결하기 위해 만들어진 프로토콜
	 * - 설계 단계, 문제 해결, 재사용/관리(기존의 코드 또는 다른 사람이 작성한 코드를 이해하고 수정 및 추가) 등 개발 과정 전반에서 사용
	 * - 개발자 간의 의사소통 수단으로도 기능
	 * 
	 * - 고려해야 할 사항
	 *  1. 문제의 복잡성 : 복잡한 문제를 해결하거나 크고 확장성 높은 시스템을 설계할 때에는 디자인 패턴이 유용하지만, 간단한 스크립트나 작은 프로젝트에서
	 *  				디자인 패턴의 사용은 오버킬이 될 수 있음
	 *  2. 프로젝트의 수명 : 장기적인 유지 보수나 확장성을 고려하는 프로젝트에서는 디자인 패턴을 적용하는 것이 좋지만, 일회성 프로젝트나 프로토타입 개발에서는
	 *  				디자인 패턴 적용을 위한 시간 할애가 비효율적일 수 있음
	 *  3. 팀의 경험 : 팀원들이 디자인 패턴에 익숙하다면 패턴 적용을 통해 코드의 가독성과 유지 보수성을 높일 수 있지만, 그렇지 않다면 오히려 혼란을 줄 수 있음
	 *  4. 적절성 : 모든 문제의 정답이 항상 디자인 패턴은 아닐 수 있음
	 *  
	 *  
	 * - 사용 목적에 따라 3종류로 분류
	 *  1) 생성(Creational) : 객체의 생성과 관련된 패턴. 
	 *  	- 객체의 생성과 조합을 캡슐화하여 어떤 클래스의 객체를 만들지, 어떻게 만들지, 생성된 객체들을 어떻게 조합할지 결정하는 것에 중점을 둠
	 *  	- 객체의 생성을 직접 하지 않고, 다른 객체에게 위임함으로써 시스템의 유연성, 확장성, 유지보수성을 향상시키기 위해 사용
	 *  
	 *  2) 행위(Behavioral) : 객체들 사이의 책임과 커뮤니케이션에 관련된 패턴.
	 *  	- 객체나 클래스 사이의 상호작용, 역할, 책임을 정의하고 명확하게 분리하는 것에 중점을 둠
	 *  	- 하나의 객체로 수행할 수 없는 작업을 여러 객체로 분배하여 결합도를 최소화하고  코드의 유연성과 재사용성을 향상시키기 위해 사용
	 *  
	 *  3) 구조(Structural) : 객체들을 보다 큰 구조로 조합하는 패턴.
	 *  	- 클래스나 객체들을 합쳐 더 큰 구조를 만드는 것에 중점을 둠
	 *  	- 크고 복잡한 시스템을 구축할 때, 그 아래의 작은 서브시스템들을 유기적으로 통합하고 구조화해야 하는데, 구조 패턴을 통해 객체들 사이의 관계를 간결하고
	 *  		유연하게 만들어주고 확장성을 높여줌
	 *  
	 *  
	 *  생성 패턴 - 팩토리 메소드
	 *  - 객체 생성 로직을 한 곳(팩토리)에서 관리하도록 하고, 생성할 객체의 클래스를 국한하지 않음
	 *  - 어떤 클래스가 자신이 생성해야 하는 객체의 클래스를 예측할 수 없을 때 사용
	 *  
	 */
	
}
