package copyThread;

import java.io.*;
import java.lang.Runnable;;

public class CopyDataThread extends Thread {
	BufferedReader br;
	BufferedWriter bw;

	public CopyDataThread(BufferedReader br, BufferedWriter bw)
	{
		this.br = br;
		this.bw = bw;
	}

	@Override
	public void run(){

		try {
				int ch, c = 1;
				String chStr = "";
				while ((ch = br.read()) != -1) {

					if(c != 10)
					{
						chStr += ((Character)((char)ch)).toString();
						c++;
					}
					else
					{	
						c = 1;
						System.out.println("10 characters copied! [" + chStr + "]");
						Thread.sleep(5000);

						bw.write(chStr);
						chStr = ((Character)((char)ch)).toString();
					}
				}
				bw.write(chStr);
				bw.flush();
				bw.close();
				br.close();

		} catch(IOException | InterruptedException e) {
					System.out.println("Can't read from the file currently..."); 
		}
	}
}