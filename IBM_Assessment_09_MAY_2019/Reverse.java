import java.util.*;
class Reverse{
	public static void main(String args[])  
   {  
      String original, reverse = "";   
      Scanner n = new Scanner(System.in);   
      System.out.print("Enter a string to check if it is a palindrome : ");  
      original = n.nextLine();   
      int length = original.length();   
      for ( int i = length - 1; i >= 0; i-- )  
         reverse = reverse + original.charAt(i);
      System.out.println("The Reverse string: " + reverse);
	}
}