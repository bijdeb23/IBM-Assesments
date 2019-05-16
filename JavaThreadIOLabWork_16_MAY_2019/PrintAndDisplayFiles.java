import java.io.*;
class PrintAndDisplayFiles {
public static void main(String [] args) {
int size = 0;
int i = 0;
try {
	File file = new File("quotes.txt");
	String str = "";
	BufferedReader br = new BufferedReader(new FileReader(file));

	System.out.println("\nThe Motivational Quotes of Life:- \n");
	while((str = br.readLine()) != null)
	{
		System.out.println((i+1) + ". " + str);
		i++;
	}

	br.close();

}catch(IOException e) {System.out.println("Can't read from the file currently..."); }

}
}
