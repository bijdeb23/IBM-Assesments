import java.util.*;

public class ReverseNumberToSort{

	public static void main(String[] args) {
			
		do{
			ReverseNumberToSort rns = new ReverseNumberToSort();
			rns.getSorted();

			
		}while(true);
	}

	public void getSorted(){

			Scanner sc = new Scanner(System.in);
			System.out.print("\nEnter how many nos. you want to insert?:- ");
			int num = 0 ;
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
			int[] arr = new int[num];
			int[] rev = new int[num];
			int revNum = 0;
			for(int i = 0; i < num; i++)
			{
				System.out.print("Enter the Number " + (i+1) + ": ");
				while (true) {
			        try {
			            	arr[i] = sc.nextInt();
			            	
			            break;
			        }
			        catch (InputMismatchException e) {

			        	System.out.print("Please Give the Correct Input: ");
			            sc.next();
			    	}
				}
				int integer = arr[i];
				while(integer != 0 )
				{
					revNum = (revNum * 10) + (integer % 10);
					integer = integer / 10;
				}

				rev[i] = revNum;
				revNum = 0;
			}
			Arrays.sort(rev);

			System.out.println("The Sorted Array is:- " + Arrays.toString(rev));
		}
	} 