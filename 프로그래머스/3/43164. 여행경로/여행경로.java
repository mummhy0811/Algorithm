import java.util.*;

class Solution {

    public String[] solution(String[][] tickets) {

        String[] answer = new String[tickets.length+1];

        Map<String, List<String>> map = new HashMap<>();
        
        for (String[] c : tickets) {
            String from = c[0];
            String to = c[1];

            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(to);
        }

        for (List<String> list : map.values()) {
            Collections.sort(list);
        }
        
        find("ICN", 0, answer,map);

        
        return answer;
    }
    
    public boolean find(String from, int idx, String[] answer, Map<String, List<String>> map){
        
        answer[idx] = from;
        
        //모든 티켓 사용 완료
        if (idx == answer.length - 1) {
            return true;
        }

        List<String> list = map.get(from);
        
        //항공권 없음 - 종료
        if (list == null) {
            return false;
        }

        
        for(int i=0;i<list.size();i++){
            String next = list.get(i);
            
            list.remove(i);
            map.replace(from, list);
            
            if (find(next, idx + 1, answer, map)) {
                return true;
            }
            
            list.add(i, next);
            map.replace(from, list);
        }
        return false;
        
    }
    
}