import java.util.Scanner;


public class ValidateName
{
  public static void main (String[] args) throws MyException{	

    Scanner sc = new Scanner(System.in);	
    System.out.print("Enter the First name :- ");
    String name = sc.nextLine();
    System.out.print("Enter the lastName :- ");
    String lastName = sc.nextLine();

    if(name.equals("") || lastName.equals(""))
    {
      throw new MyException("\n Please Enter all details");
    }
    else
    {
      System.out.println("\n Successfull registeration");
    }
  }
}

class MyException extends Exception{

  MyException(String str){
    super(str);
  }

}