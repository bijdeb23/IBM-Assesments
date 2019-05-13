import java.util.*;
public class Prime
{
    public static void main(String args[])
    {
         int s1, flag = 0, i, j;
         Scanner s = new Scanner(System.in);
         System.out.print("Enter the limit : "); 
         s1 = s.nextInt();
         System.out.println ("The prime numbers upto the given limits are :");
         System.out.print("2 ");
         for(i = 2; i <= s1; i++)
         {
             for( j = 2; j < i; j++)
             {
                 if(i % j == 0)
                 {
                     flag = 0;
                     break;
                 }
                 else
                 {
                     flag = 1;
                 }
             }
             if(flag == 1)
             {
                 System.out.print(i + " ");
             }
         }
    }
}