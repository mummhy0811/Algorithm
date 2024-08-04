import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Integer> belt = new ArrayList<>();
        for(int i=0;i<n;i++){
            belt.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> now = new ArrayList<>();
        for(int i=0;i<k;i++){
            int init = belt.get(i);
            now.add(init);
            belt.add(init);
        }

        Set<Integer> maxSet = new HashSet<>();
        for(int i = 0; i<n; i++){
            Set<Integer>set = new HashSet<>(now);
            if(maxSet.size()<set.size() || (maxSet.size()==set.size() && !maxSet.equals(set) && !now.contains(c)) ){
                maxSet=set;
            }
            now.remove(belt.get(i));
            now.add(belt.get(i+k));
        }
        if(!maxSet.contains(c)) bw.write((maxSet.size()+1)+"");
        else bw.write(maxSet.size()+"");
        bw.flush();
        bw.close();
    }
}