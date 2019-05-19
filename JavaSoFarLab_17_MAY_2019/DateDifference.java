import java.time.*;  
import java.util.*;
import java.io.*;

class DateDifference{

	public static void main(String[] args) throws Exception {
        do{
        		Scanner sc = new Scanner(System.in);
        		System.out.print("Enter the date in 'dd/MM/yyyy' format: ");
        		String dateStr = sc.nextLine();
        		StringTokenizer st = new StringTokenizer(dateStr,"/");
                int[] arr = new int[5];
        		int i = 0;
        		while (st.hasMoreTokens()) {
                    String newStr = st.nextToken();
                    if(i<3)
                    {
        	            arr[i] = Integer.parseInt(newStr);
        	            i++;
                	}
                }
                Period gap = Period.between(LocalDate.of(arr[2] , arr[1] , arr[0]), LocalDate.now());

                System.out.println("Difference of Days are: " + gap.getDays());
                System.out.println("Difference of Months are: " + gap.getMonths());
                System.out.println("Difference of Years are: " + gap.getYears());
        }while(true);

	}
}