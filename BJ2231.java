import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()), num=0; 
		for(int i=1;i<n;i++) {
			num=i;
			String[] arr=Integer.toString(num).split("");
			for(int j=0;j<arr.length;j++) 
				num=num+Integer.parseInt(arr[j]);
			if(n==num) {
				System.out.println(i); break;
			}
		}
		if(num!=n) System.out.println("0");
	}
}
