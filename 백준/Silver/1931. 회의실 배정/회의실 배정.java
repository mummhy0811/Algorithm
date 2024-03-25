import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static class Meeting{
        int start;
        int end;
        public Meeting(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Meeting[] arr = new Meeting[n];

        int fin=0;
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            arr[i]=new Meeting(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]) );
            fin=Math.max(fin, Integer.parseInt(tmp[1]));
        }

        Arrays.sort(arr, (m1, m2) -> {
            if(m1.end==m2.end) return m1.start-m2.start;
            return m1.end-m2.end;
        });

        int count = 0, prev_end_time = 0;

        for(int i = 0; i < n; i++) {
            if(prev_end_time <= arr[i].start) {
                prev_end_time = arr[i].end;
                count++;
            }
        }
        System.out.println(count);
    }
}