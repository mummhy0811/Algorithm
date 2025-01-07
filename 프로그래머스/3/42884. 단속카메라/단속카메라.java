import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 1. 끝점을 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        
        int answer = 0;
        int lastCamera = Integer.MIN_VALUE;
        
        // 2. 정렬된 차량 경로를 탐색
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            // 현재 구간이 마지막 설치된 카메라의 범위 밖에 있다면
            if (lastCamera < start) {
                answer++; // 새로운 카메라 설치
                lastCamera = end; // 카메라를 현재 구간의 끝 지점에 설치
            }
        }
        
        return answer;
    }
}
