import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int[] tmp = commands[i];
            
            answer[i] = sort(array, tmp[0], tmp[1], tmp[2]);

        }
        return answer;
    }
    
    public static int sort(int[] arr, int s, int e, int n){
        int[] sorted = Arrays.copyOfRange(arr, s-1,e);
        Arrays.sort(sorted);
        return sorted[n-1];
    }
}