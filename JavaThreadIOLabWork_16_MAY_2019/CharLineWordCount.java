import java.io.*;
class CharLineWordCount {
	public static void main(String [] args) {

	int count = 0;
	int i = 0, w= 0, charC = 0;
	int c = 0;
	String[] word = new String[]{};

			try {
				File file = new File("quotes.txt");
				String str = "";
				BufferedReader br = new BufferedReader(new FileReader(file));
				BufferedReader fr = new BufferedReader(new FileReader(file));

				while((str = br.readLine()) != null)
				{
					i++;
					word = str.split(" ");
					w += word.length;
				}

				while((charC = fr.read()) != -1)
            	{
                	c++;
            	}
				System.out.println("Lines Count is:- " + i);
				System.out.println("Word Count is:- " + w);
				System.out.println("Character Count is:- " + c);

				br.close();
				br.close();

			}catch(IOException e) {

				System.out.println("Can't read from the file currently..."); 
			}



	}
}
