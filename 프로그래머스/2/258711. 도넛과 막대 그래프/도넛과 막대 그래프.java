import java.util.*;

class Solution {    
    public int[] solution(int[][] edges) {
        int center=0, stick=0, eight=0;
        Map<Integer, int[]> nodes = new HashMap<>(); 
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];

            if(!nodes.containsKey(from)){
                nodes.put(from, new int[]{0,0});
            }
            if(!nodes.containsKey(to)){
                nodes.put(to, new int[]{0,0});
            }
          
            nodes.get(from)[0]++;
            nodes.get(to)[1]++;
        }

        for( int key : nodes.keySet()){
            int[] count = nodes.get(key);

            if(count[0] >= 2 && count[1] == 0) {
                center = key;
            }else if(count[0] == 0 && count[1] > 0) {
                stick++;
            }else if(count[0] >= 2 && count[1] >= 2) {
                eight++;
            }
        }

        return new int[]{ center,  nodes.get(center)[0] - stick - eight, stick, eight };
    }
}