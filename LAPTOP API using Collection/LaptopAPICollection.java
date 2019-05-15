import java.util.ArrayList;

class Laptop{
	private Integer ramSize, hddSize, id;
	private String brand;

	Laptop(int id, int ramSize, int hddSize, String brand ){
		this.id = id;
		this.ramSize = ramSize;
		this.hddSize = hddSize;
		this.brand = brand;
	}
	//Creating the getters
	public Integer getId(){
		return this.id;
	}

	public Integer getRamSize(){
		return this.ramSize;
	}

	public Integer getHddSize(){
		return this.hddSize;
	}

	public String getBrand(){
		return this.brand;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setRamSize(int ramSize){
		this.ramSize = ramSize;
	}

	public void setHddSize(int hddSize){
		this.hddSize = hddSize;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}
	public String toString(){

		return "ID :"+ this.id + " , Ram of the Laptop :" + this.ramSize + " , Hard Disk size of the Size :" + this.hddSize + " , Brand Name : " + this.brand;
	}
}

class LaptopAPICollection{

	static ArrayList list;
	public static void main(String[] args) {

	list = new ArrayList();
	java.util.Scanner sc = new java.util.Scanner(System.in);
	char ch2 = ' ';
		

		do{
				LaptopAPICollection ud = new LaptopAPICollection();
				System.out.println("<---Configure a new Laptop--->");
				System.out.println("Press '1' for Add a new Laptop");
				System.out.println("Press '2' to View All Laptop Details");
				System.out.println("Press '3' Search for a Laptop");
				System.out.println("Press '4' Delete a Laptop Details");
				System.out.println("Press '5' Update a Laptop Details");
				System.out.print("Enter Your Choice: ");
				int choice = sc.nextInt();

						switch(choice)
						{

							case 1 :	ud.addLaptop();

										break ;

							case 2  :   ud.viewAllLaptopDetails();

										break;

							case 3	:	ud.searchLaptop();

										break;

							case 4 :    ud.removeLaptop();

										break;

							case 5 : 	ud.updateLaptopDetails();
										
										break;

							default :	System.out.println("You have entered a wrong choice, Please check it Again!!");


									 	

						}

				System.out.print("Do you want to continue with this API ?(Press 'y' for 'Yes'/Press any key to exit): ");
				ch2 = sc.next().charAt(0);
				System.out.println("\n");


		}while(ch2 == 'y' || ch == 'Y');
	}

	public void addLaptop(){

		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("\nHow many Laptop you want to enter? ");
		int amount = sc.nextInt();
		for(int i = 0; i < amount; i++)
		{
			System.out.print("\nEnter the Index of Laptop:- ");
			int id = sc.nextInt();
			System.out.print("Enter the RAM Size:- ");
			int rsize = sc.nextInt();
			System.out.print("Enter the Hard Disk Size:- ");
			int hddsize = sc.nextInt();
			System.out.print("Enter the Brand Name:- ");
			String brand = sc.next();
			System.out.println("\n");


			list.add(new Laptop(id, rsize, hddsize, brand));

		}
		System.out.println("Data is Successfully Added");
	}

	public void viewAllLaptopDetails(){

		if(list.isEmpty())
		{
			System.out.println("There is nothing to show");
		}
		else
		{	
			System.out.println("\nThe Laptop Details Are :- \n");
			for (Object l : list ) {
				
				System.out.println(l);
			}
			
		}			
	}

	public void searchLaptop(){

		char ch3 = ' ';
		java.util.Scanner sc = new java.util.Scanner(System.in);
		LaptopAPICollection ud = new LaptopAPICollection();

		do{
				System.out.println("\nPress '1' to Search by ID");
				System.out.println("Press '2' to Search by Brand");
				System.out.println("Press '3' to Search by Ram Size");
				System.out.println("Press '4' to Search by Hdd Size");
				System.out.print("Enter Your Choice: ");
				int choice2 = sc.nextInt();
				switch(choice2)
				{
					case 1:	System.out.print("\nEnter the ID of the Laptop: ");
							int lp = sc.nextInt();
							for(Object val : list)
							{
								if(((Laptop)val).getId().equals(lp))
									System.out.println(val + "\n");
							}

							break ;

					case 2: System.out.print("\nEnter the Brand of the Laptop: ");
							String str = sc.next();
							for(Object val1 : list)
							{
								if(((Laptop)val1).getBrand().equals(str))
									System.out.println(val1 + "\n");
							}

							break ;

					case 3: System.out.print("\nEnter the Ram Size of the Laptop: ");
							int str1 = sc.nextInt();
							for(Object val2 : list)
							{
								if(((Laptop)val2).getRamSize().equals(str1))
									System.out.println(val2 + "\n");
							}

							break ;

					case 4: System.out.print("\nEnter the Hard Disk of the Laptop: ");
							int str2 = sc.nextInt();
							for(Object val3 : list)
							{
								if(((Laptop)val3).getHddSize().equals(str2))
									System.out.println(val3 + "\n");
							}

							break ;

					default : System.out.println("You have entered a wrong choice, Please check it Again!!\n");
				}
			do{
				System.out.print("Do you want to continue with searching?(y/n): ");
				ch3 = sc.next().charAt(0);
				System.out.println("\n");
				if(ch3 == 'y' || ch == 'Y')
				{

				}
				else
				{
					System.out.println("You haven't enter the right keyword\n");
				}
			}while(ch3 != 'y' || ch3 != 'Y');
		}while(ch3 == 'y' || ch3 == 'Y');
	}

	public void removeLaptop(){

		java.util.Scanner sc = new java.util.Scanner(System.in);
		LaptopAPICollection ud = new LaptopAPICollection();
		System.out.print("\nDo you want to remove a Laptop Details ? (y/n) : ");
	    char rm = sc.next().charAt(0);
	    int check = 0;
	    if(rm == 'y' || rm == 'Y')
	    {
	    	do{
			 	System.out.print("\nEnter the Laptop ID you want to remove: ");
			 	int rmId = sc.nextInt();
			 	int index = 0;
			 	if(list.isEmpty())
			 	{	
					System.out.println("Laptop Database is Empty");
					check = 1;

				}
				else
				{
					for(Object val4 : list)
					{	
						if(((Laptop)val4).getId().equals(rmId))
						{
							index = list.indexOf(val4);
							list.remove(index);

							System.out.println("Laptop Details Successfully Deleted\n");
							check = 0;
							break;
						}
						else
						{
							System.out.println("Check the Laptop Id Again!!\n");
							check = 1;
						}
									
					}
						
						
				}
			}while(check == 1);

		}
		else
		{
			System.out.println("You have to press correct keyword!!");
			ud.removeLaptop();
		}
	}

	public void updateLaptopDetails(){

		char ch4 = ' ';
		java.util.Scanner sc = new java.util.Scanner(System.in);
		LaptopAPICollection ud = new LaptopAPICollection();
		System.out.print("Enter the Laptop ID which You want to Update:-");
		int lpId = sc.nextInt();
		Object newRef = null;
		for (Object ref : list ) {
			
			if(((Laptop)ref).getId().equals(lpId))
			{
				newRef = ref;
				do{
					System.out.println("\nPress '1' to Update ID");
					System.out.println("Press '2' to Update Brand");
					System.out.println("Press '3' to Update Ram Size");
					System.out.println("Press '4' to Update Hdd Size");
					System.out.print("Enter Your Choice: ");
					int choice3 = sc.nextInt();
					switch(choice3)
					{
						case 1:	System.out.print("\nEnter the New ID you want to Update: ");
								int new1 = sc.nextInt();
								for(Object ref2 : list)
								{
									if(((Laptop)ref2).getId().equals(new1))
									{
										System.out.println("Current ID is same as Old ID");
									}
									else
									{
										((Laptop)newRef).setId(new1);
										System.out.println("Data is Successfully Updated");
									}

								}

								break ;

						case 2: System.out.print("\nEnter the New Brand you want to Update: ");
								String new2 = sc.next();
								
									((Laptop)newRef).setBrand(new2);
								System.out.println("Data is Successfully Updated");

								break ;

						case 3: System.out.print("\nEnter the New Ram Size you want to Update: ");
								int new3 = sc.nextInt();
								
									((Laptop)newRef).setRamSize(new3);
								System.out.println("Data is Successfully Updated");

								break ;

						case 4: System.out.print("\nEnter the New Hard Disk Size you want to Update: ");
								int new4 = sc.nextInt();
								
									((Laptop)newRef).setHddSize(new4);
								System.out.println("Data is Successfully Updated");

								break ;

						default : System.out.println("You have entered a wrong choice, Please check it Again!!");
					}
					System.out.print("Do you want to continue with updating?(Press 'y' for 'Yes'/Press any key to exit): ");
					ch4 = sc.next().charAt(0);
					System.out.println("\n");
				}while(ch4 == 'y' || ch4 == 'Y');
			}
			else
			{
				System.out.println("Laptop ID is not present in the Laptop Details, Check it again!!\n");
				ud.updateLaptopDetails();

			}
		}
	}
}




