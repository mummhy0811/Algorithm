import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s1 = br.readLine();
        String s2 = br.readLine();

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] arr = new int[len1+1][len2+1];

        for(int i = 1;i<=len1;i++){
            char c = s1.charAt(i-1);
            for(int j=1;j<=len2;j++){
                if(c == s2.charAt(j-1)) arr[i][j] = arr[i-1][j-1]+1;
                else arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
            }
        }

        int next = arr[len1][len2];
        System.out.println(next);

        int i = len1;
        int j = len2;
        while(next>0){
            int now = arr[i][j];
            while(true){
                if(arr[i-1][j-1]==now){
                    i--;
                    j--;
                }
                else if(arr[i][j-1]==now){
                    j--;
                }
                else if(arr[i-1][j]==now){
                    i--;
                }
                else{
                    i--;
                    j--;
                    next--;
                    break;
                }
            }
            sb.append(s1.charAt(i));
        }
        System.out.println(sb.reverse());
    }
}