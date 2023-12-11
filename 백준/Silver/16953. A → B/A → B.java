import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        String b = st.nextToken();
        int n=1;
        while(!b.equals(String.valueOf(a))){
            if(Integer.parseInt(b)<a){
                n=-1;
                break;
            }

            if(b.charAt(b.length() -1) == '1'){
                b=b.substring(0, b.length()-1);
            }else if(Integer.parseInt(b)%2!=0){
                n=-1;
                break;
            }else{
                b=String.valueOf(Integer.parseInt(b)/2);
            }
            n++;
        }
        bw.write(n+"");
        bw.flush();
        bw.close();
    }
}