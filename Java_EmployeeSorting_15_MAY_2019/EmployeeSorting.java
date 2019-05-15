class EmployeeDetails{

	private String name,address,fName,lName;
	private Integer id,age; 

	EmployeeDetails(int id, String fName, String lName, int age, String address){

		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.age = age;
		this.address = address;
	}

	public String getName(){
		return this.name;
	}

	public Integer getId(){
		return this.id;
	}

	public Integer getAge(){
		return this.age;
	}

	public String getAddress(){
		return this.address;
	}

	public String getFirstName(){
		return this.fName;
	}

	public String getLastName(){
		return this.lName;
	}

	public String toString(){
		return "Id: " + this.id + " , Age: " + this.age + " , Address: " + this.address + " , First Name: " + this.fName + " , Last Name: " + this.lName;
	}
}

class EmployeeSorting{

	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		java.util.List list = new java.util.ArrayList();
		char ch = ' ';
		do{
			System.out.println("<-----EMPLOYEE DETAILS----->");
			System.out.println("Press '1' for Add Employee Details");
			System.out.println("Press '2' to Search by Employee ID");
			System.out.println("Press '3' to Search by Employee Age");
			System.out.println("Press '4' to Search by Employee Address");
			System.out.println("Press '5' to Search by Employee First Name");
			System.out.println("Press '6' to Search by Employee Last Name");
			System.out.print("Enter Your Choice: ");
			int choice = sc. nextInt();

			switch(choice){
		
			case 1:		System.out.print("\nHow many Employee Details you want to enter? ");
						int amount = sc.nextInt();
						for(int i = 0; i < amount; i++)
						{
							System.out.print("\nEnter your Id: ");
							int id = sc.nextInt();
							sc.nextLine();
							System.out.print("Enter your Name: ");
							String name = sc.nextLine();
							System.out.print("Enter your Age: ");
							int age = sc.nextInt();
							sc.nextLine();
							System.out.print("Enter your Address: ");
							String address = sc.nextLine();
							
							String fName,lName;

							String []arr = name.split(" ");

					        if(arr.length > 1){

					            fName = arr[0];
					            lName = arr[1];
					        }else{

					            fName = name;
					            lName = "";
					        }

							list.add(new EmployeeDetails(id, fName, lName, age, address));
						}
						System.out.println("Data is Successfully Added\n");

						break;

			case 2:		if(list.isEmpty())
						{	
							System.out.println("Employee Database has nothing to show!!!\n");
						}
						else
						{
							java.util.Collections.sort(list, new SortById());
							System.out.println("Employee Details Shorted by ID : " + list);
						}

						break;

			case 3:		if(list.isEmpty())
						{	
							System.out.println("Employee Database has nothing to show!!!\n");
						}
						else
						{
							java.util.Collections.sort(list, new SortByAge());
							System.out.println("Employee Details Shorted by Age : " + list);
						}

						break;

			case 4:		if(list.isEmpty())
						{	
							System.out.println("Employee Database has nothing to show!!!\n");
						
						}
						else
						{
							java.util.Collections.sort(list, new SortByAddress());
							System.out.println("Employee Details Shorted by Address : " + list);
						}

						break;

			case 5:		if(list.isEmpty())
						{	
							System.out.println("Employee Database has nothing to show!!!\n");
						}
						else
						{
							java.util.Collections.sort(list, new SortByFirstName());
							System.out.println("Employee Details Shorted by Address : " + list);
						}

						break;

			default:	System.out.println("You have entered a wrong choice!!\n"); 

			}

			System.out.print("Do you want to continue with this Sorting ?(Press 'y' for 'Yes'/Press any key to exit): ");
			ch = sc.next().charAt(0);
			System.out.println("\n");

		}while(ch == 'y' || ch == 'Y');
	}
}

class SortById implements java.util.Comparator{
	@Override
	public int compare(Object firstObject, Object secondObject){
		return ((EmployeeDetails)firstObject).getId().compareTo(((EmployeeDetails)secondObject).getId());	
	}
}

class SortByAge implements java.util.Comparator{
	@Override
	public int compare(Object firstObject, Object secondObject){
		return ((EmployeeDetails)firstObject).getAge().compareTo(((EmployeeDetails)secondObject).getAge());	
	}
}

class SortByAddress implements java.util.Comparator{
	@Override
	public int compare(Object firstObject, Object secondObject){
		return ((EmployeeDetails)firstObject).getAddress().compareTo(((EmployeeDetails)secondObject).getAddress());	
	}
}

class SortByFirstName implements java.util.Comparator{
	@Override
	public int compare(Object firstObject, Object secondObject){
		return ((EmployeeDetails)firstObject).getFirstName().compareTo(((EmployeeDetails)secondObject).getFirstName());	
	}
}

class SortByLastName implements java.util.Comparator{
	@Override
	public int compare(Object firstObject, Object secondObject){
		return ((EmployeeDetails)firstObject).getLastName().compareTo(((EmployeeDetails)secondObject).getLastName());	
	}
}