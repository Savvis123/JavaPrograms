package Java8Features;

import java.util.Arrays;

import java.util.List;

public class LambdaExpressionsExample {
	

	/*
	() -> System.out.println("my name is suresh");*/
	//java 1.8 features are related to funtional programing 
	//java 1.7 features are related to object oriented programing

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Lambda expression is a method without a name,access specifier and return value declaration .
		 * Lambda expressiona are also known as anonymous methods or clousers
		 * 
		 * 
		 * */
		
		List<Integer> values=Arrays.asList(1,2,3,4,5,6);
		
		values.forEach(i-> System.out.println(i));
	

		
	}

}

