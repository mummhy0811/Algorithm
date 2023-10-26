import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Nation{
        int gold, silver, bronze;
        public Nation(int g, int s, int b){
            this.gold=g;
            this.silver=s;
            this.bronze=b;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int rank =1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Nation[] nationList = new Nation[n];

        for(int i=0;i<n;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            nationList[Integer.parseInt(st2.nextToken())-1] = new Nation( Integer.parseInt(st2.nextToken()),
                    Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));
        }

        for(int i=0;i<n;i++){
            if(nationList[k-1].gold<nationList[i].gold)
                rank++;
            else if(nationList[k-1].gold==nationList[i].gold){
                if(nationList[k-1].silver<nationList[i].silver)
                    rank++;
                else if(nationList[k-1].silver==nationList[i].silver){
                    if(nationList[k-1].bronze<nationList[i].bronze)
                        rank++;
                }
            }
        }

        bw.write(rank+"");
        bw.flush();
        bw.close();
    }
}