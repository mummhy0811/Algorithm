import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        short[][] link = new short[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) link[i][j]=Short.parseShort(st.nextToken());
        }

       for(int k=0;k<n;k++){
           for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                   if(link[i][k]==1 && link[k][j]==1) link[i][j]=1;
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