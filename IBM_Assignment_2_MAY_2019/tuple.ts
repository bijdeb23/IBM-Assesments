import * as readline from 'readline';

let valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });


let employee: [string , string][] = [["23", "Bijoy"], ["56", "Smith"], ["98", "Suresh"]];


valFromRuntime.question('Enter a Number : ', (val : string) => {

    for (var i in employee) {
        
        if (employee[i][0] == val)
         {
            console.log("Number found: " + employee[i]);
            break;
            
        }
            
    }
    if(employee[i][0] != val)
        console.log("Value Not Matched");



    valFromRuntime.close();

});