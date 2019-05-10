import java.util.*;

class GetChar{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String str = sc.nextLine();
		System.out.print("Enter the index of character u want to take out : ");
		int st = sc.nextInt();

		for(int i = 0; i< str.length(); i++)
		{
			if(str.charAt(i) == str.charAt(st))
			{
				System.out.print("The Character is :" + str.charAt(i-1));
			}
		}
	}
}