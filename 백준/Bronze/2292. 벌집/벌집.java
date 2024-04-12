import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int add=0;
        int max=1;

        while(true){
            max+=add;
            if(max>=n){
                break;
            }
            add+=6;
        }
        bw.write(add/6+1+"");
        bw.flush();
        bw.close();
    }
}