package Java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ConsImpl implements Consumer<Integer>{

	public void accept(Integer i) {
		
		System.out.println(i);
	}
}

public class DemoForEach
{
	public static void main(String args[])
	{
		List<Integer> values=Arrays.asList(4,5,6,7);
		
		ConsImpl c=new ConsImpl();
		
	    values.forEach(c);
		
		
	}
}