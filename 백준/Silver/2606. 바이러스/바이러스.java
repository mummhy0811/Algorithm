import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int comNum = Integer.parseInt(br.readLine());
        int linked = Integer.parseInt(br.readLine());

        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0;i<=comNum;i++) arr.add( new ArrayList<>());

        for(int i=0;i<linked;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arr.get(num1).add(num2);
            arr.get(num2).add(num1);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] checkWorm = new boolean[comNum+1];
        Arrays.fill(checkWorm, false);

        int count=0;
        stack.add(1);

        while(!stack.isEmpty()){
            int now = stack.pop();
            if(!checkWorm[now]){
                checkWorm[now] = true;
                List<Integer> linkedCom = arr.get(now);
                linkedCom.forEach(c ->{
                    if(!checkWorm[c] && !stack.contains(c)) stack.add(c);
                });
                count++;
            }
        }
        bw.write(count-1+"");
        bw.flush();
        bw.close();
    }
}