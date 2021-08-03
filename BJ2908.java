import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int	aIn=a%10*100+(a%100-(a%10))+a/100;
		int bIn=b%10*100+(b%100-(b%10))+b/100;
		System.out.println(aIn>bIn?aIn:bIn);
		scanner.close();

	}

}
