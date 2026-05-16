import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;
        int answer = 0;
        
        while(idx<B.length){
            //내가 지면 -> 내 다음꺼 가져오기.(그 다음것도 진다면.)
            int target = A[idx];
            
            if(target>=B[idx]){
                for(int j=idx;j<B.length;j++){
                    
                    //다음 수로 이길 수 있고, 그 수는 A에게 진다면
                    if(target<B[j] && A[j]>=B[j]){
                        
                        int tmp = B[idx];
                        B[idx] = B[j];
                        B[j] = tmp;
                        
                        break;
                    }
                }
            }
            
            if(target<B[idx]) answer++;
            
            idx++;
        }

        return answer;
    }
}
