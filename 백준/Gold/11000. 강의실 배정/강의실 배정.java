import java.io.*;
import java.util.*;

public class Main {
    static class sugang implements Comparable<sugang> {
        int s, t;
        public sugang(int s, int t){
            this.s=s;
            this.t=t;
        }

        @Override
        public int compareTo(sugang o) {
            if(this.s==o.s) return this.t-o.t;
            return this.s-o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<sugang> sugangs = new ArrayList<>(N);

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            sugangs.add(new sugang(s, t));
        }

        Collections.sort(sugangs);

        PriorityQueue<Integer> classes = new PriorityQueue<>(); // 끝나는 시간 저장
        classes.add(sugangs.get(0).t);

        //먼저 끝나는 강의실이 우선 순위가 높아야 함.

        for(int i=1;i<N;i++){
            if(classes.peek()<=sugangs.get(i).s){
                classes.poll();
            }
            classes.add(sugangs.get(i).t);
        }

        bw.write(classes.size()+"");
        bw.flush();
        bw.close();
    }
}