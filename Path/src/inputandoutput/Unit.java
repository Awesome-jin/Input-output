package inputandoutput;

import java.io.Serializable;

public class Unit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;
	private String name;
	private int offence;
	private int defence;
	private int level;
	
	//매개변수가 없는 생성자 - 기본데이터가 제공되지 않을 때 사용
	public Unit() {
		super();
	}

	
	//모든 속성을 매개변수로 받아서 생성해주는 생성자
	// 기본 데이터가 제공될 때 사용 - 테스트 할 때 좋음
	public Unit(int num, String name, int offence, int defence, int level) {
		super();
		this.num = num;
		this.name = name;
		this.offence = offence;
		this.defence = defence;
		this.level = level;
	}


	// 접근자 메소드
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getOffence() {
		return offence;
	}


	public void setOffence(int offence) {
		this.offence = offence;
	}


	public int getDefence() {
		return defence;
	}


	public void setDefence(int defence) {
		this.defence = defence;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
		offence = offence + level*10;
	}


	// 모든 속성성의 값을 하나의 문자열로 만들어서 리턴해주는 메소드
	// 출력하는 메소드의 인스턴스 이름을 대입하면 이 메소드가 호출됨
	// 모든 객체 지향 언어는 이 방식을 이용해서 출력함
	// 메소드 이름이 다를 뿐임
	@Override
	public String toString() {
		return "Unit [num=" + num + ", name=" + name + ", offence=" + offence + ", defence=" + defence + ", level="
				+ level + "]";
	}

}//END
