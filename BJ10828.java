import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int num=Integer.parseInt(br.readLine()); //반복 횟수 읽어들임
		int [] stack=new int[num]; //스택 생성
		String read;
		String[] n;
		int size=0; // 스택에 들어있는 정수의 개수
		int tos=-1; //스택의 꼭대기에 있는 값
		
		for(int i=0;i<num;i++) {
			read=br.readLine(); //명령어 읽어들임
			n=read.split(" "); //push 뒤 수를 읽어들이기 위한 공백 제거
			switch(n[0]) {
			case "push":
				tos++; size++;
				stack[tos]=Integer.parseInt(n[1]);
				break;
			case "pop" : 
				if(tos==-1) { //스택에 들어있는 정수가 없는 경우
					bw.write(tos+"\n");
				}
				else {
					bw.write(stack[tos]+"\n");
					tos--; size--;
				}
				break;
			case "size":
				bw.write(size+"\n");
				break;
			case "empty":
				if(tos==-1) { //스택에 들어있는 정수가 없는 경우
					bw.write("1"+"\n");
				}
				else {
					bw.write("0"+"\n"); //스택에 들어있는 정수가 있는 경우
				}
				break;
			case "top":
				if(tos==-1) { //스택에 들어있는 정수가 없는 경우
					bw.write("-1"+"\n");
				}
				else {
					bw.write(stack[tos]+"\n");
				}
				break;
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
