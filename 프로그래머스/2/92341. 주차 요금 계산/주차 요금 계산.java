import java.util.*;

class Solution {
    static Map<String, String> map; // 번호, 입차 시각
    static Map<String, Integer> fin; // 번호, 총 시간(분)
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        map = new TreeMap<>();
        fin = new TreeMap<>();
        
        for(int i=0;i<records.length;i++){
            st = new StringTokenizer(records[i]);
            String t = st.nextToken();
            String num = st.nextToken();
            String s = st.nextToken();
            if(s.equals("IN")) map.put(num, t);
            else {
                calcMin(num, t); //시간 저장(분)
                map.remove(num);
            }
        }
        for(String s : map.keySet()){
            calcMin(s, "23:59");
        }
        //돈 계산
        
        int[] answer = new int[fin.size()];
        int idx=0;
        for(String s : fin.keySet()){
            answer[idx++] = calcMoney(s, fees);
        }
        return answer;
    }
    private void calcMin(String num, String out){
        String in = map.get(num);
        StringTokenizer st = new StringTokenizer(in, ":");
        int in_H = Integer.parseInt(st.nextToken());
        int in_M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(out, ":");
        int out_H = Integer.parseInt(st.nextToken());
        int out_M = Integer.parseInt(st.nextToken());
        
        if(in_M>out_M){
            out_H--;
            out_M+=60;
        }
        int m = (out_H - in_H)*60+( out_M - in_M);
        
        if(fin.containsKey(num)){
            m+=fin.get(num);
        }
        fin.put(num, m);
    }
    private int calcMoney(String num, int[] fees){

        int t = fin.get(num);
        if(t<fees[0]) return fees[1];

        double time = (t-fees[0])/fees[2];
        if((t-fees[0])%fees[2]>0) time++;
        return fees[1]+(int)time*fees[3];
    }
}