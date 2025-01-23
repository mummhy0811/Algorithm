import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(br.readLine());

        int next = 1, idx = 0;
        Stack<Integer> stack = new Stack<>();
        
        while(idx<n){
            int target = arr[idx];
            if(target>=next){
                for(int i = next;i<=target;i++){
                    stack.add(i);
                    sb.append("+\n");
                    next++;
                }
            }else{
                if(stack.isEmpty() || stack.peek() != target){
                    System.out.println("NO");
                    return;
                }
            }
            stack.pop();
            sb.append("-\n");
            idx++;
        }
        System.out.println(sb);
    }
}