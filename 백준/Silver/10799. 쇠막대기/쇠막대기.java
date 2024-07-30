import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("\\(\\)");
        int l=0, ans=0;
        for(String s:arr ){
            int r=0;
            char[] now = s.toCharArray();
            for (char c : now) {
                if (c == '(') {
                    l++;
                } else {
                    r++;
                    l--;
                }
            }
            ans+=l;
            ans+=r;
        }
        System.out.println(ans);
    }
}