import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] check = new int[n+1][n+1];
        
        for(int[] r: results){
            check[r[0]][r[1]] = 1;
            check[r[1]][r[0]] = -1;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (check[i][k] == 1 && check[k][j] == 1) { 
                        check[i][j] = 1;  // i가 k를 이기고, k가 j를 이기면 i는 j를 이김
                        check[j][i] = -1; // j는 i에게 짐
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (check[i][j] != 0) count++; 
            }
            if (count == n - 1) answer++; 
        }
        return answer;
    }
}