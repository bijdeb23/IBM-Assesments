import java.util.*;

class SortingByHashMap{
	

		public static void main(String[] args) throws Exception {
			

			HashMap<String , Integer> map = new HashMap<>();
			SortingByHashMap sh = new SortingByHashMap();
			Scanner sc = new Scanner(System.in);

			do{
				System.out.print("Enter the How many Entry you want to add:- ");
				int num = 0;
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
                for(int i = 0; i < num; i++)
                {
                	System.out.print("Enter the Name " +(i+1)+": ");
                	String name = sc.nextLine();
					sc.nextLine();
                	System.out.print("Enter the Roll Number : ");
                	int rollNo = sc.nextInt();

                	map.put( name , rollNo );

                }
				List listOfValues = sh.getValues(map);
			
				Iterator iterate = listOfValues.iterator();

				while(iterate.hasNext()){

					System.out.println("value  " + iterate.next());
				}
			}while(true);
		}

		public static List getValues(HashMap<String , Integer> map){


				Set set = map.entrySet();

				ArrayList  list = new ArrayList();

				for (Object obj : set) {

					Map.Entry mapEntry = (Map.Entry)obj;

					list.add(mapEntry.getValue());
					
				}

				Collections.sort(list);
				return list;
		}

}