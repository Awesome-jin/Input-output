package inputandoutput;

import java.io.RandomAccessFile;

public class RandomFileMain {

	public static void main(String[] args) {
		// 파일 입출력의 기본 시작! try(){} catch(){}
		
		try(
				//파일 읽고 쓰기 객체 생성
				RandomAccessFile raf = new RandomAccessFile("C:\\Users\\admin\\Documents/data.txt", "rw"); //경로와 파일 모드를 매개변수로 차례씩 줄 것
				
				){
			
				//중괄호 안에서 기록하고 싶은 내용을 생성
			
			String msg = "hi random access file!";
			raf.write(msg.getBytes());
			
			//데이터를 읽어오자!
			// 파일 포인터를 읽을 위치로 이동
			raf.seek(0);
			
			//5개를 읽어보자
			byte[] b = new byte[5];
			raf.read();
			// 바이트 배열의 문자열로 변환해서 출력
			System.out.println(new String(b));
			
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
