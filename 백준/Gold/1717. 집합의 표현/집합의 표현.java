import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0){
                int parentB = findParent(b);
                int parentC = findParent(c);
                if(parentB>parentC) parent[parentB] = parentC;
                else parent[parentC] = parentB;
            }else{
                if(b==c) sb.append("YES\n");
                else{
                    if(findParent(b) == findParent(c))sb.append("YES\n");
                    else sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static int findParent(int target){
        if(parent[target] == target) return target;
        else return findParent(parent[target]);
    }
}