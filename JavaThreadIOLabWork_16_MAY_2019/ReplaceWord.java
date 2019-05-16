import java.io.*;
import java.util.Scanner;

class ReplaceWord{
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str4 = "";
		String str5 = "";
		System.out.print("Enter the File Name in which you want to replace :");
		String str1 = scan.nextLine();

		System.out.print("Enter the word needs replacement: ");
		String str2 = scan.nextLine();

		System.out.print("Enter the word for replacement: ");
		String str3 = scan.nextLine();


		try	{
			File file = new File(str1);
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((str5 = br.readLine()) != null)	{
				str5 = str5.replaceAll(str2, str3);
				str4 += str5 + "\n";
			}

			br.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));


			bw.write(str4);
			bw.flush();
			bw.close();
			System.out.println("The Word is Replaced");
		}
		catch(IOException ie)	{
			System.out.println("Can't read from the file currently...");
		}
	}
}