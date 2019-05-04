import * as readline from 'readline';

var val : any;



let valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

  function factorial(val:any) {
    
    let fact : any = 1;
    while(val){

        fact = fact * val;
        val--;


    }


    console.log("The Factorial of the Number is : " + fact);
    

}
  
  valFromRuntime.question('Enter a Number : ', (val) => {
    
        factorial(val);
   
    valFromRuntime.close();
  });