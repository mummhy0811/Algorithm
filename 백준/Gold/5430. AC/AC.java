import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String[] func = br.readLine().split("");
            br.readLine();
            String input = br.readLine();
            String[] arr;
            if (input.equals("[]")) {
                arr = new String[0];
            } else {
                arr = input.replaceAll("[\\[\\]]", "").split(",");
            }
            Deque<String> deque = new LinkedList<>(Arrays.asList(arr));

            boolean isReversed = false;
            boolean error = false;

            for(String s:func){
                if(s.equals("R")) isReversed = !isReversed;
                else if(s.equals("D")){
                    if(deque.isEmpty()){
                        error = true;
                        break;
                    }
                    if(isReversed) deque.pollLast();
                    else deque.poll();
                }
            }
            if(error) bw.write("error\n");
            else{
                if(isReversed) {
                    List<Object> reversed = Arrays.asList(deque.toArray());
                    Collections.reverse(reversed);
                    bw.write(reversed.toString().replaceAll(" ","")+"\n");
                }else {
                    bw.write(deque.toString().replaceAll(" ","")+"\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}