import java.util.*;

class RemoveDuplicate{

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter a String: ");
		String str = sc.nextLine();
		String newStr = "";
		char[] ch = str.toCharArray();

		for(char value : ch)
		{
			
			if(newStr.indexOf(value) == -1)
				newStr += value;
		}

		System.out.println("The New String will be : " +newStr);
	}
}