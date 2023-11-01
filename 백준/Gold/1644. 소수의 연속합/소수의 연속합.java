import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> isPrime = new ArrayList<>(n);
        for(int i=2;i<=n;i++) {
            isPrime.add(i);
        }

        for(int i=2;i<n;i++){
            for(int j=2;i*j<=n;j++ ){
                isPrime.set(i*j-2, 0);
            }
        }
        
        isPrime = isPrime.stream().filter(p -> !p.equals(0)).collect(Collectors.toList());
        int start=0, end=0, count=0, sum=0;

        while(start<=end && end<=isPrime.size()){
            if(sum>n) {
                sum -= isPrime.get(start++);
            }
            else {
                if(sum==n) count++;
                if(end==isPrime.size()) break;
                else sum+=isPrime.get(end++);
            }

        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}