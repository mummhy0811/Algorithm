import java.util.*;

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int max=1, now=0, prevEnd=0;
        Queue<Integer> cooking = new LinkedList<>();

        for(int i=0;i<order.length;i++){
            //다음 사람이 들어오기 전에 나갈 사람 내보냄
            while(!cooking.isEmpty() && cooking.peek()<=now){
                cooking.poll();
            } 
            if(prevEnd<now) prevEnd = now+menu[order[i]];
            else prevEnd+=menu[order[i]]; //내 요리가 끝나는 시간
            
            cooking.add(prevEnd);
            now+=k;
            max=Math.max(max, cooking.size()); 
        }
        return max;
    }
}