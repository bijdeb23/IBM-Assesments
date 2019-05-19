import java.util.*;
  
public class IncreasingInteger{  
      
    public static void main(String args[]) 
    { 
        do{
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter a Number: ");
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
                    if (integerChecker(num))  
                       System.out.println("It is in Increasing Order");  
                    else
                        System.out.println("It is in not in Increasing Order"); 
        }while(true);

   } 

    static boolean integerChecker(int n)  
    { 
        int c;
        String s = new Integer(n).toString();
        char[] ch = s.toCharArray(); 
        char[] newCh = s.toCharArray(); 
        Arrays.sort(newCh);  

        for (c = 0; c < s.length(); c++) 
        { 
            if (newCh[c] != s.charAt(c))   
                return false;  
        }
                
        return true;      
    } 
} 