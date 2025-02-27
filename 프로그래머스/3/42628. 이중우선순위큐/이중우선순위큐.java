import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String s:operations){
            st = new StringTokenizer(s);
            if(st.nextToken().equals("I")){
                int n = Integer.parseInt(st.nextToken());
                map.put(n, map.getOrDefault(n, 0)+1);
            }else{
                if(map.isEmpty())continue;
                if(st.nextToken().equals("1")){
                    Map.Entry<Integer, Integer> entry = map.lastEntry();
                    if(entry.getValue() == 1)map.remove(entry.getKey());
                    else map.replace(entry.getKey(), entry.getValue()-1);
                    
                } else {
                    Map.Entry<Integer, Integer> entry = map.firstEntry();
                    if(entry.getValue() == 1) map.remove(entry.getKey());
                    else map.replace(entry.getKey(), entry.getValue()-1);
                }
            }
        }
        
        if(map.isEmpty())return new int[]{0, 0};
        else return new int[]{map.lastKey(), map.firstKey()};
    }
}