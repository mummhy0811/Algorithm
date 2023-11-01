import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        boolean[] arr = new boolean[n+1];

        for (int i = 2; i <= n; i++){
            if(!arr[i]) {
                list.add(i);
                for (int j = i*2; j <= n; j+=i ){
                    arr[j] = true;
                }
            }
        }

        int start=0, end=0, count=0, sum=0;
        int size=list.size();

        while(start<=size && end<=size){
            if(sum>n) {
                sum -= list.get(start++);
            }
            else {
                if(sum==n) count++;
                if(end==size) break;
                else sum+=list.get(end++);
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}