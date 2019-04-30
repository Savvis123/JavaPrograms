package OnlineRostorJavaPrograms;

public class LastFourCharacterfromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="www.google.com";
		String firstfour=str.substring(0, 4);
		System.out.println("first four characters are :"+firstfour);
		
		String lastfour = str.substring(str.length()-4, str.length());
		System.out.println("last four characters are :"+lastfour);
		
		String middlechars=str.substring(4,str.length()-4);
		System.out.println(middlechars);

	}

}
