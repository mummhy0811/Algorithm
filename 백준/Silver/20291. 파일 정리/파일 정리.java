import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String name = st.nextToken();
            if(map.containsKey(name)) map.replace(name, map.get(name)+1);
            else map.put(name, 1);
        }
        List<String> keys = map.keySet().stream().sorted().collect(Collectors.toList());
        for(String k:keys){
            bw.write(k+" "+map.get(k)+"\n");
        }
        bw.flush();
        bw.close();
    }

}