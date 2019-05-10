import java.util.*;

class CountVowels{

	public static void main(String[] args) {
		
		int vowels = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Sentence:- ");
		String input = sc.nextLine();

		input = input.toLowerCase();
		for(int i =0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			if(ch == 'a' || ch == 'e' || ch == 'i' ||
				ch == 'o' || ch == 'u')
			{
				vowels++;
			}
		}

		System.out.println("The No. of vowels in the sentence is :- " + vowels);
	}
}