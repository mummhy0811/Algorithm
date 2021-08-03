import java.util.*;
public class Main {
    /*그리디 알고리즘
    JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 언제나 거스름돈 개수가 가장 적게 잔돈을 준다. 
    타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오. */
	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=1000-n;
		int ans=0;

		while(m>0) {
			if(m>=500) {
				m=m-500;
				ans=ans+1;
			}
			else if(m>=100) {
				m=m-100;
				ans=ans+1;
			}
			else if(m>=50) {
				m=m-50;
				ans=ans+1; 
			}
			else if(m>=10) {
				m=m-10;
				ans=ans+1; 
			}
			else if(m>=5) {
				m=m-5;
				ans=ans+1; 
			}
			else if(m>=1) {
				m=m-1;
				ans=ans+1; 
			}
		}
		System.out.println(ans);
		scanner.close();
	}
}
