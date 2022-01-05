import java.io.*;

public class BJ10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k=Integer.parseInt(br.readLine()); //반복 횟수 읽어들임
		int[] stack=new int[k]; //스택 생성
		int tos=-1;
		
		for(int i=0;i<k;i++) {
			int n=Integer.parseInt(br.readLine());
			if(n==0) //delete
				stack[tos--]=0;
			else  //push
				stack[++tos]=n;
		}
		int sum=0;
		for(int i=0;i<=tos;i++) 
			sum+=stack[i];
		bw.write(sum+"\n");
		br.close(); bw.flush(); bw.close();
	}
}
