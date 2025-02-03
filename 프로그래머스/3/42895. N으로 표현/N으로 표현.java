import java.util.*;

class Solution {
    
    public int solution(int N, int number) {
        if(number == N) return 1;

        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0;i<=8;i++){
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);

        for(int i=2;i<=8;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<i;j++){
                sb.append(N);
            }
            list.get(i).add(Integer.parseInt(sb.toString()));
            
            for(int j=1;j<i;j++){
                int k = i-j;
                Set<Integer> set1 = list.get(j);
                Set<Integer> set2 = list.get(k);
                
                for(Integer i1:set1){
                    for(Integer i2: set2){
                        list.get(i).add(i1+i2);
                        list.get(i).add(i1-i2);
                        list.get(i).add(i1*i2);
                        if(i2!=0) list.get(i).add(i1/i2);
                    }
                }
            }

            
            if(list.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}
