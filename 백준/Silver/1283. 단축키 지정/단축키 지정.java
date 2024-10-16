import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for(int i=0;i<N;i++) arr[i] = br.readLine();
        run(N, arr);
        bw.flush();
        bw.close();
    }
    public static void run(int N, String[] arr) throws IOException{
        StringTokenizer st ;
        Set<Character> set = new HashSet<>();

        for(String now:arr){
            String s = now.toUpperCase();
            st = new StringTokenizer(s, " ");

            boolean fin = false;

            int wIdx = 0;
            while(st.hasMoreTokens()){
                char c = st.nextToken().charAt(0);
                if(!set.contains(c)){
                    bw.write(print(now, wIdx, 0)+"\n");
                    set.add(c);
                    fin=true;
                    break;
                }
                wIdx++;
            }

            if(!fin){
                //알파벳을 보며 단축키로 지정
                for(int j=0;j<s.length();j++){
                    char c = s.charAt(j);
                    if(c!=' ' && !set.contains(c)){
                        bw.write(now.substring(0, j)+"["+now.charAt(j)+"]"+now.substring(j+1)+"\n");
                        set.add(c);
                        fin=true;
                        break;
                    }
                }
            }

            if(!fin){
                bw.write(now+"\n");
            }

        }

    }
    public static String print(String s, int wIdx, int idx){
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ");

        for(int i=0;i<wIdx;i++){
            sb.append(st.nextToken()).append(" ");
        }

        String target = st.nextToken();

        sb.append(target, 0, idx)
                .append("[").append(target.charAt(idx)).append("]").append(target.substring(idx + 1)).append(" ");

        while(st.hasMoreTokens()){
            sb.append(st.nextToken()).append(" ");
        }
        return sb.toString();
    }
}