package Java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class consumerexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> values=Arrays.asList(4,5,6,7,8);
		
		Consumer<Integer> c= i -> System.out.println(i);
	    values.forEach(c);
	}

}
