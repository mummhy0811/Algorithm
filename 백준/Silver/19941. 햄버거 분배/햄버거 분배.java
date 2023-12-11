import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] s = br.readLine().toCharArray();

        int n=0;
        for(int i=0;i<N;i++){
            if(String.valueOf(s[i]).equals("P")){
                for(int j=-k;j<=k;j++){
                    if(i+j<0 || i+j>=s.length) continue;
                    if(String.valueOf(s[i+j]).equals("H")){
                        s[i+j]=" ".charAt(0);
                        n++;
                        break;
                    }
                }
            }
        }
        bw.write(n+"");
        bw.flush();
        bw.close();
    }
}