import java.util.Arrays; 
import java.util.Scanner; 
import java.lang.Exception;
  
public class StringChecker{  
      
    public static void main(String args[]) 
    { 
        do{
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter a String: ");
                String str = sc.nextLine();   
                    if (positiveCheck(str))  
                       System.out.println("The given String is Positive: True");  
                    else
                        System.out.println("The given String is Positive: False"); 
        }while(true);

   } 

    static boolean positiveCheck(String s)  
    { 
        int c;
        char ch[] = s.toCharArray(); 
        Arrays.sort(ch);  

        for (c = 0; c < s.length(); c++) 
        { 
            if (ch[c] != s.charAt(c))   
                return false;  
        }
                
        return true;      
    } 
} 