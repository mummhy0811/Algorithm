import java.util.*;

class Solution {
    static boolean[] visit;
    static int[][] computers;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        visit = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visit[i]) {
                find(i, n);
                answer++;
            }
        }

        return answer;
    }
    private static void find(int x, int n){
        Stack<Integer> st = new Stack<>();
        st.push(x);
        
        while(!st.isEmpty()){
            int now = st.pop();
            visit[now]=true;
            for(int i=0;i<n;i++){
                    if(computers[now][i]==1 && !visit[i]){
                        visit[i]=true;
                        st.push(i);
                    }
                }
        }
    }
}