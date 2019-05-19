import java.util.Scanner;

class JobChecking{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Employee UserName: ");
		String userName = sc.nextLine();
		if(userName.endsWith("_job") && (userName.length() >=12))
			System.out.println("This is a Correct Name");
		else
			System.out.println("It can't be validated, Check Your Name");
	}
}