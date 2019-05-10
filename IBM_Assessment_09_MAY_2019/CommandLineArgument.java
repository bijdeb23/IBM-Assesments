class CommandLineArgument{

	public static void main(String[] args) {
		int sum = 0;
		

		if(args.length == 1)
		{
			System.out.println("Thw Addition is Not possible");
			
		}
		else
		{
			for(int i = 0; i < args.length; i++)
			{
				sum = sum + Integer.parseInt(args[i]); 
			}

			System.out.println("The Addition is: " + sum);
		}
	}
}