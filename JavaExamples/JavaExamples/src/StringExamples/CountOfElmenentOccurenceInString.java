package StringExamples;

import java.util.HashMap;
import java.util.Map;

public class CountOfElmenentOccurenceInString {

	 public static void main(final String[] args) {
	        final CountOfElmenentOccurenceInString d = new CountOfElmenentOccurenceInString();
	        final String name = "aaabbcccdddaaaa";
	        System.out.println(d.countNoOfInteger(name));
	    }

	    public String countNoOfInteger(final String str) {
	        if (str.equals(null)) {
	            throw new IllegalArgumentException();
	        }
	        if (str.isEmpty()) {
	            return "";
	        }

	        final Map<Character, Integer> map = new HashMap<>();
	        int count = 0;
	        final char[] charArray = str.trim().toCharArray();

	        for (final char element : charArray) {
	            if (map.get(element) != null) {
	                count = map.get(element);
	                map.put(element, ++count);
	            } else {
	                count = 0;
	                map.put(element, ++count);
	            }
	        }

	        int total;
	        char ch;
	        final Map<Character, Boolean> visited = new HashMap<>();
	        final StringBuilder sb = new StringBuilder();
	        for (final char element : charArray) {
	            if ((visited.get(element) == null)) {
	                ch = element;
	               // System.out.println("charact is :"+ch);
	                //sb.append(ch);
	                total = map.get(element);
	                
	                System.out.println("charact is:"+ch +";"+"count of character is :"+total);
	                //sb.append(total);
	                visited.put(element, true);
	            }
	        }
	        return sb.toString();
	    }

}
