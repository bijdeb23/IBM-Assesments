package CopyDataThread;

import java.io.*;
import java.lang.Runnable;;

class CopyDataThread extends Thread {

	public void run(){

		try {
				BufferedReader br = new BufferedReader(new FileReader(new File("source.txt")));
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File("target.txt")));

				int ch, c = 0;
				String chStr = "";
				while ((ch = br.read()) != -1) {

					if(c != 10)
					{
						chStr += ((Character)((char)ch)).toString();
						c++;
					}
					else
					{
						c=1;
						System.out.println("10 characters copied! [" + chStr + "]");
						Thread.sleep(1000);

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