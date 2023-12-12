import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "*");
        String l=  st.nextToken();
        String r = st.nextToken();
        for(int i=0;i<n;i++){
            String s = br.readLine();
            if(s.length()<l.length()+r.length()) bw.write("NE\n");
            else if(s.startsWith(l) && s.endsWith(r))bw.write("DA\n");
            else bw.write("NE\n");
        }
        bw.flush();
        bw.close();
    }
}