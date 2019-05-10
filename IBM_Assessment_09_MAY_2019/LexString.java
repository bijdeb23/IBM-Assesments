import java.util.*;

class LexString{

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter First String: ");
		String str = sc.nextLine();
		System.out.print("Enter Second String: ");
		String st = sc.nextLine();

		int result = str.compareToIgnoreCase(st);

		if(result < 0)
		{
			System.out.print("1st String is less than 2nd String");
		}
		else if(result == 0)
		{
			System.out.println("2 Strings are Same");
		}
		else
		{
			System.out.println("1st String is greater than 2nd String");
		}
	}
}