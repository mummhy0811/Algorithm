import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);

        Map<String, String> saved = new HashMap<>();
        for(int i=0;i<N;i++){
            String[] s = br.readLine().split(" ");
            saved.put(s[0], s[1]);
        }

        for(int i=0;i<M;i++){
            bw.write(saved.get(br.readLine())+"\n");
        }
        bw.flush();
        bw.close();
    }
}