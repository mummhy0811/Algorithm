import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int num[]=new int[n];
		int max=-1000000;
		int min=1000000;
		for(int i=0;i<n;i++) {
			num[i]=scanner.nextInt();
			if(num[i]>=max) max=num[i];
			if(num[i]<=min) min=num[i];
		}
		System.out.println(min+" "+max);
		scanner.close();
	}
}
