import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer>[] stacks = new Stack[N];

        StringTokenizer st;

        for(int i=0;i<N;i++) stacks[i] = new Stack<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int cnt=0;
            while(st.hasMoreTokens()){
                stacks[cnt].push(Integer.parseInt(st.nextToken()));
                cnt++;
            }
        }

        int num=0, cnt=0;
        while(cnt++<N){
            int max=0;
            for(int i=0;i<N;i++){
                if(stacks[max].peek()<stacks[i].peek()){
                    max=i;
                }
            }
            num = stacks[max].pop();
        }
        bw.write(num+"");
        bw.flush();
        bw.close();
    }
}