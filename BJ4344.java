import java.util.Scanner;

public class BJ4344 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		for(int i=0;i<n;i++) {
			int test=scanner.nextInt();
			int std[]=new int[test];
			double sum=0;
			for(int j=0;j<test;j++) {
				std[j]=scanner.nextInt();
				sum=sum+std[j];
			}
			double average=sum/test;
			int num=0;
			for(int k=0;k<test;k++) {
				if(std[k]>average) {
					num++;
				}
			}
			double per=((double)num/(double)test)*100;
			String.format("%3f",per);
			System.out.println(String.format("%.3f",per)+"%");
		}
		scanner.close();

	}

}
