import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int ans=n*(n+1)/2;
		System.out.println(ans);
		scanner.close();
	}
}
