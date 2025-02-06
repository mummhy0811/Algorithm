import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        find(0);

        System.out.print(sb.toString());
    }

    static void find(int depth){
        if(depth==N){
            for(int i=0;i<N;i++) sb.append(arr[i]);
            sb.append("\n");
            return;
        }

        for(int i=0;i<=9;i++){
            if(isPrime(changeToNum(depth, i))){
                arr[depth] = i;
                find(depth+1);
            }
        }
    }
    static int changeToNum(int depth, int last){
        int n = 0;
        int pos = (int)Math.pow(10, depth);

        for(int i=0;i<depth;i++){
            n+=(arr[i])*pos;
            pos/=10;
        }
        n+=last;
        return n;
    }

    static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;

        }
        return true;
    }
}