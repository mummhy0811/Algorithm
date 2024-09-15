import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            map = new HashMap<>();
            int n =Integer.parseInt(br.readLine());
            for(int j=0;j<n;j++){
                save(br.readLine());
            }
            bw.write((calc()-1)+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void save(String s){
        StringTokenizer st = new StringTokenizer(s);
        st.nextToken();
        String s2 = st.nextToken();
        int n=1;
        if(map.containsKey(s2)){
            n = map.get(s2)+1;
        }
        map.put(s2, n);
    }

    private static int calc(){
        int cnt=1;
        for(String s:map.keySet()){
            cnt*=(map.get(s)+1);
        }
        return cnt;
    }
}