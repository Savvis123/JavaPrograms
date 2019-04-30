package SeleniumEasyJavaPrograms;

import java.util.Scanner;

public class DrawStarTriangleOfGivenRows
{
    // Reusable method to print triangle
    public static void drawtraingle(int row)
    {
        // determining number of spaces to create a Equilateral Triangle.
    	// First star should be printed at nth column of first row
        int NoOfSpaces = row-1;
  
        // outer loop to handle number of rows
  
        for (int rowCounter=0; rowCounter<row; rowCounter++)
        {
        	// We need to print first star at (row)th place and then decrease position by one for next row 
            for (int spaceCounter=0; spaceCounter<NoOfSpaces; spaceCounter++)
            {
                // printing spaces
                System.out.print(" ");
            }
            
            NoOfSpaces = NoOfSpaces - 1;
  
            // No of star is equal to number of row. FOr first row one star, for 2nd row, 2 stars and so on.
            for (int starCounter=0; starCounter<=rowCounter; starCounter++ )
            {
                // printing stars
                System.out.print("* ");
            }
  
            // Moving cursor to next line 
            System.out.println();
        }
    }
     
    // Program execution starts from main method
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for triangle: ");
        int row= sc.nextInt();
        System.out.println("Here you go: ");
        drawtraingle(row);
    }
}