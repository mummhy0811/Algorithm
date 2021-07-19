import java.util.*;
//문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
//각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.
public class Main {

	public static void main(String[] args) {

		
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			int small=0;
			int large=0;
			int num=0;
			int space=0;
			String s=scanner.nextLine();
			for(int i=0;i<s.length();i++) {
				if(97<=s.charAt(i) && s.charAt(i)<=122) small++;
				else if(65<=s.charAt(i) && s.charAt(i)<=90) large++;
				else if(48<=s.charAt(i) && s.charAt(i)<=157) num++;
				else if(s.charAt(i)==32) space++;
			}
			System.out.println(small+" "+large+" "+num+" "+space);
		}
		scanner.close();
	}
}
