import java.io.*;
import java.util.*;

public class BJ18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		String read;
		String[] n;
		
		int t=Integer.parseInt(br.readLine()); //반복 횟수 읽어들임

		Deque<Integer> q = new ArrayDeque<Integer>();

		for(int i=0;i<t;i++) {
			read=br.readLine(); //명령어 읽어들임
			n=read.split(" "); //push 뒤 수를 읽어들이기 위한 공백 제거
			
			switch(n[0]) {
			case "push":
				q.add(Integer.parseInt(n[1]));
				break;
			case "pop" : 
				if(q.size()==0) bw.write("-1\n");
				else bw.write(q.removeFirst()+"\n");
				break;
			case "size":
				bw.write(q.size()+"\n");
				break;
			case "empty":
				if(q.size()==0) bw.write("1\n");
				else bw.write("0\n");
				break;
			case "front":
				if(q.size()==0) bw.write("-1\n");
				else bw.write(q.getFirst()+"\n");
				break;
			case "back":
				if(q.size()==0) bw.write("-1\n");
				else bw.write(q.getLast()+"\n");
				break;
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
