package DiamondProblem;

public interface B extends A{
	
	default void m()
	{
		System.out.println("m() from Interface B");
	}

}
