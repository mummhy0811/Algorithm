import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int h = triangle.length;
        
        int[][] calc = new int[h][h]; 
        calc[0][0] = triangle[0][0];

        for(int i=1;i<h;i++){
            for(int j=0;j<triangle[i].length;j++){

                if(j-1>=0){
                    calc[i][j] =triangle[i][j]+calc[i-1][j-1]; //왼
                }
                if(triangle[i-1].length>j){
                    calc[i][j] = Math.max(calc[i][j], triangle[i][j]+calc[i-1][j]); //오
                }                
            }
        }

        for(int i=0;i<calc[h-1].length;i++){
            answer = Math.max(answer, calc[h-1][i]);
        }
        
        return answer;
    }
}