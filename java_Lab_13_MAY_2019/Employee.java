import java.util.Scanner;
import com.cg.eis.exception.EmployeeException;

class Employee{

	public static void main(String[] args) throws EmployeeException{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Salary : ");
		int salary = sc.nextInt();

		if(salary>3000)
		{
			System.out.println("The Salary is greater than 3000");
		}
		else
		{
			throw new EmployeeException("The Salary is lesser than 3000, kindly check the details");
		}
	}
}