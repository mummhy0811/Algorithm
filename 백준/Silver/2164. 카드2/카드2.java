import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        for(int i=1;i<=N;i++) deque.addLast(i);

        while(deque.size()>=2){
            deque.poll();
            if(deque.size()>=2) deque.addLast(deque.poll());
        }
        System.out.println(deque.poll());
    }
}