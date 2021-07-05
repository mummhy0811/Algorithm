import java.util.Scanner;
public class Main {
	public static boolean isprime(int a) {
		if(a==1) return false;
		else if(a==2) return true;
		
		for(int i=2;i<=a/2;i++) {
			if(a%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int num[]=new int[n];
		int ans=0;
		for(int i=0;i<n;i++) {
			num[i]=scanner.nextInt();
			if(isprime(num[i])) {
				ans=ans+1;
			}
		}
		System.out.println(ans);
		scanner.close();
	}
}
