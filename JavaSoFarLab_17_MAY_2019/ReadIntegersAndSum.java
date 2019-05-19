import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadIntegersAndSum{

	public static void main(String[] args) {
		
		do{		
					boolean c = true;
					ReadIntegersAndSum rs = new ReadIntegersAndSum();
					rs.operation(c);

		}while(true);

	}

	public boolean operation(boolean b){

		int n = 0, sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the numbers separates by Commas: ");
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str,",");
		System.out.print("The Numbers are:- ");
		while (st.hasMoreTokens()) {
            String newStr = st.nextToken();
            n = Integer.parseInt(newStr);
			System.out.print(n + ", ");
            sum = sum + n;
        }
        System.out.println("\nSum of the integers is: " + sum);

        return false;

	}
}