import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append('I');
        sb.append("OI".repeat(Math.max(0, n)));

        int len=sb.length();

        int ans=0;
        for(int i=0;i<=m-len;i++){
            if(s.charAt(i)=='I'){
                if(s.substring(i, i+len).equals(sb.toString())){
                    ans++;
                }
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}