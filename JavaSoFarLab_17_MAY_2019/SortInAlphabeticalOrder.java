import java.util.Scanner;
import java.util.Arrays; 

class SortInAlphabeticalOrder{
	public static void main(String[] args) {

	do{	
		Scanner sc  = new Scanner(System.in);
		System.out.print("\nEnter a Sentence:- ");
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		String[] arr1 = new String[50]; 
		String[] arr2 = new String[50];
		int length = arr.length;
		int half = length/2;
		int j = 0, k = 0;

        Arrays.sort(arr);

		System.out.print("\nThe Converted Sentence is:- ");
		for(int i = 0; i < half; i++)
		{
			arr1[j] = arr[i].toUpperCase();
			System.out.print(arr1[j]+ " ");
			j++;
		}
		for(int l = half; l < length; l++)
		{
			arr2[k] = arr[l].toLowerCase();
			System.out.print(arr2[k]+ " ");
			k++;
		}
	}while(true);
		
	}
}