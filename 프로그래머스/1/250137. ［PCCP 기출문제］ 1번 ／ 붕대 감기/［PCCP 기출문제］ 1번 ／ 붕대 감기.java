class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int maxHealth = health;
        int idx=0;
        int conti;
        
        while(idx<attacks.length-1){
            health-=attacks[idx][1];

            if(health<=0) return -1;

            int now = attacks[idx][0];
            int next = attacks[++idx][0];
            conti = (next-now-1);

            if(conti>=bandage[0]){
                int t = conti / bandage[0];
                if(t==0) t++;
                health=health+((bandage[0]*bandage[1]+bandage[2])*t)+(bandage[1]*(conti%bandage[0]));
            }else if(conti>0){
                health+=(bandage[1]*conti);
            }
            if(health>maxHealth) health = maxHealth;
        }
        
        health-=attacks[attacks.length-1][1];
        if(health<=0) return -1;
        
        return health;
    }
}