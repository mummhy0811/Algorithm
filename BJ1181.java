import java.io.*;
import java.util.TreeSet;
public class BJ1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int t=Integer.parseInt(br.readLine());
		String word, tmp;
		TreeSet<String> set = new TreeSet<>();
		for(int i=0;i<t;i++) {
			word=br.readLine();
			set.add(word); //중복 제거 및 오름차순 정렬
		}
		String arr[]=set.toArray(new String[set.size()]); //set을 배열로 변경
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j].length()>arr[j+1].length()) {
					tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
		for(int i=0;i<arr.length;i++) bw.write(arr[i]+"\n");
		br.close(); bw.flush(); bw.close();
	}
}
