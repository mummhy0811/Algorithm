import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S1 = br.readLine();
        String S2 = br.readLine();

        int[][] cnt = new int[S1.length()+1][S2.length()+1];

        for(int i=1;i<=S1.length();i++){
            for(int j=1;j<=S2.length();j++){
                if(S1.charAt(i-1)==S2.charAt(j-1)) cnt[i][j] = cnt[i-1][j-1]+1;
                else cnt[i][j] = Math.max(cnt[i][j-1], cnt[i-1][j]);
            }
        }
        int len=cnt[S1.length()][S2.length()];
        int i=S1.length();
        int j=S2.length();
        while(len>0){
            int now = cnt[i][j];
            if(i-1>0 && cnt[i-1][j]==now){
                i--;
            }else if(j-1>0 && cnt[i][j-1]==now){
                j--;
            }else{
                sb.append(S1.charAt(i-1));
                i--;
                j--;
                len--;
            }
        }
        System.out.println(cnt[S1.length()][S2.length()]);
        if(cnt[S1.length()][S2.length()]!=0)System.out.println(sb.reverse());

    }
}