import java.util.*;

class DifferenceOfSquares{

	public static void main(String[] args) {
		do{
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter The Number till you want to Calculate:- ");
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
			int squareOfSum = 0,sumOfSquares = 0, sum = 0, diff = 0;
			for (int i = 1; i <= num ; i++) {

					sum = sum + i;
					sumOfSquares = sumOfSquares + (i*i);
				}
				squareOfSum = sum * sum;
				diff = sumOfSquares - squareOfSum;

		System.out.println("\nThe Difference is: " + (-diff));
			
		}while(true);
	}
}