import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int min=-1;

        if(n%5==0){
            min = n/5;
        }else if(n%3==0){
            min = n/3;
        }

        int tmp=n/5;

        while(tmp>0){
            if((n-tmp*5)%3==0) {
                min=tmp+(n-tmp*5)/3;
                break;
            }
            tmp--;
        }
        
        bw.write(min+"");
        bw.flush();
        bw.close();
    }
}