import java.util.*;

class TrafficLight{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Red Light Press 1 ");
		System.out.println("Yellow Light Press 2 ");
		System.out.println("Green Light Press 3 ");
		System.out.print("Enter the Sequence no. which you want to select:-");
		int ch = sc.nextInt();

		switch(ch){
			case 1 : System.out.println("The Light is Red, Please Stop!!!!");
					 break;

			case 2 : System.out.println("The Light is Yellow, You can be Ready for Start!!!");
					 break;

			case 3 : System.out.println("The Light is Green, You can Go!!!");
					 break;

			default : System.out.println("You have entered Wrong Choice!!");
		}
	}

}