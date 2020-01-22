package inputandoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pathuse {

	public static void main(String[] args) {
		// 현재 디렉토리에 있는 samo파일을 Path 객체로 만들어보자
		Path path = Paths.get("./samo.gif");
		
		//복사할 파일 경로와 이름을 생성하기
		Path to = Paths.get("./samocopy.gif");
		
		//path에서 to로 복사(copy명령어 대신 create, delete... 이런 원하는 명령어 쓰면 됨
		try {
			Files.copy(path, to); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
