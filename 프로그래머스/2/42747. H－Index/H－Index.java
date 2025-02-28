import java.util.*;
class Solution {
    public int solution(int[] citations) {

        int len = citations.length;
        Arrays.sort(citations);
        for(int i=len-1 ; i>=0;i--){
            int h = citations[i];
            
            int cnt = 0, j=i-1;
            for(;j>=0;j--){
                if(citations[i] != citations[j]) break;
                cnt++;
            }
            
            if(len-i+cnt>=h && j+1<=h ) {
                return Math.max(h, len-i-cnt-1);
            }
            i=i-cnt;
        }
        return citations.length;
    }
}