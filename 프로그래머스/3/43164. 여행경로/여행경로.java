import java.util.*;

class Solution {

    private static boolean[] visit;
    private static String[][] tickets;
    private static List<String> ans;
    
    public String[] solution(String[][] _tickets) {
        tickets = _tickets;
        int ticket_cnt = _tickets.length;
        
        ans = new ArrayList<>();
        
        for(int i=0;i<ticket_cnt;i++){
            if(tickets[i][0].equals("ICN")) {
                visit = new boolean[ticket_cnt];
                
                visit[i]=true;
                List<String> l = new ArrayList<>();
                l.add("ICN");
                
                make(l,tickets[i][1], ticket_cnt+1);
            }
        }
        
        Collections.sort(ans);

        String input = ans.get(0).replaceAll("[\\[\\]\"]", "");
        String[] result = input.split(",\\s*");
        return result;
    }
    
    private void make(List<String> list, String start, int target){
        
        list.add(start);

        
        if(list.size() >= target){
            ans.add(list.toString());
            list.remove(list.size() - 1); // 상태 복구

            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals(start) && !visit[i]) {
                visit[i] = true;
                make(list, tickets[i][1], target);
                visit[i] = false;
            }
        }
        list.remove(list.size() - 1); // 리스트 상태 복구
    } 
}