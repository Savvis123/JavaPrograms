package Java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class consumerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> values=Arrays.asList(5,6,7,8,9);
		
		Consumer<Integer> c=new Consumer<Integer>()
				{
			        public void accept(Integer i) {
						System.out.println(i);
						
					}
			     };

				values.forEach(c);
	}

}
