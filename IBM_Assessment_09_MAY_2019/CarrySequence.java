import java.util.*;

public class CarrySequence {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The String: ");
        String str1 = sc.nextLine();
        System.out.print("Enter The Specified sequence of char values: ");
        String str2 = sc.nextLine();
        System.out.println("Original String: " + str1);
        System.out.println("Specified sequence of char values: " + str2);

        System.out.println("The Result is : " + str1.contains(str2));
    }
}