import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int result = 1;
        lis[0]=arr[0];
        int idx=0;
        for(int i=1;i<n;i++) {
            if (lis[idx] < arr[i]) {
                lis[++idx] = arr[i];
                continue;
            }

            int l = 0, r = idx, m;
            while (l <= r) {
                m = (l + r) / 2;
                if (l == r) {
                    lis[l] = arr[i];
                    break;
                } else if (lis[m] > arr[i]) {
                    r = m;
                } else if (lis[m] < arr[i]) {
                    l = m + 1;
                } else if(lis[m]==arr[i]) break;
            }

        }
        bw.write((idx+1)+"");
        bw.flush();
        bw.close();
    }
}