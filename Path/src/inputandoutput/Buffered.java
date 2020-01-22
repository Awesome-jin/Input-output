package inputandoutput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Buffered {

	public static void main(String[] args) {
		try(PrintStream ps = new PrintStream(new FileOutputStream("./buffered.dat"));
				//읽고 싶을땐 BufferedStream을 만든다!
				BufferedInputStream bis = new BufferedInputStream(
						new FileInputStream("./buffered.dat"));
				){
			// 기록하기
			ps.println("hello? buffered stream!");
			ps.flush();
			
			//읽기
			int len = bis.available();
			byte [ ] b = new byte[len];
			bis.read(b);
			System.out.println(new String(b));
		}
		catch(Exception e) {
			System.out.println("예외 내용:" + e.getMessage());
		}

	}//END

}
