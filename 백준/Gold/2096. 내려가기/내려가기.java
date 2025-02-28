import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] minScore = new int[3];
        int[] maxScore = new int[3];

        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int j=0;j<3;j++){
            maxScore[j] = minScore[j] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<n;i++){
            int[] thisLine = new int[3];
            st  = new StringTokenizer(br.readLine());
            thisLine[0] = Integer.parseInt(st.nextToken());
            thisLine[1] = Integer.parseInt(st.nextToken());
            thisLine[2] = Integer.parseInt(st.nextToken());

            int[] tmpMinScore = new int[3];
            int[] tmpMaxScore = new int[3];

            for(int j=0;j<3;j++){
                int left = j-1<0? Integer.MAX_VALUE : minScore[j-1];
                int right = j+1>=3?  Integer.MAX_VALUE :minScore[j+1];
                tmpMinScore[j] = (thisLine[j]+Math.min(left, Math.min(minScore[j], right)));

                left = j-1<0? 0: maxScore[j-1];
                right = j+1>=3?  0 :maxScore[j+1];
                tmpMaxScore[j] = (thisLine[j]+Math.max(left, Math.max(maxScore[j], right)));
            }

            minScore = tmpMinScore;
            maxScore = tmpMaxScore;
        }

        int min = Integer.MAX_VALUE, max = 0;
        for(int i=0;i<3;i++){
            min = Math.min(min, minScore[i]);
            max = Math.max(max, maxScore[i]);
        }

        System.out.println(max+" "+min);
    }
}