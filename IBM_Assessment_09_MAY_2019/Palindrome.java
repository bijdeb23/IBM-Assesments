import java.util.*;

class Palindrome{  
   public static void main(String args[])  
   {  
      String original, reverse = "";   
      Scanner n = new Scanner(System.in);   
      System.out.println("Enter a string to check if it is a palindrome");  
      original = n.nextLine();   
      int length = original.length();   
      for ( int i = length - 1; i >= 0; i-- )  
         reverse = reverse + original.charAt(i);  
      if (original.equals(reverse))  
         System.out.println("The String is a palindrome.");  
      else  
         System.out.println("Th String is not a palindrome.");   
   }  
}  