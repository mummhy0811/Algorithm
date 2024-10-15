import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        bw.write(run(N, W, L, arr)+"");
        bw.flush();
        bw.close();
    }
    public static int run(int N, int W, int L, int[] arr){

        Queue<Integer> queue = new LinkedList<>(); //다리
        queue.add(arr[0]);

        int idx = 1; //다음 입장
        int time = 1;
        int weight = arr[0];
        while(!queue.isEmpty()){
            //앞으로 이동
            time++;
            if(time>W) { //다리에서 나옴
                weight-=queue.poll();
            }

            //새로운 트럭 추가
            if(idx<N){
                if(weight+arr[idx]<=L){
                    weight+=arr[idx];
                    queue.add(arr[idx++]);
                }else{//트럭 입장 X
                    queue.add(0);
                }
            }

        }

        return time;
    }
}