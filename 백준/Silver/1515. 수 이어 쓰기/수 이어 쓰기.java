import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Main {

    static List<Character> arr = new ArrayList<>();
    static int point=0;
    static int n=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] st = br.readLine().toCharArray();
        add();
        for (char c : st) {
            while (!find(c)) {
                add();
            }
        }
        bw.write(n+"");
        bw.flush();
        bw.close();
    }

    static boolean find(char s){
        for(int i=point; i<arr.size();i++){
            point++;
            if(arr.get(i).equals(s))
                return true;
        }
        return false;
    }

    static void add(){
        n++;
        for(char c:String.valueOf(n).toCharArray())
            arr.add(c);
    }
}