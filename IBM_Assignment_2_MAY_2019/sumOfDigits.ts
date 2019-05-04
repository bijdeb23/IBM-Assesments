import * as readline from 'readline';

var val : any;



let valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  valFromRuntime.question('Enter a Number : ', (val) => {
    let num: any = parseInt(val);
    let sum: number = 0;

    while(num != 0)
    {
        sum = sum + (num % 10);
        num = Math.floor(num / 10);
    }

    console.log("The Addition of Digits of the given No. is : " + sum);
    
    valFromRuntime.close();
  });