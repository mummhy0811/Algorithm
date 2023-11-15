import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = br.readLine().toCharArray();
        int[] checkNum = new int[26];
        Arrays.fill(checkNum, 0);

        List<Character> list = new ArrayList<>(chars.length);
        for(char a:chars){
            list.add(a);
            checkNum[(int) a - 65]++;
        }

        boolean hasOdd = false;
        char oddChar = 0;
        for(int i=0;i<26;i++){
            int c = checkNum[i];
            if(c%2!=0) {
                if(hasOdd){
                    bw.write("I'm Sorry Hansoo");
                    bw.flush();
                    return;
                }
                hasOdd=true;
                oddChar=(char) (i + 65);
            }
        }

        list = list.stream().sorted().distinct().collect(Collectors.toList());
        StringBuilder s = new StringBuilder();
        for(Character c:list){
            int n = checkNum[(int)c-65]/2;
            if(n%2!=0) {
                s.append(String.valueOf(c).repeat(n));
                continue;
            }
            if(n>1) s.append(String.valueOf(c).repeat(n));
        }

        String ss = new String(s);
        StringBuilder s2 = new StringBuilder();
        s2.append(ss).reverse();

        if(hasOdd) {
            int n=checkNum[(int) oddChar - 65];
            if(n>1) s.append(oddChar);
            else s.append(String.valueOf(oddChar).repeat(n));
        }

        s.append(s2);

        bw.write(s+"");
        bw.flush();
        bw.close();
    }
}