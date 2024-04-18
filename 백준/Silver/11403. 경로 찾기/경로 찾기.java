import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        List<List<Integer>> arr = new ArrayList<>();
        short[][] link = new short[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr.add(new ArrayList<>());
            for(int j=0;j<n;j++) {
                if(st.nextToken().equals("1"))
                    arr.get(i).add(j);
            }
        }
        boolean[] visit;

        for(int i=0;i<n;i++){
            Stack<Integer> s = new Stack<>();
            s.add(i);
            visit=new boolean[n];
            while(!s.isEmpty()){
                int now = s.pop();
                for(int j=0;j<arr.get(now).size();j++){
                    int next = arr.get(now).get(j);
                    if(!visit[next]){
                        s.add(next);
                        link[i][next]=1;
                        link[now][next]=1;
                        visit[next]=true;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(link[i][j]+" ");
            }
            System.out.println();
        }
    }
}