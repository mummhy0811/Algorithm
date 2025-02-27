class Solution {
    public int[] solution(int brown, int yellow) {
        
        for(int r=3;r<1000000;r++){
            for(int c=3;c<=r;c++){
                if((r-2)*(c-2)==yellow && r*2+(c-2)*2 == brown){
                    return new int[]{r, c};
                }
            }
        }
        
        return new int[]{0, 0};
    }
}