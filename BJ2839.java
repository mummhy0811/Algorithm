import java.util.*;
public class Main {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int sugar=n;
		int ans=0;
		
		if(n%5==0) {
			System.out.println(n/5);
			System.exit(0);
		}
		
		
		while(n>3) {
			n=n-3;
			ans=ans+1;
			
			if(n%5==0){
				ans=ans+n/5;
				System.out.println(ans);
				System.exit(0);
			}
		}
		
		if(sugar%3==0) 
			System.out.println(sugar/3);
		else
			System.out.println(-1);
		scanner.close();
	}
}
