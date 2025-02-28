import java.util.*;

class Solution {
    public int solution(String name) {
        int change = 0, len = name.length(), move = name.length()-1;
        
        for(int i=0;i<len;i++){
            //알파벳 변경
            char c = name.charAt(i);
            change += (c <= 'N') ? (c - 'A') : ('Z' - c + 1);
            
            //최소 이동 방향 계산
            int idx = i+1;
            while(idx<len && name.charAt(idx)=='A') idx++;
            
            move = Math.min(move, Math.min(i*2+(len-idx), i+(len-idx)*2));
        }
        
        System.out.println(change +" "+move);
        return change + move;
    }
}