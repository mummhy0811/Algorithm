import java.util.Scanner;

public class BJ7568 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); //»ç¶÷ ¼ö
		int[][] arr=new int[n][2];
		int[]score=new int[n];
		for(int i=0;i<n;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
			score[i]=1;
		}
		for(int i=0;i<n;i++) { 
			for(int j=0;j<n;j++) 
				if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) score[i]++;
			System.out.print(score[i]+" ");
		}
	}
}
