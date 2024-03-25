import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i=0;i<n;i++) tree.add(Integer.parseInt(br.readLine()));
        for(int i:tree){
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}