import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt();
		int y=scanner.nextInt();
		int w=scanner.nextInt();
		int h=scanner.nextInt();
		int num1=x;
		int num2=y;
		if(x>w/2){
			num1=w-x;
		}
		if(y>h/2) {
			num2=h-y;
		}
		int ans=(num1<num2)?num1:num2;
		System.out.println(ans);
		scanner.close();
	}
}
