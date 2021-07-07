import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int first=scanner.nextInt();
		int num1=first/10; 
		int num2=first%10;
		int ans=0, t=0;
		do {
			int tmp=num1+num2;
			int right_tmp=tmp%10;
			ans=num2*10+right_tmp;
			num1=ans/10; num2=ans%10;
			t++;
			
		}while(first!=ans);
		System.out.println(t);
		scanner.close();
	}
}
