package SeleniumEasyJavaPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 
public class CountOfCharsInString {
 
    /**
     * @param inputString
     * @return Map
     * This method will save all char in a Map.
     */
    public Map getCountOfChar(String inputString)
    {     
        Map charDictionary = new HashMap();
        // converting given string in to lower case
        String inoutCharInLowerCase=inputString.toLowerCase();
        // Converting string in to char array
        char[] chrsInString = inoutCharInLowerCase.toCharArray();
        // iterating char array 
        /*
         * Map stores as key and value pairs where key should be unique. 
         * We will consider character as a key. If key does not exists, we will add
         * in to key with value 1. If key exists, we will just increment the value by one.
         */
        for(Character ch:chrsInString){
            if(charDictionary.containsKey(ch)){
            	charDictionary.put(ch, charDictionary.get(ch)+1);
            } else {
            	charDictionary.put(ch, 1);
            }
        }
        return charDictionary;
        
    }
    
    /**
     * @param charCountMap
     * This method will print all characters with number of occurrence in a string.
     * If char is white space, it will be shown as "White space".
     */
    public void printCharWithCount(Map charCountMap)
    {
    	Set keys = charCountMap.keySet();
        for(Character ch:keys)
        {
        	if(ch==' ')
        	{
        		System.out.println("White space" +" = "+charCountMap.get(ch));
        	}
        	else
        	{
        		System.out.println(ch +" = "+charCountMap.get(ch));
        	}
        }
    }
    
    /**
     * @param charCountMap
     * This method can be used to print duplicate characters in a given string. 
     */
    public void printDuplicateCharsWithOccurance(Map charCountMap)
    {
    	System.out.println("Duplicate characters are:");
    	Set keys = charCountMap.keySet();
        for(Character ch:keys)
        {
        	if(!(ch==' '))
        	{
	        	if(charCountMap.get(ch) > 1)
	            {
	                System.out.println(ch);
	            }
        	}
        }
        
    }
     
    public static void main(String a[])
    {
    	Scanner sc= new Scanner(System.in);
    	System.out.println("Please provide a string to get count of characters: ");
    	String inputString= sc.nextLine();
    	CountOfCharsInString object = new CountOfCharsInString();
    	Map map= object.getCountOfChar(inputString);
    	object.printCharWithCount(map);
    	object.printDuplicateCharsWithOccurance(map);
    }
}


