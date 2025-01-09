import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            String[] func = br.readLine().split("");
            br.readLine();
            Deque<String> deque = parseInput(br.readLine());

            boolean isReversed = false;
            boolean hasError = false;

            for(String s:func){
                if(s.equals("R")) isReversed = !isReversed;
                else if(s.equals("D")){
                    if(deque.isEmpty()){
                        hasError = true;
                        bw.write("error\n");
                        break;
                    }
                    if(isReversed) deque.pollLast();
                    else deque.pollFirst();
                }
            }
            if (!hasError) {
                bw.write(formatOutput(deque, isReversed));
            }
        }

        bw.flush();
        bw.close();
    }
    private static Deque<String> parseInput(String input) {
        if (input.equals("[]")) {
            return new LinkedList<>();
        }
        String[] elements = input.replaceAll("[\\[\\]]", "").split(",");
        return new LinkedList<>(Arrays.asList(elements));
    }
    private static String formatOutput(Deque<String> deque, boolean isReversed) {
        StringBuilder sb = new StringBuilder("[");
        Iterator<String> iterator = isReversed ? deque.descendingIterator() : deque.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) sb.append(",");
        }
        sb.append("]\n");
        return sb.toString();
    }
}