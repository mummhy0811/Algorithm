import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int H=scanner.nextInt();
		int M=scanner.nextInt();
		if(M>=45) {
			M=M-45;
			System.out.println(H+" "+M);
		}
		else {
			M=60-(45-M);
			H=H-1;
			if(H==-1) H=23;
			System.out.println(H+" "+M);
		}
		scanner.close();
	}
}
