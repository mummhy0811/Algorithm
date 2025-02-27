import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int maxWidth = 0, maxHeight = 0;
        int minWidth , minHeight;

        int maxWidthIdx = -1, maxHeightIdx = -1;

        int[] len = new int[6];

        for(int i=0;i<6;i++){
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            len[i] = num;

            if(direction<=2 && num>=maxWidth ){
                maxWidth = num;
                maxWidthIdx = i;
            }else if(direction>2 && num>=maxHeight){
                maxHeight = num;
                maxHeightIdx = i;
            }
        }

        int beforeIdx = maxWidthIdx-1<0 ? 5 :maxWidthIdx-1;
        int afterIdx = maxWidthIdx+1>5 ? 0 :maxWidthIdx+1;
        minHeight = maxHeight-Math.min(len[beforeIdx], len[afterIdx]);

        beforeIdx = maxHeightIdx-1<0 ? 5 :maxHeightIdx-1;
        afterIdx = maxHeightIdx+1>5 ? 0 :maxHeightIdx+1;
        minWidth = maxWidth-Math.min(len[beforeIdx], len[afterIdx]);

        System.out.println((maxWidth * maxHeight - minWidth*minHeight)*n);
    }
}