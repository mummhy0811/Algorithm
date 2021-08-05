import java.util.Scanner;

public class BJ1075 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int f=scanner.nextInt();
		
		for(int i=0;i<100;i++) {
			if(((n-n%100)+i)%f==0) {
				if(((n-n%100)+i)-(n-n%100)<10) {
					System.out.print("0");
					System.out.println(((n-n%100)+i)-(n-n%100));
				}
				else{
					System.out.println(((n-n%100)+i)-(n-n%100));
				}
				break;
			}
		}
		scanner.close();
	}
}
