import java.util.*;

class InitialName{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your Name:- ");
		String name = sc.nextLine();

		name = name.toUpperCase();

		System.out.print(name.charAt(0));
		for(int i = 0; i < name.length(); i++)
		{
			if(name.charAt(i) == ' ')
				System.out.print(" " + name.charAt(i+1));
		}


	}
}