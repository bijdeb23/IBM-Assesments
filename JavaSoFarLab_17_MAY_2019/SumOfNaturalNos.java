import java.util.*;

public class SumOfNaturalNos{
	public static void main(String[] args) {
			
		do{
			SumOfNaturalNos sn = new SumOfNaturalNos();
			sn.calculateSum();
			
		}while(true);
	}

	public void calculateSum(){

			Scanner sc = new Scanner(System.in);
			System.out.print("\nEnter the Last No. till you want to show the Divisibility:- ");
			int num = 0;
			while (true) {
		        try {
		            	num = sc.nextInt();
		            	
		            break;
		        }
		        catch (InputMismatchException e) {

		        	System.out.print("Please Give the Correct Input: ");
		            sc.next();
				}
			}
			int sum = 0;
			for(int i = 1; i <= num; i++)
			{
				if(((i % 3) == 0) || ((i % 5) == 0))
				{
					sum = sum + i;
				}
			}
			
			System.out.println("The Sum of the numbers which are divisible by 3 or 5 is:- " + sum);
	}
}