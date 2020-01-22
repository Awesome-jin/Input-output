package inputandoutput;

import java.io.File;
import java.util.Date;

public class Fileinfo {

	public static void main(String[] args) {
		
		// 절대 경로를 이용해서 파일 인스턴스 만들기
		//File f = new File("C:\\Users\\admin\\Downloads\\samo.gif");  // 절대경로 File() 생성자를 이용한 방법
		// 상대경로를 쓸거면 워킹 디렉토리에 위의 이미지를 넣고 아래 같이 작성해주면 된다
		File f = new File("./samo.gif");
		
		// 파일의 존재 여부를 확인하는 메소드 .exist (넘어오는 건 boolean)
		boolean ie = f.exists();
		System.out.println(ie);
		
		//파일의 마지막 수정시간 확인해보기. 메소드 = lastModified(); - long으로 넘어옴
		long moditime = f.lastModified();
		//System.out.println("마지막 수정시간: "+ f); >> 우리가 사용하는 시간의 형태로 리턴해주질 않았음!
		
		// 수정시간을 우리가 사용하는 시간으로 변경하려면 date를 이용하면 됨
		Date date = new Date(moditime); // Date생성자의 매개변수로 위에서 생성한 객체를 넣어주면 된다.
		System.out.println("마지막 수정시간: " + date);
		
		//파일의 크기 확인 - 업데이트때나 다운로드 여부 판정하는데 이용 (업데이트 파일이 이전 파일보다 크다 작다 이런 알고리즘으로 판별)
		long filesize = f.length(); // 메소드는 length. 리턴타입은 long
		System.out.println("파일의 크기는 : " + filesize);
		
	}

}
