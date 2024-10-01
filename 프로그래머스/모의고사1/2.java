class Solution {
    static int max=0;
    static int[] std;
    static boolean used[];
    static int[][] ability;

    public int solution(int[][] _ability) {
        ability = _ability;
        std = new int[ability[0].length]; //각 종목에 대한 학생
        used = new boolean[ability.length];
        //모든 경우의 수

        find(0, 0);
        
        return max;
    }

    private void find(int depth, int p){
        if(depth==std.length){
            int sum = 0;
            for(int i=0;i<std.length;i++){
                sum+=ability[std[i]][i];
            }
            max=Math.max(sum, max);
            return;
        }

        for(int i=0;i<used.length;i++){
            if(!used[i]){
                std[depth]=i;
                used[i]=true;
                find(depth+1, p++);
                used[i]=false;
            }
        }
    }
}