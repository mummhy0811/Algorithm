import java.util.Scanner;

public class BJ11050 {

	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int top=1, bottom=1;
		for(int i=n;i>n-k;i--) top*=i;
		for(int i=1;i<=k;i++) bottom*=i;
		System.out.println(top/bottom);
	}
}
