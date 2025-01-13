import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine().replace(" ","");
        List<int[]> list = new ArrayList<>();

        int i = 0;
        while(i<N){
            char before = s.charAt(i);
            int j=i+1;
            int cnt = 1;
            while(j<N){
                if(s.charAt(j) != before){
                    break;
                }
                cnt++;
                j++;
            }
            list.add(new int[]{Integer.parseInt(before+""),cnt});
            i = j;
        }

        int max = list.get(0)[1];

        int l = 0, r = 1;
        while(l<r && r<list.size()){
            int cnt = list.get(l)[1]+list.get(r)[1];

            int k;
            for(k=r+1;k<list.size();k++){
                int next = list.get(k)[0];
                if( next == list.get(l)[0] || next == list.get(r)[0]){
                    cnt+=list.get(k)[1];
                }else{
                    break;
                }
            }

            max = Math.max(max, cnt);
            r = k;
            l = k-1;
        }
        System.out.println(max);
    }
}