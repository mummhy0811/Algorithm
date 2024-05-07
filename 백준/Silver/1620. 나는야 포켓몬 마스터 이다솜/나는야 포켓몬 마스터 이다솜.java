import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> name = new HashMap<>(n);
        HashMap<Integer, String> idx = new HashMap<>(n);
        for(int i=0;i<n;i++){
            String now = br.readLine();
            name.put(now, i);
            idx.put(i, now);
        }
        for(int i=0;i<m;i++){
            String target = br.readLine();
            if (target.charAt(0) - '0' > 9) bw.write((name.get(target) + 1) + "\n");
            else bw.write(idx.get(Integer.parseInt(target) - 1) + "\n");
        }
        bw.flush();
        bw.close();
    }
}