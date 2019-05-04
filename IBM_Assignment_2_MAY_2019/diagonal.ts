let mat1 : any[3][3] = [[1,2,3],[4,5,6],[7,8,9]];

function upperdiagonal(mat1 : any)
{
    for (let i = 0; i <= 3; i++)
    {
        for (let j = 0; j <= 3; j++)
        { 
                if((i+j)<=2)
                {
                    console.log(mat1[i][j] + " ");
                }
               
        }
        
        console.log(" ");
            
    } 
}
upperdiagonal(mat1);