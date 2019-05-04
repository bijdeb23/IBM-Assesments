import * as readline from 'readline';

let valFromRuntime = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

function result (num1?: number, num2?: number, num3?: number)	
{

	let result: boolean = true;
    let total: number;
    total = num1 + num2 + num3;

            if(total < 125)	{
                result = false;
            }
            if (num1 < 40)	{
                result = false;
            }
            if (num2 < 40)	{
                result = false;
            }
            if (num3 < 40)	{
                result = false;
            }

    if(result == false)	
    {
		console.log("You are Failed!");
	}
    else	
    {
		console.log("You are Passed!");
	}
}

valFromRuntime.question("Enter 3 numbers : ",(answer) =>	{

		let sub = answer.split(",");
		let sub1 = parseInt(sub[0]);
		let sub2 = parseInt(sub[1]);
		let sub3 = parseInt(sub[2]);

		result(sub1, sub2, sub3);
		valFromRuntime.close();
	
    });
