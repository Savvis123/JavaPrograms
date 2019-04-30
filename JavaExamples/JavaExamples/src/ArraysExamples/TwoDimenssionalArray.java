package ArraysExamples;

public class TwoDimenssionalArray {

	public static void main(String[] args) {
		//creating Two dimenssional Array
		int i[][]=new int[2][3];
		i[0][0]=10;
		i[0][1]=20;
		i[0][2]=30;
		
		i[1][0]=40;
		i[1][1]=50;
		i[1][2]=60;
		
		System.out.println("rows count:"+i.length);
		System.out.println("colums count:"+i[0].length);
		
		for(int row=0;row<i.length;row++)
		{
			for(int col=0;col<i[0].length;col++)
			{
				System.out.println(i[row][col]);
			}
		}

	}

}
