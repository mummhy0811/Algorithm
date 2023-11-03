import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] words = new char[n][];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            words[i]= s.toCharArray();
        }
        int count=n;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(words[i].length==1){
                continue;
            }
            set.clear();
            set.add(words[i][0]);
            for(int j=1;j<words[i].length;j++){
                if(words[i][j]==words[i][j-1]) continue;
                else if(words[i][j]!=words[i][j-1] && !set.contains(words[i][j])){
                    set.add(words[i][j]);
                }else if(words[i][j]!=words[i][j-1] && set.contains(words[i][j])){
                    count--;
                    break;
                }
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}