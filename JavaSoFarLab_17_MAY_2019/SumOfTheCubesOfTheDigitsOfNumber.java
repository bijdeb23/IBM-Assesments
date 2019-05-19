import java.util.*;

class SumOfTheCubesOfTheDigitsOfNumber{

	public static void main(String[] args) {
		do{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a Number:- ");
			int n1 = 0;
			while (true) {
		        try {
		            	n1 = sc.nextInt();
		            	
		            break;
		        }
		        catch (InputMismatchException e) {

		        	System.out.print("Please Give the Correct Input: ");
		            sc.next();
		    	}
		    }
			int r = 0,s = 0;
			if(n1 > 0)
			{ 
				while(n1 != 0){
					r = n1 % 10;
					s = s + (r*r*r);
					n1 = n1 / 10;
				}

				System.out.println("The Sum of the Cube of the DIgits of the given Number is:- " + s + "\n");
			}
			else
			{
				System.out.println("Kindly check the Number!!");
			}
		}while(true);
	}
}