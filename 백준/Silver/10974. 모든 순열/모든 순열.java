import java.io.*;

class Main {
    static int n;
    static boolean[]used;
    static int[] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr=new int[n];
        used = new boolean[n];
        
        search(0);
        bw.flush();
        bw.close();
    }
    private static void search(int depth)throws Exception {
        if(depth==n){
            for(int i=0;i<n;i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0;i<n;i++){
            if(!used[i]){
                used[i]=true;
                arr[depth]=i+1;
                search(depth+1);
                used[i]=false;
            }
        }
    }
}
