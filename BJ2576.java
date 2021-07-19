import java.util.*;
//7개의 자연수가 주어질 때, 이들 중 홀수인 자연수들을 모두 골라 그 합을 구하고, 고른 홀수들 중 최솟값을 찾는 프로그램
public class Main {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int num[]= new int[7];
		int sum=0;
		int min=100;
		for (int i=0;i<7;i++) {
			num[i]=scanner.nextInt();
			if(num[i]%2==1) {
				sum=sum+num[i];
				if (min>num[i]) {
					min=num[i];
				}
			}
		}
		if(sum!=0) {
			System.out.println(sum);
			System.out.println(min);
		}
		else {
			System.out.println("-1");
		}
		scanner.close();
	}
}
