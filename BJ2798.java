import java.util.*;
//N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
//브루트포스 알고리즘
public class Main {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		int arr[]=new int[n];
		int ans=0;
		int max=0;
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}

		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					ans=arr[i]+arr[j]+arr[k];
					if(ans<=m) {
						if(max<ans) max=ans;
					}
				}
			}
		}
		System.out.println(max);
		scanner.close();
	}
}
