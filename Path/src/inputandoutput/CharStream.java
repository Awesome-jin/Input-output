package inputandoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class CharStream {

	public static void main(String[] args) {
		
		try(
				// 파일에 문자 단위로 기록하기 위한 스트림 (절대경로 써보기)
				PrintWriter pw = new PrintWriter("C:\\Users\\admin\\eclipse-workspace/data.txt");
				BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\eclipse-workspace/data.txt"));
				){			
			pw.println("good afternoon");
			pw.println("The day after tomorrow is a national-holiday");
			
			// 한 줄 읽기
			while(true) {
				String line = br.readLine();
			//다 읽었으면 스톱 하기
				if(line==null) {
					break;
				}
				System.out.println(line);
			}
			
		}
		catch(Exception e) {
			System.err.println("예외 발생: " + e.getMessage());
			}

	}//END

}
