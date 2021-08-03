import java.util.Scanner;
public class BJ2588 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt(); //컵 개수
		int x=scanner.nextInt(); //처음 공 위치
		int k=scanner.nextInt(); //컵 위치 바꾸는 횟수
		int[] cup=new int[n];
		cup[x-1]=1;
		for(int i=0;i<k;i++) {
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			int tmp=cup[a-1];
			cup[a-1]=cup[b-1];
			cup[b-1]=tmp;
		}
		for(int i=0;i<n;i++) {
			if(cup[i]==1) {
				System.out.println(i+1);
				break;
			}
		}
		scanner.close();
	}
}
