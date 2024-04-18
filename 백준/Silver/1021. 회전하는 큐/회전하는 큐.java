import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        deque = new ArrayDeque<>();
        for(int i=1;i<=n;i++) deque.add(i);

        st = new StringTokenizer(br.readLine());
        arr = new int[m];
        for(int i=0;i<m;i++) arr[i]=Integer.parseInt(st.nextToken());

        int ans=0;
        for(int i=0;i<m;i++){

            int target=findIdx(arr[i]);
            if(target<=deque.size()/2){ //앞쪽에 위치
                for(int k=0;k<target;k++){
                    int f = deque.poll();
                    deque.add(f);
                    ans++;
                }
            }else{
                for(int k=0;k<deque.size()-target;k++){
                    int e = deque.pollLast();
                    deque.addFirst(e);
                    ans++;
                }
            }
            deque.poll();
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    static int findIdx(int n){
        int idx=0;
        for(Integer i:deque){
            if(i==n) return idx;
            idx++;
        }
        return -1;
    }
}