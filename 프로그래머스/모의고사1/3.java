import java.util.;

class Solution {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for(int i=0;iqueries.length;i++){
            answer[i]=find(queries[i][0], queries[i][1]);
        }
        return answer;
    }

    private String find(int gen, int bean){
        String[] gen2 = {RR, Rr, Rr, rr};

        if(gen==1){
            return Rr;
        }else if(gen==2){
            return gen2[bean-1];
        }else if(bean=Math.pow(4, gen-2)){ 앞쪽
            return RR;
        }else if(bean=Math.pow(4, gen-1)-Math.pow(4, gen-2)){ 뒤쪽
            return rr;
        }else{
            bean -= Math.pow(4, gen-2);
            if((int)Math.pow(4, gen-2)  bean) bean = bean % (int)Math.pow(4, gen-2);
            return find(gen-1, bean);
        }
    }
}