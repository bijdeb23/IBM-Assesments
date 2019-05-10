import java.util.*;

class ReplacingCharacter{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String str = sc.nextLine();
		String result = "";

		System.out.print("After Replacing the String will be: ");
		for(int i =0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			if(ch == 'r')
			{
				result = str.replace('r','t');
			}
			else if(ch == 'R')
			{
				ch = 'T' ;
				result = str.replace('R','T');
			}

			
		}

		System.out.print(result);


	}
}