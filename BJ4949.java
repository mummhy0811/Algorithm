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

		while(true){ //���� ������ ������ ������ ���� �Է¹���
			boolean check=true;
			Deque<String> stack = new ArrayDeque<String>();
			String read=br.readLine(); 
			if(read.equals(".")) break;//�Է� ���� ����
			String[] arr=read.split(""); //���ں��� ����

			for(int j=0;j<arr.length;j++) {
				switch(arr[j]) {
					case "(": //���� ��ȣ�� ��� push
						stack.push("(");
						break;
					case ")": //������ ��ȣ�� ��� pop
						if(stack.size()==0 || stack.peek() != "(") { //stack�� ����ִ� ���, ¦�� �� �´� ��� pop�Ұ���
							check=false;
							break;
						}
						else { 
							stack.pop();
							break;
						}
					case "[": //���� ���ȣ�� ��� push
						stack.push("[");
						break;
					case "]": //������ ���ȣ�� ��� pop
						if(stack.size()==0 || stack.peek() != "[") { //stack�� ������� ��� pop�Ұ���
							check=false;
							break;
						}
						else { 
							stack.pop();
							break;
						}
					default: //��ȣ�� �ƴ� ���
						break;	
				}
			}
			if(check && stack.size()==0) bw.write("yes"+"\n");
			else bw.write("no"+"\n");
		}
		br.close(); bw.flush(); bw.close();
	}
}
