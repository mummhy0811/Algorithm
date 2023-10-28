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
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        while(st2.hasMoreTokens()){
            temperatureList.add(Integer.valueOf(st2.nextToken()));
        }

        long max = 0, sum;
        for(int i=0;i<k;i++){
            max+=temperatureList.get(i);
        }

        sum=max;
        int start=0;
        int end=k;

        while(end<n){
            sum = sum-temperatureList.get(start)+temperatureList.get(end);
            max=Math.max(max, sum);
            start+=1;
            end+=1;
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}