import java.io.*;

public class BJ9012 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int t=Integer.parseInt(br.readLine()); //반복 횟수 읽어들임

		for(int i=0;i<t;i++) {
			int tos=-1;
			boolean check=true;
			String read=br.readLine(); //괄호 읽어들임
			String[] arr=read.split(""); //괄호 하나씩 나눔
			String[] stack=new String[arr.length];
			
			for(int j=0;j<arr.length;j++) {
				switch(arr[j]) {
					case "(": //왼쪽 괄호일 경우 push
						stack[++tos]="(";
						break;
					case ")": //오른쪽 괄호일 경우 pop
						if(tos==-1) { //stack이 비어있을 경우 pop불가능
							check=false;
							break;
						}
						else { //스택에 괄호가 있을 경우
							stack[tos--]=" ";
							break;
						}
				}
			}
			if(check && tos==-1) bw.write("YES"+"\n"); //vps가 아님
			else  bw.write("NO"+"\n");
		}
		br.close(); bw.flush(); bw.close();
	}
}
