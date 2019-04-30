package CollectionsExamples;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {
		Set<Integer> set=new HashSet<>();
		set.add(1);
		set.add(5);
		set.add(21);
		set.add(11);
		set.add(2);
		set.add(10);
		set.add(5);
		System.out.println("values from set :"+set);
		
		//treeset
		Set<Integer> tset=new TreeSet<>(set);
		System.out.println("elements in order :"+tset);
		
		//linkedhashset
		
		Set<Integer> lhset=new LinkedHashSet<>(set);
		System.out.println("elements are displaying in same inseted order:"+lhset);
		
		  Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
	        linkedHashSet.add(10);
	        linkedHashSet.add(20);
	        linkedHashSet.add(60);
	        linkedHashSet.add(40);
	        linkedHashSet.add(100);
	 
	        System.out.println("the size of the linkedhashset is : " + linkedHashSet.size());
	 
	        System.out.println("the elements in linkedhashset are :");
	        Iterator<Integer> iterator = linkedHashSet.iterator();
	        while(iterator.hasNext())
	        { 
	            System.out.print(iterator.next() + "\t");
	        }
		
	}

}
