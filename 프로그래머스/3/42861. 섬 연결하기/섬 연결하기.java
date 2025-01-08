import java.util.*;

class Solution {
    static int answer = 0;
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        
        parents = new int[n];
        for(int i=0;i<n;i++) parents[i] = i;
        
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        
        for(int[] cost: costs){
            int a = cost[0];
            int b = cost[1];
            
            if(findParents(a)!=findParents(b)){
                union(a, b);
                answer+=cost[2];
            }
        }
        
        return answer;
    }
    
    private static void union(int a, int b){
        int pa = findParents(a);
        int pb = findParents(b);
        
        if(pa>pb) parents[pa] = pb;
        else parents[pb] = pa;
    }
    
    private static int findParents(int x){
        if(parents[x] != x) parents[x] = findParents(parents[x]);
        return parents[x];
    }
    
}