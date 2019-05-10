import java.util.*;

class FirstNonRepeatingChar{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String : ");
		String s = sc.nextLine();
		char[] ch = s.toCharArray();
      	for (char c : ch) {
          if (s.indexOf(c) == s.lastIndexOf(c)) 
          {
              System.out.println("First non repeated characted in String is:" + c);
              break;
          }
      }
	}
}