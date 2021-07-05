import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int test[]=new int[n];
		for(int i=0;i<n;i++) {
			int num=scanner.nextInt();
			test[i]=num;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<test[i];j++) {
				System.out.print("=");
			}
			System.out.println();
		}
		scanner.close();
	}
}
