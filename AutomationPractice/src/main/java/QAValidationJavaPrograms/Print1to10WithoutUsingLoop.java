package QAValidationJavaPrograms;

public class Print1to10WithoutUsingLoop {

	public static void main(String[] args) {
		Increment(1);
	}
	public static void Increment(int i){
		System.out.println(i);
		i++;
		if(i<=10){
			Increment(i);
		}
	}
}