package CollectionsExamples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ArrayListExample {

	public static void main(String[] args) {
		
		ArrayList<Integer> al=new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(1);
		al.add(4);
		al.add(5);
		al.add(6);
		al.add(10,30);
		System.out.println("elements from arraylist:"+al);
		
		Set<Integer> set=new HashSet<Integer>();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		al.addAll(set);
		System.out.println("After adding more elments :"+al);
		
		if(al.contains(40))
		{
			System.out.println("element is there in list");
		}
		else
		{
			System.out.println("element is not present");
		}

		Iterator<Integer> itr=al.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		 List<Integer> list = al.subList(0,5);
	        for (int i = 0; i < list.size(); i++)
	        {
	            System.out.println(list.get(i) + "\t");
	        }
		ListIterator<Integer> litr=al.listIterator();
		while(litr.hasNext())
		{
			System.out.println(litr.next());
		}
		
		if(al.isEmpty())
		{
			System.out.println("arraylist is empty");
		}
		else
		{
			System.out.println("arraylist is not empty");
		}
		
		Object[] array = (Object[])al.toArray();
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + "\t");
        }
	}

}
