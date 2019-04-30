package pack;

public class CallByValueAndCallByRef {
	
	int p;
	int q;

	public static void main(String[] args) {
		CallByValueAndCallByRef obj =new CallByValueAndCallByRef();
		int x=10;
		int y=20;
		System.out.println(obj.sum(x, y));//call By value or pass by val(this x and y values are sending to sum(a,b) but always latest values will be used)
		
		obj.p=50;
		obj.q=60;
		obj.swap(obj);
		System.out.println(obj.p);
		System.out.println(obj.q);
	}
	
	public int sum(int a ,int b)
	{
	    a=30;
		b=40;
		int c=a+b;
		return c;
	}
	
	public void swap(CallByValueAndCallByRef t)//we are passing the value of obj reference -- callByReference
	{
		int temp;
		temp=t.p;//temp=50
		t.p=t.q;//t.p=60
		t.q=temp;//t.q=50 (temp)
		
	}

}
