import java.util.*;
import java.io.*;
class Split{
	public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter any String :");
			String n = sc.nextLine();
			System.out.println("Enter the character where you want to split :");
			String c = sc.nextLine();
			for(int i = 0; i< n.length(); i++)
			{
					if(String.valueOf(n.charAt(i)) == c)
					{
					  n = n.replace(String.valueOf(n.charAt(i)),"\n");
			}
		}
			System.out.println("The Name is:\n" +n);
	}
}
