import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        int[][][] arr = new int[len1+1][len2+1][len3+1];

        for(int i = 1;i<=len1;i++){
            char c1 = s1.charAt(i-1);
            for(int j=1;j<=len2;j++){
                char c2 = s2.charAt(j-1);
                for(int k=1;k<=len3;k++){
                    if(c1 == c2 && c2 == s3.charAt(k-1)) arr[i][j][k] = arr[i-1][j-1][k-1]+1;
                    else arr[i][j][k] = Math.max(Math.max(arr[i-1][j][k], arr[i][j-1][k]), arr[i][j][k-1]);

                }
            }
        }

        System.out.println(arr[len1][len2][len3]);

    }
}