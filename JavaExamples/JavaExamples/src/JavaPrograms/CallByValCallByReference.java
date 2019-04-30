package JavaPrograms;

public class CallByValCallByReference {

	/*There is only call by value in java, not call by reference. If we call a method passing a value,
	it is known as call by value. 
	The changes being done in the called method, is not affected in the calling method.
	
int data=50;  
  
 void change(int data){  
 data=data+100;//changes will be in the local variable only  
 }  
     
 public static void main(String args[]){  
   Operation op=new Operation();  
  
   System.out.println("before change "+op.data);  
   op.change(500);  
   System.out.println("after change "+op.data);  
  
 }  
	O/P :Output:before change 50
       after change 50	
	
	In case of call by reference original value is changed if we made changes in the called method. 
	If we pass object in place of any primitive value, original value will be changed. In this example we are passing 
	object as a value. Let's take a simple example:
	
	
 int data=50;  
  
 void change(Operation2 op){  
 op.data=op.data+100;//changes will be in the instance variable  
 }  
     
    
 public static void main(String args[]){  
   Operation2 op=new Operation2();  
  
   System.out.println("before change "+op.data);  
   op.change(op);//passing object  
   System.out.println("after change "+op.data);  
   
   
   O/P: Output:before change 50
       after change 150	
*/	
	
	public int sum(int a,int b)
	{
		
		a=40;
		b=50;
		int c=a+b;
		return c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CallByValCallByReference obj=new CallByValCallByReference();
		
		int x=30;
		int y=40;
		System.out.println(obj.sum(x, y));
		

	}

}
