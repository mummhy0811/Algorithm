import java.io.*;
import java.util.*;

public class Main {

    static class Load implements Comparable{
        int s;
        int e;
        int l;
        Load(int s, int e, int l){
            this.s=s;
            this.e=e;
            this.l=l;
        }

        @Override
        public int compareTo(Object o) {
            Load l = (Load) o;
            if(this.e == l.e){
                return this.s-l.s;
            }
            return this.e-l.e;
        }
    }
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        arr = new int[20000];
        List<Load> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if(e>D || s>D) continue;
            list.add(new Load(s, e, l));
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            Load l = list.get(i);

            //직선길
            checkEmpty(l.s);
            checkEmpty(l.e);


            //현재 내 dp와, 지름길을 사용해서 왔을 때의 dp를 비교, 갱신
            if(l.l>(l.e-l.s)){ //걸어가는 게 나으면
                if(arr[l.e]>arr[l.s]+(l.e-l.s))
                    arr[l.e] = arr[l.s]+(l.e-l.s);
            }else{
                if(arr[l.e] > arr[l.s]+l.l){
                    arr[l.e] = arr[l.s]+l.l;//지름길 이용
                }

            }
        }

        if(!list.isEmpty()) bw.write(arr[list.get(list.size()-1).e]+(D-list.get(list.size()-1).e)+" ");
        else bw.write(D+"");

        bw.flush();
        bw.close();

    }
    private static void checkEmpty(int n){
        int pos=n;
        int min=n;
        for(int i=n;i>0;i--){
            if(min>arr[i] && arr[i]!=0){
                min=arr[i];
                pos=i;
                break;
            }
        }
//        System.out.println(min+" "+n+" "+pos);
        arr[n] = min+(n-pos);
    }

}