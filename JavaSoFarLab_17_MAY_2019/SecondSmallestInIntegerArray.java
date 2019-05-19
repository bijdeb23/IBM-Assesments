import java.util.*;

public class SecondSmallestInIntegerArray{
	public static void main(String[] args) {
			
		do{
			SecondSmallestInIntegerArray ia = new SecondSmallestInIntegerArray();
			ia.getSecondSmallest();
		}while(true);
	}

	public void getSecondSmallest(){

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
		}
		System.out.println("The Given Array is:- " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("The Sorted Array is:- " + Arrays.toString(arr));

		System.out.println("The Second Smallest Number is:- " + arr[1]);
	} 
} 