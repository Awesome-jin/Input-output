package inputandoutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteInputandoutput {

	public static void main(String[] args) {
		
		// try안에서 만든 자원은 close를 호출하지 않아도 무방함
		// 2번째 매개변수가 true가 되면 이어 쓰기를 시작한다
		try(FileOutputStream fos = new FileOutputStream("./src/.dat", true);
				FileInputStream fis = new FileInputStream("./src/.dat") // 파일에서 읽어오기 위한 인스턴스 만들기
				){
			// 기록할 내용 만들기
			String msg = "hi stream";
			// 문자열을 바이트 배열로 만들기
			byte [] b = msg.getBytes();
			// 기록
			fos.write(b);
			fos.flush();
			
			/*
			// 한 번에 다 읽어버리기
			// 읽을 데이터 개수를 가져오기
			int len = fis.available();
			// 읽은 데이터를 저장할 배열 생성
			b = new byte[len];
			
			// 데이터 읽기
			fis.read(b);
			
			// 바이트 배열을 문자열로 변환
			String data = new String (b);
			System.out.println(data);
			*/
			
			// ▲ 용량이 큰 경우 한 번에 읽으면 메모리 부족으로 예외가 생기거나 시간이 오래 걸린다.
			// 나누어서 읽는게 효율적임
			
			// 저장할 배열을 생성하는데 보통 크기는 8의 배수로 생성하는 것이 일반적임
			byte [ ] split = new byte [8];
			while (true) {
				int r = fis.read(split); // split크기 만큼 읽고 읽은 수를 리턴에서 r에 넣는 것.
				// 0보다 작으면 읽은게 없다니까 반복문을 깨면 됨
				if (r <= 0) {
					break;
				}
				// 읽은 데이터가 있으면 처리하자
				String str = new String(split, 0, r); //데이터를 사용할 때 배열을 바로 사용하면 안되고 0부터 읽은 개수만큼 사용해야 함
				// 전체를 사용하는 경우 읽은 개수가 부족하면 이상한 결과를 만들어버린다.
				System.out.println(str);
			}
			
		}
		
		catch(Exception e) {
			System.out.println("예외내용: " + e);
		}

	}

}
