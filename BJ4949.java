import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ4949 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		while(true){ //종료 조건이 충족될 때까지 문장 입력받음
			boolean check=true;
			Deque<String> stack = new ArrayDeque<String>();
			String read=br.readLine(); 
			if(read.equals(".")) break;//입력 종료 조건
			String[] arr=read.split(""); //글자별로 나눔

			for(int j=0;j<arr.length;j++) {
				switch(arr[j]) {
					case "(": //왼쪽 괄호일 경우 push
						stack.push("(");
						break;
					case ")": //오른쪽 괄호일 경우 pop
						if(stack.size()==0 || stack.peek() != "(") { //stack이 비어있는 경우, 짝이 안 맞는 경우 pop불가능
							check=false;
							break;
						}
						else { 
							stack.pop();
							break;
						}
					case "[": //왼쪽 대괄호일 경우 push
						stack.push("[");
						break;
					case "]": //오른쪽 대괄호일 경우 pop
						if(stack.size()==0 || stack.peek() != "[") { //stack이 비어있을 경우 pop불가능
							check=false;
							break;
						}
						else { 
							stack.pop();
							break;
						}
					default: //괄호가 아닐 경우
						break;	
				}
			}
			if(check && stack.size()==0) bw.write("yes"+"\n");
			else bw.write("no"+"\n");
		}
		br.close(); bw.flush(); bw.close();
	}
}
