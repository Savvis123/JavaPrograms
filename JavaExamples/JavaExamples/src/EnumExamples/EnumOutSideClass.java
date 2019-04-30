package EnumExamples;

/*
Enumerations serve the purpose of representing a group of named constants in a programming language.
The main objective of enum is to define our own data types(Enumerated Data Types).*/


enum Color{
	GREEN,RED,BLUE;
}
public class EnumOutSideClass {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Color c=Color.GREEN;
		System.out.println("color name is :"+c);
	}

}
