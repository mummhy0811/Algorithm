import java.io.*;
import java.util.*;

public class BJ18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		String read;
		String[] n;
		
		int t=Integer.parseInt(br.readLine()); //�ݺ� Ƚ�� �о����

		Deque<Integer> q = new ArrayDeque<Integer>();

		for(int i=0;i<t;i++) {
			read=br.readLine(); //��ɾ� �о����
			n=read.split(" "); //push �� ���� �о���̱� ���� ���� ����
			
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
