import java.util.*;

class SubString{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String str = sc.nextLine();
		System.out.print("Hoow many arguments u want to pass to the SubString 1 or 2: ");
		int select = sc.nextInt();
		char[] ch = str.toCharArray();

		StringClass scl = new StringClass();

		if(select == 1)
		{
			scl.substring1(str);
		}
		else if(select == 2)
		{
			scl.substring2(str);
		}
		else
			System.out.println("You have entered a wrong choice");

	}
}

class StringClass{

	Scanner sc = new Scanner(System.in);

	void substring1(String s){

			System.out.print("Enter the Index from where you want to print: ");
			int index = sc.nextInt();
			for(int i =index-1; i < s.length(); i++)
			{
				System.out.print(s.charAt(i));
			}
	}

	void substring2(String s){

			System.out.println("Enter the Start Index and End Index you waant to print: ");
			int index1 = sc.nextInt();
			int index2 = sc.nextInt();

			for(int i = index1-1; i <= index2; i++)
			{
				System.out.print(s.charAt(i));
			}
	}
}