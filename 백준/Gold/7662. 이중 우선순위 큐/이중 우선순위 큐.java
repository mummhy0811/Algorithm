import java.io.*;
import java.util.*;

public class Main {

    static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();

            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine());
                calc(st.nextToken(), Integer.parseInt(st.nextToken()));
            }
            if(map.isEmpty()) bw.write("EMPTY\n");
            else bw.write(map.lastKey()+" "+map.firstKey()+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void calc(String s, int n) {
        if (s.equals("I")) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }else if (s.equals("D")) {
            if(!map.isEmpty()){
                if (n == 1) {
                    int max = map.lastKey();
                    int cnt = map.getOrDefault(max, 1);
                    if(cnt==1) map.remove(max);
                    else map.put(max, cnt-1);
                }else if(n == -1){
                    int min = map.firstKey();
                    int cnt = map.getOrDefault(min, 1);
                    if(cnt==1) map.remove(min);
                    else map.put(min, cnt-1);
                }
            }
        }
    }
}