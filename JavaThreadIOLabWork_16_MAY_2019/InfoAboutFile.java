import java.io.*;
import java.util.Scanner;

class InfoAboutFile {
public static void main(String [] args){
int size = 0;
int i = 0;
// try {

	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the File Name:- ");
	String fileName = sc.nextLine();

	File file = new File(fileName); 

	System.out.println("Existence of File : " +file.exists());
    
    if(file.exists() == true)
    {
	    System.out.println("Is writeable: " +file.canWrite()); 
	    System.out.println("Is readable: " +file.canRead()); 
	    System.out.println("File Size in bytes: " +file.length()+ " bytes"); 
	    System.out.println("Extension of the File: " + getFileExtension(file)); 
    } 
    else
    {
    	System.out.println("File Not Exists!!!"); 	
    }

   

}
private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
