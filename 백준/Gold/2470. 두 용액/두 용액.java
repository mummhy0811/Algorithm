import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Long> arr = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arr.add(Long.parseLong(st.nextToken()));
        }
        arr = arr.stream().sorted().collect(Collectors.toList());
        
        int start=0, end=n-1;
        long min= -1000000000L * n, sum;

        long[] result = new long[2];

        while(start<end){
            sum=arr.get(start)+arr.get(end);
            if(Math.min(Math.abs(sum), Math.abs(min))== Math.abs(sum)){
                min=sum;
                result[0]=arr.get(start);
                result[1]=arr.get(end);
            }
            if(sum==0){
                bw.write(arr.get(start)+ " "+arr.get(end));
                bw.flush();
               return;
            } else if (sum > 0) {
                end--;
            }else{
                start++;
            }
        }
        
        bw.write(result[0] +" "+ result[1]);
        bw.flush();
        bw.close();
    }
}