class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[28];
        boolean[] isLonely = new boolean[28];

        char pre = ' ';

        for(int i=0;i<s.length();i++){

            int n = s.charAt(i)-97;
            if(arr[n]>0 && pre!=s.charAt(i)){
                isLonely[n]=true;
            }
            arr[n]++;
            pre = s.charAt(i);
        }

        for(int i=0;i<arr.length;i++){
            if(isLonely[i])
                sb.append((char)('a'+i));
        }
        if(sb.toString().length()==0) return "N";
        return sb.toString();
    }
}