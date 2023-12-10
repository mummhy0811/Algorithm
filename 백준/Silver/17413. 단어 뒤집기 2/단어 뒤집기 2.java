import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ><", true);
        String[] arr = new String[st.countTokens()];

        for(int i=0;i< arr.length;i++){
            arr[i]=st.nextToken();
        }

        boolean skip=false;
        for (String s : arr) {

            switch (s) {
                case "<" : {
                    bw.write(s);
                    skip = true;
                    continue;
                }
                case ">" : {
                    bw.write(s);
                    skip = false;
                    continue;
                }
                case " " : {
                    bw.write(s);
                    continue;
                }
            }

            if (skip) {
                bw.write(s);
            } else{
                StringBuilder sb = new StringBuilder();
                sb.append(s).reverse();
                bw.write(sb.toString());
            }

        }

        bw.flush();
        bw.close();
    }

}