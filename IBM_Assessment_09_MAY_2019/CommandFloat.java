class CommandFloat{

	public static void main(String[] args) {
		float sum = 0;
		

		if(args.length == 1)
		{
			System.out.println("Thw Addition is Not possible");
			
		}
		else
		{
			for(int i = 0; i < args.length; i++)
			{
				sum = sum + Float.parseFloat(args[i]); 
			}
			String num = String.format("%.2f", sum);

			System.out.println("The Addition is: " + num);
		}
	}
}