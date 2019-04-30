package SeleniumEasyJavaPrograms;

import java.util.Scanner;



public class ExtractNumbersFromString {

 public static void main(String[] args) {
 
 int sum=0;
 // Reading input from user
 Scanner sc= new Scanner(System.in);
 System.out.println("Please enter the alphanumeric string:");
 String inputByUser= sc.nextLine();
 
 
 System.out.println("String entered by user: "+inputByUser);
 
 // Check if input string is alphanumeric Using regex
 
 boolean flagRegex= inputByUser.matches("([A-Za-z]+[0-9]|[0-9]+[A-Za-z])[A-Za-z0-9]*");
 
 
 // if string is alphanumeric, extract char and check if it is digit
 if(flagRegex == true)
 {
 for(int i=0;i<inputByUser.length();i++)
 {
 char c= inputByUser.charAt(i);
 if(Character.isDigit(c))
 sum=sum+ Character.getNumericValue(c);
 
 }
 System.out.println("Sum of numbers found in "+inputByUser +" :"+sum);
 }
 else
 {
 System.out.println(inputByUser+" is not an alphanumeric.");
 }
 
 
 
 
 }
}