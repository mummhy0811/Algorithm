import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] check = new int[n+1][n+1];
        int[] cnt = new int[n+1];
        
        
        for(int[] r: results){
            int winner = r[0];
            int loser = r[1];
            check[winner][loser] = 1;
            check[loser][winner] = -1;
            cnt[winner]++;
            cnt[loser]++;
        }
        
        
        for(int i=1;i<=n;i++){
            List<Integer> stronger = new ArrayList<>();
            List<Integer> weaker = new ArrayList<>();
            for(int j=1;j<=n;j++){
                if(check[i][j]==-1){
                    stronger.add(j);
                }else if(check[i][j]==1){
                    weaker.add(j);
                }
            }
            
            for(Integer w: weaker){
                for(Integer s: stronger){
                    if(check[w][s] == 0){
                        check[w][s] = -1;
                        check[s][w] = 1;
                        cnt[s]++;
                        cnt[w]++;
                    }
                    
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            if(cnt[i] == n-1) answer++;
        }
        return answer;
    }
}