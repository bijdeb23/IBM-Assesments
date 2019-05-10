import java.util.*;

class StringChecker{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first String: ");
		String str1 = sc.nextLine();
		System.out.print("Enter the second String: ");
		String str2 = sc.nextLine();

		boolean result = str1.endsWith(str2);
		if(result)
		{
			System.out.println("The First string is ended with the Second String");
		}
		else
		{
			System.out.println("The First string doesn't ended with the Second String");
		}

		
	}
}