class Solution {
    public String solution(String number, int k) {
        
        int len = number.length() - k;
        
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        int end = k;
        
        int i = 0;
        while(i++<len){

            int num = 0;
            for(int j=start; j<=end;j++){
                int now = number.charAt(j)-'0';
                if(num<now){
                    num = now;
                    start = j+1;
                }
            }
            end++;
            sb.append(num);

            if(sb.length()<len &&(start==end)){
                sb.append(number.substring(start, number.length()));
                break;
            }
        }

        return sb.toString();
    }
}