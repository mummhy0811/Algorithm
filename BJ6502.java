import java.util.*;
public class Main {

	public static void main(String[] args) {

		
		Scanner scanner=new Scanner(System.in);
		int n=0;
		while(true) {
			n=n+1;
			int r=scanner.nextInt();
			if(r==0) break;
			int w=scanner.nextInt();
			int l=scanner.nextInt();
			if(w*w+l*l<=4*r*r) {
				System.out.println("Pizza "+n+" fits on the table.");
			}
			else {
				System.out.println("Pizza "+n+" does not fit on the table.");
			}
		}
		scanner.close();
	}
}
