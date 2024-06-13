import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            Integer n=0;
            if(map.containsKey(clothes[i][1])){
                n = map.get(clothes[i][1]);
            }
            map.put(clothes[i][1], n+1);
        }
        
        for(String s:map.keySet()){
            answer*=(map.get(s)+1);
        }
        return answer-1;
    }
}