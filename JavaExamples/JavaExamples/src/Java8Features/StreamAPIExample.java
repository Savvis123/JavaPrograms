package Java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIExample {
	
	/*
	 * Collections refers group of objects in memory.
	 * A stream contains objects that are taken from a collection for the purpose of doing some manipulations.
	 * parallel processing 
	 * Filter purpose
	 * when we use stream API then during runtime it creates threads to handle parallel processing
	 * Intermediate methods and terminated methods
	 * once you use stream values then we can't reuse them 
	 * FindFirst is terminated method
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		
		list.parallelStream().forEach(System.out::println);
		
		Stream<Integer> sm=list.stream();
		
		//System.out.println("first number :"+sm.findFirst());
		
		List<Integer> li=sm.filter(i-> i>5).collect(Collectors.toList());
		System.out.println(li);
	}

}
