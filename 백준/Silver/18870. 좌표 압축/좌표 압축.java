import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new TreeMap<>();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            map.put(num, 1);
            arr[i]=num;
        }

        int idx=0;
        for(Integer num:map.keySet()){
            map.put(num, idx);
            idx++;
        }

        for(int i=0;i<n;i++){
            bw.write(map.get(arr[i])+" ");
        }
        bw.flush();
        bw.close();
    }
}