import java.util.*;

class Solution {

    
    public int[] solution(int n, int s) {

        int[] arr = new int[n];
        
        Arrays.fill(arr, s/n);
        
        int tries = s%n;
        if(s<n) return new int[]{-1};
        
        int i=n-1;
        while(tries-->0){
            arr[i--]++;
        }
        
        return arr;
    }
    
}