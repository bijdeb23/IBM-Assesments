import java.util.Scanner;

class SecondFrequentChar{
	static final int NO_OF_CHARS = 256; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string ");
		String str = sc.nextLine();

		System.out.println("The second most frequent character is: " + new SecondFreqChar().secFreq(str));
	}

	char secFreq(String str){
		int[] count = new int[NO_OF_CHARS]; 
		int first = 0, second = 0; 
        for (int i = 0; i < str.length(); i++) 
            (count[str.charAt(i)])++;

        for (int i = 0; i < NO_OF_CHARS; i++) 
        { 
            
            if (count[i] > count[first]) 
            { 
                second = first; 
                first = i; 
            } 
       
        
            else if (count[i] > count[second] && 
                     count[i] != count[first]) 
                second = i; 
        } 
       
        return (char)second; 
    }  
}