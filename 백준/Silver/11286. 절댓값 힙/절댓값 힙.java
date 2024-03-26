import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;
                }
                return Math.abs(o1)-Math.abs(o2);
            }
        });

        for(int i=0;i<n;i++){
            int now = Integer.parseInt(br.readLine());
            if(now==0){
                if(q.isEmpty()){
                    bw.write("0\n");
                    continue;
                }
                bw.write(q.poll()+"\n");
                continue;
            }
            q.add(now);
        }
        bw.flush();
        bw.close();
    }
}