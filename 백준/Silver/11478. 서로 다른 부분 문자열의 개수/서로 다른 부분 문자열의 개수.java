import java.io.*;
import java.util.HashSet;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();

        HashSet<String> set = new HashSet();

        for(int length=1;length<=string.length();length++){
            for(int i=0;i+length<=string.length();i++){
                String ss = string.substring(i, i+length);
                set.add(ss);
            }
        }
        bw.write(set.size()+"");
        bw.flush();
        bw.close();
    }

}