import copyThread.CopyDataThread;
import java.io.*;


class  FileProgram{

	public static void main(String[] args) {

		try{

					
			BufferedReader br = new BufferedReader(new FileReader(new File("source.txt")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("target.txt")));

			CopyDataThread cd = new CopyDataThread(br,bw);
			Thread th = new Thread(cd);
			th.start();

		}catch(IOException ioe){

			ioe.printStackTrace();
		}	

		}
}