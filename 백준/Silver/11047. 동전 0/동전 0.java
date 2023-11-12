import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> coin=new ArrayList<>();
        for(int i=0;i<n;i++) coin.add(Integer.parseInt(br.readLine()));

        coin = coin.stream().filter( c -> c<=k).collect(Collectors.toList());
        int num=0, sum=k;
        coin.sort(Collections.reverseOrder());
        while(sum>0){
            int add = sum/coin.get(0);
            num+=add;
            sum-=coin.get(0)*add;
            coin.remove(0);
        }
        
        bw.write(num+"");
        bw.flush();
        bw.close();
    }
}