import * as readline from 'readline';

let valFromRuntime = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

valFromRuntime.question("Enter string to count all vowels repeatition: ",(answer)=>	{

		let a: number = 0;
		let e: number = 0;
		let i: number = 0;
		let o: number = 0;
        let u: number = 0;
        
        for(let i: number=0; i<answer.length; i++)	
        {
            if(answer[i] == 'a' || answer[i] == 'A')	a++;
            
            else if(answer[i] == 'e' || answer[i] == 'E')	e++;
            
            else if(answer[i] == 'i' || answer[i] == 'I')	i++;
            
            else if(answer[i] == 'o' || answer[i] == 'O')	o++;
            
			else if(answer[i] == 'u' || answer[i] == 'U')	u++;
        }
        
            console.log(`

            A is occured ${a} no. of times.

            E is occured ${e} no. of times.

            I is occured ${i} no. of times.

            O is occured ${o} no. of times.

            U is occured ${u} no. of times.

            `);
    valFromRuntime.close();
	}
);
