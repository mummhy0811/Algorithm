import java.util.*;
public class Main {
  //그리디 알고리즘
  
	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt(); //사람의 수
		int[] t=new int[n];
		int ans=0;
		for(int i=0;i<n;i++) {
			t[i]=scanner.nextInt();
		}
		Arrays.sort(t);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				ans=ans+t[j];
			}
		}
		System.out.println(ans);
		scanner.close();
	}
}
