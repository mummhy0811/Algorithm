import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt(); //과목 개수
		int sub[]=new int[n];
		int best=0; //점수 최댓값
		double sum=0;
		for(int i=0;i<n;i++) {
			sub[i]=scanner.nextInt();
			if(sub[i]>=best) best=sub[i];
		}
		for(int i=0;i<n;i++) {
			sum=sum+(double)sub[i]/best*100;
		}
		System.out.println(sum/n);
		scanner.close();
	}
}
