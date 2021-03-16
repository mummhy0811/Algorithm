import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int max=0;
		int max_num=0;
		int num[]=new int[9];
		for(int i=0;i<9;i++) {
			num[i]=scanner.nextInt();
			if(num[i]>max) {
				max=num[i];
				max_num=i+1;
			}
		}
		System.out.println(max);
		System.out.println(max_num);
		scanner.close();
	}
}
