import java.io.*;
import java.util.Arrays;
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
		Arrays.sort(arr, (x, y)->x.length()-y.length());
		for(int i=0;i<arr.length;i++) bw.write(arr[i]+"\n");
		br.close(); bw.flush(); bw.close();
	}
}
