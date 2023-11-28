import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            List<Integer> sort= new ArrayList<>();
            int num=0;
            sort.add(Integer.parseInt(st.nextToken()));
            for(int j=2;j<21;j++){
                int height = Integer.parseInt(st.nextToken());
                long p =  sort.stream().filter(s -> s>height).count();
                num+=p;
                sort.add((int) (j-p-1), height);
            }
            bw.write(t+" "+num+"\n");
        }
        bw.flush();
        bw.close();
    }
}