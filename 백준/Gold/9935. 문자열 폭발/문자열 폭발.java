import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String target = br.readLine();

        Stack<Character> cStack = new Stack<>();
        Stack<Integer> pStack = new Stack<>();

        int pos = 0;
        int len = target.length();

        for(int i=0;i<s.length();i++){

            if(s.charAt(i)==target.charAt(pos)) {}
            else if(s.charAt(i)==target.charAt(0)) pos = 0;
            else pos = -1;

            cStack.push(s.charAt(i));
            pStack.push(pos++);
            if(pos == len){
                for(int j=0;j<pos;j++) {
                    cStack.pop();
                    pStack.pop();
                }
                pos = pStack.isEmpty() ? 0 : pStack.peek()+1;
            }
        }

        if(cStack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            while(!cStack.isEmpty()){
                sb.append(cStack.pop());
            }
            System.out.println(sb.reverse());
        }
    }
}