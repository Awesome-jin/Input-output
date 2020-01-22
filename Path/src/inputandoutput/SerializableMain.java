package inputandoutput;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableMain {

	public static void main(String[] args) {
		
		Unit unit = new Unit(1, "탱크", 10, 10, 0);
		System.out.println(unit);
		unit.setLevel(1);
		System.out.println(unit);
		
		//파일 입출력을 할거면 일단 try catch부터!
		
		// byte나 char이 아닌 데이터를 읽고 쓸때는 ObjectOutputStream,ObjectInputStream을 이용해야 한다.
		try(ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("./star.dat"));
				
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream("./star.dat"));	 //읽어오는 stream을 만들어주면 해결된다.
				){ 
			//데이터기록 : unit의 클래스인 unit이 Serializable 인터페이스를 구현하지 않았다면
			//classcastexception이 발생 - 형 변환이 안돼!
			/*oos.writeObject(unit);
			
			Unit unit1 = new Unit(2, "마린", 5, 5, 0);
			oos.writeObject(unit1);
			
			// 데이터 읽어올때는 자기 클래스 써주고 형변환을 해서 읽어온다.
			Unit unit2 = (Unit)ois.readObject();
			System.out.println(unit1); //InputStream과 이 방법을 쓰지 않으면 이 파일 내용은 깨져보임.
			*/
			
			Unit unit1 = new Unit(2, "마린", 5, 5, 0);
			ArrayList<Unit> list = new ArrayList<Unit>();
			list.add(unit);
			list.add(unit1);
			oos.writeObject(list); // 유닛을 여럿 계속 추가하려면 주석처리된 위 코드론 너무 쌩노가다다. >> 리스트로 처리

			
			// List로 저장한 데이터 읽어오기
			ArrayList<Unit> read = (ArrayList<Unit>)ois.readObject();
			for(Unit u : read) {
				System.out.println(u);
			}
			
		}
		catch(Exception e) {
			System.err.println("예외:" + e.getMessage());
		}

	}

}
