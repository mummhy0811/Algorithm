import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int sum=64;
        Stack<Integer> stack = new Stack<>();
        stack.push(64);
        while(sum!=n){
            int min=stack.pop();
            min/=2;
            if(sum-min>=n){
                sum-=min;
                stack.push(min);
            }else{
                stack.push(min);
                stack.push(min);
            }
        }
        bw.write(stack.size()+"");
        bw.flush();
        bw.close();
    }
}