import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        int len = words[0].length();
        boolean[][] canChange = new boolean[n+1][n+1];
        boolean[][] visit = new boolean[n+1][n+1];
        
        int targetIdx = -1;
        
        for(int j=1;j<=n;j++){
            int cnt = 0;
            String s = begin;
            String now = words[j-1];

            for(int k=0;k<len;k++){
                if(s.charAt(k)!=now.charAt(k)) cnt++;
                if(cnt>2) break;
            }
            if(cnt<2){
                canChange[0][j]=true;
                canChange[j][0]=true;
            } 
        }
        
        for(int i=1;i<=n;i++){
            if(target.equals(words[i-1])) targetIdx = i;
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                int cnt = 0;
                String s = words[i-1];
                String now = words[j-1];
                for(int k=0;k<len;k++){
                    if(s.charAt(k)!=now.charAt(k)) cnt++;
                    if(cnt>2) break;
                }
                if(cnt<2) {
                    canChange[i][j]=true;
                    canChange[j][i]=true;
                }
            }
        }
        if(targetIdx==-1) return 0;
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()){
            int[] l = queue.poll();
            int now = l[0];
            int depth = l[1];
            
            if(now == targetIdx)return depth;
            
            for(int i=0;i<=n;i++){
                if(i==now) continue;
                if(canChange[now][i] && !visit[now][i]){
                    visit[now][i]=true;
                    queue.add(new int[]{i, depth+1});
                }
            }
        }
        
        return 0;
    }
}