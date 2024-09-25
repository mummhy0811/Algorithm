class Solution {
    
    public long solution(int[] diffs, int[] times, long limit) {
        long l=1L, r=limit;
        while(l<r){
            long mid = (l+r)/2;
            if(calc(diffs, times, mid)>limit){//level을 올려야함
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return r;
    }
    private long calc(int[] diffs, int[] times, long level){
        long total =0 ;
        for(int i=0;i<diffs.length;i++){
            if(diffs[i]<=level){
                total+=times[i];
            }else{
                total+=((diffs[i]-level)*(times[i]+times[i-1])+times[i]);
            }
        }
        return total;
    }
}