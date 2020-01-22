package inputandoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Logreading {

	public static void main(String[] args) {
		
		try(
				BufferedReader br = new BufferedReader(new FileReader("./log.txt"));){
			
			// 한 줄 읽기
			int total = 0;
			
			//접속한 ip를 중복없이 출력 해보자
			HashSet <String> set = new HashSet<String>();
			
			//접속한 ip별 트래픽 합계
			HashMap<String, Integer> map = new HashMap<String, Integer>(); // Map에 없는 key를 사용하면 null이 return되는 점 주의!
			
			while(true) {
				String line = br.readLine();
			//다 읽었으면 스톱 하기
				if(line==null) {
					break;
				}
				//System.out.println(line);   : 라인 단위로 전체 출력
				String [ ] ar = line.split(" "); // 공백을 단위로 잘라낼거야
				//System.out.println(ar[ar.length-1]); ▶마지막 자리 출력: 이건 문자열이기 때문에 Integer.parseInt로 강제 형변환을 해줘야 함
			
				//ip를 가지고 데이터가 있는지 확인
				Integer traffic = map.get(ar[0]);
				// 없는 데이터면 traffic은 0를 주는 것
				if(traffic ==null) {
					traffic = 0;
				}
				try {
					traffic = traffic + Integer.parseInt(ar[ar.length-1]);
				}
				catch(Exception e) {}
				//map에 저장
				map.put(ar[0], traffic);
				// set에 첫번째 항목을 저장
				set.add(ar[0]);
				
				
				//가장 마지막 데이터를 정수로 변환해서 total에 추가
				try {
				total = total + Integer.parseInt(ar[ar.length-1]);
				}
				catch(Exception e) {} //마지막데이터를 parseInt 못하는 경우 try-catch로 감싸버리면 해결 가능하다.
			}
			System.out.println("트래픽합계 :" + total);
			System.out.println("==============================================");
			
			
			
			//set을 출력해보기
			for(String imsip : set) {
				System.out.println(imsip);
			}
			
			
			// Map의 데이터를 전부 출력하기
			System.out.println("==============================================");
			
			Set<String> keys = map.keySet();
			for(String key: keys) {System.out.println(key + ":" + map.get(key));
			}
		}
		
		
		
		catch(Exception e) {
			System.err.println("예외 :" + e.getMessage());
		}

		
	}//END

}
