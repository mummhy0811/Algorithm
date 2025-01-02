class Solution {
    public int solution(int[] money) {

        int length = money.length;
        int[] with = new int[length];
        int[] without = new int[length];
        
        with[0] = money[0];
        with[1] =  money[0];
        
        without[0] = 0;
        without[1] = money[1];


        for(int i=2;i<length;i++){
            
            without[i] = Math.max(without[i-1], without[i-2]+money[i]);
            
            if(i==length-1) continue;
            with[i] = Math.max(with[i-1], with[i-2]+money[i]);

        }
        without[length-1] = Math.max(without[length-1], without[length-3]+money[length-1]);
        
        return Math.max(without[length-1], with[length-2]);
    }
}