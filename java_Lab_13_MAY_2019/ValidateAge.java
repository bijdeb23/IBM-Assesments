import java.util.*;

class ValidateAge{
	public static void main(String[] args) throws MyException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an Age : ");
		int age = sc.nextInt();	

		if(age>15)
		{
			System.out.println("You have entered a Correct Age");
		}
		else
		{
			throw new MyException("You have to enter the age above 15");
		}
	}
}

class MyException extends Exception{

	MyException(String str){
        super(str);
    }
}