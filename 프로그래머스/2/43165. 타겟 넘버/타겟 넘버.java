class Solution {
    static int answer =0 ;
    static int[] numbers;
    static int target;
    
    public int solution(int[] number, int t) {
        numbers=number;
        target=t;

        check(0, 0, true);
        check(0, 0, false);
        
        return answer;
    }
    
    private static void check(int depth, int n, boolean isNeg){
        
        if(isNeg){
            n-=numbers[depth];
        }else{
            n+=numbers[depth];
        }
        
        if(depth==numbers.length-1){
            if(n == target){
                answer++;
            }
            return;
        }
        
        check(depth+1, n, true);
        check(depth+1, n, false);
    }
}