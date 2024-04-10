import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> ansList = new ArrayList<>();

        Set<String> listen = new TreeSet<>();
        for(int i=0;i<n;i++){
            listen.add(br.readLine());
        }
        for(int i=0;i<m;i++){
            String name = br.readLine();
            if(listen.contains(name)){
                ansList.add(name);
            }
        }

        Collections.sort(ansList);
        bw.write(ansList.size()+"\n");
        for(String name:ansList){
            bw.write(name+"\n");
        }
        bw.flush();
        bw.close();
    }
}