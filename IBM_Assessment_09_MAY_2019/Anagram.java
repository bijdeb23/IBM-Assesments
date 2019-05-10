import java.util.*;

class Anagram{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Phrase 1 : ");
		String str1 = sc.nextLine();
		char ch1[] = str1.toCharArray();
		System.out.print("Enter Phrase 2 : ");
		String str2 = sc.nextLine();
		char ch2[] = str2.toCharArray();

		Arrays.sort(ch1);
		Arrays.toString(ch1);
		Arrays.sort(ch2);
		Arrays.toString(ch2);
		System.out.print(ch1.length);
		System.out.print(ch2.length);

		int count = 0;
		if(ch1.length == ch2.length)
		{
			System.out.print(ch1.length);
			for(int i = 0; i < str1.length(); i++)
			{
				if(ch1[i] == ch2[i])
				{
					count++;
				}
			}
		}

		if(str1.length() == count)
		{
			System.out.println("Phrase1 is Anagram of Phrase2");
		}
		else
		{
			System.out.println("Anagram Methodology is not occured here");
		}

	}
}