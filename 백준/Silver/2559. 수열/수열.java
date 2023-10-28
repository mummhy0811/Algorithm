import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> temperatureList = new ArrayList<>(n);
        long max = 0, tmp;

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        while(st2.hasMoreTokens()){
            temperatureList.add(Integer.valueOf(st2.nextToken()));
        }
        for(int i=0;i<n+1-k;i++){
            tmp=0;
            for(int j=0;j<k;j++){
                tmp+=temperatureList.get(i+j);
            }
            if(i==0) max=tmp;
            if(tmp>max) max=tmp;
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}