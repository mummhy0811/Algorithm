import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> byMinus = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while(st.hasMoreTokens()){
            byMinus.add(st.nextToken());
        }

        int result=0;
        for(int i=0;i<byMinus.size();i++){
            StringTokenizer st2 = new StringTokenizer(byMinus.get(i), "+");
            int sum=0;
            while(st2.hasMoreTokens()){
                sum+=Integer.parseInt(st2.nextToken());
            }
            if(i==0 )result+=sum;
            else result-=sum;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}