import java.util.*;


class PowerOfTwo{
  public static void main(String args[]) {

    String again;

    do{

        PowerOfTwo pt = new PowerOfTwo();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = 0 ;
        while (true) {
                try {
                      num = sc.nextInt();
                      
                    break;
                }
                catch (InputMismatchException e) {

                  System.out.print("Please Give the Correct Input: ");
                  sc.next();
            }
        }

        boolean checker = pt.checkNumber(num);

        if(checker == true)
        {
            System.out.println("It is power of two");
        }
        else
        {
             System.out.println("It is not a power of two ");
        }

    }while(true);

  }

  public boolean checkNumber(int num){

          
      while(num > 1){

        if(num % 2 != 0)
        {
          return false;
        }

        num = num / 2;
      }
      return true;

}

}
