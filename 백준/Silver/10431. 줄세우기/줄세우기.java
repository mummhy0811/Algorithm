import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][21];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            for(int j=1;j<21;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            List<Integer> sort= new ArrayList<>();
            int num=0;
            sort.add(arr[i][1]);
           for(int j=2;j<21;j++){
               int height = arr[i][j];
               long p =  sort.stream().filter(s -> s>height).count();
               num+=p;
               sort.add((int) (j-p-1), height);
           }
           bw.write(arr[i][0]+" "+num+"\n");
        }
        bw.flush();
        bw.close();
    }
}