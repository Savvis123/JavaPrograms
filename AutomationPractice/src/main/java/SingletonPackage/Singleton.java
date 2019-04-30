package SingletonPackage;

public class Singleton {
	
	//once we create object then it will refer same even if you create multiple objects also with new references
	//instructions---
	//1.private constructor
	//2.static method which has return type of object of singleton type 
	
	private static Singleton singleton_Instance=null;
	
	public String str;
	
	private Singleton()
	{
		str="Hello this is mahesh";
	}

	public static Singleton getInstance()
	{
		
		if(singleton_Instance==null)
		
			singleton_Instance=new Singleton();
			return singleton_Instance;
	}
	
	public static void main(String args[])
	{
		Singleton x=Singleton.getInstance();
		Singleton y=Singleton.getInstance();
		Singleton z=Singleton.getInstance();
		
		x.str=(x.str).toUpperCase();
		System.out.println(x.str);
		System.out.println(y.str);
		System.out.println(z.str);
	}
		
	}


