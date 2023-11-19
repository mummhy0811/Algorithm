import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n+1];
        int[] max = new int[n+1];
        score[0]=0; max[0]=0;
        for(int i=1;i<n+1;i++) score[i]=Integer.parseInt(br.readLine());
        max[1]=score[1];
        if(n>1) max[2]=score[1]+score[2];
        
        for(int i=3;i<=n;i++){
            max[i]=Math.max(max[i-3]+score[i-1], max[i-2])+score[i];
        }
        bw.write(max[n]+"");

        bw.flush();
        bw.close();
    }
}