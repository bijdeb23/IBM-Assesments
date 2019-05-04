import * as readline from 'readline';

let valFromRuntime = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

function hexadecimal(num? : any){

    let q : any = num;

    let r : any = 0;

    let rem : any = 0;

    let hex : any;



    for(let i = q; i>0; i = Math.floor(i/16))
    {
        rem = i % 16;
        if( rem < 10)
            rem = rem + 48;
        else   
            rem = rem +55;
            
            r = (r * 100) + rem;
    }

    console.log(r);
    
    for(let j = r; j>0; j= Math.floor(j / 100))
    {
        hex = j % 100;

        console.log(hex);
        
    }
    // while(q != 0)
    // {
    //     let rem :number = 0;

    //     rem = q % 16;

    //     if(q <10)
    //     { 
    //         hex[i] = rem + 48; 
    //         i++; 
    //     }
    //     else
    //     {   
    //         hex[i] = rem + 55; 
    //         i++;

    //     }

    //     q = Math.floor(q / 16);
    // }

        // for(let j = i; j >= 0; j--)
        // {
        //      console.log("Hexadecimal number is :" + hex[i]);
        // }


}

valFromRuntime.question("Enter a Decimal Number : ",(answer) =>	{

    
    hexadecimal(answer);


    valFromRuntime.close();

});