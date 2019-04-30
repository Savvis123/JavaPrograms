package WrapperClasses;

public class ThisKeywordExample {
	int i=10;

		public ThisKeywordExample() {
			System.out.println("first constructor");
		}
		
		public ThisKeywordExample(int j) {
			this();// 	calling statement of first constructor
			System.out.println("second constructor");
		}
		public void methodone()
		{
			System.out.println("this is method one");
		}
		
		public void methodTwo()
		{
			System.out.println(this.i);
			this.methodone();
		}
		

	}


