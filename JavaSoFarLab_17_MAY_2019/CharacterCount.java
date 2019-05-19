import java.util.*;
import java.io.*;

class CharacterCount{
	
	public static void main(String[] args) {
		
		do{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the Array: ");
			String string = sc.next();

			char[] chArray = string.toCharArray();

			HashMap<Character,Integer> map = countCharacter(chArray);

			for (Map.Entry  entry : map.entrySet() ) {

				System.out.print( "[ '"+entry.getKey()+"'  "+entry.getValue()+"  ]\n");
			}

		}while(true);

	}

	public static HashMap<Character,Integer> countCharacter(char[] ch){

		HashMap<Character,Integer> countChar = new HashMap<>();

		for (char c : ch) {

			if(countChar.containsKey(c))
			{
				countChar.put(c,countChar.get(c)+1);
			}
			else
			{
				countChar.put(c,1);
			}

		}

		return countChar;
	}

}