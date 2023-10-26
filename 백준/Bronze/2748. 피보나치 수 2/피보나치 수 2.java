import java.io.*;

//백준 2748 피보나치수 - 231026

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] fibonacci = new long[n+1];
        fibonacci[0]=0;
        if(n>0){
            fibonacci[1]=1;
            for(int i=2;i<=n;i++){
                fibonacci[i]=fibonacci[i-1]+fibonacci[i-2];
            }
        }

        System.out.println(fibonacci[n]);
    }
}