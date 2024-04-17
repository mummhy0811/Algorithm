import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb= new StringBuilder();
        sb.append("<");
        boolean[] arr = new boolean[n+1];

        int check=0, move=0, i=1;
        while(true){
            if(!arr[i]){
                move++;
                if(move==k){
                    check++;
                    sb.append(i).append(", ");
                    arr[i]=true;
                }
                if(move==k) move=0;
            }
            if(check==n) break;
            i++;
            if(i>n)i=1;
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}