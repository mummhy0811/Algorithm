import java.io.*;
import java.util.HashSet;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();

        
        int num=0;
        for(int length=1;length<=string.length();length++){
            HashSet<String> set = new HashSet();
            for(int i=0;i+length<=string.length();i++){
                String ss = string.substring(i, i+length);
                set.add(ss);
            }
            num+=set.size();
        }
        bw.write(num+"");
        bw.flush();
        bw.close();
    }

}