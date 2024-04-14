import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] k = renameToInt(st.nextToken());
        int[] d = renameToInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        while(n-->0){
            switch(br.readLine()){
                case "R":
                    if(k[1]+1<=7){
                        if(d[0]==k[0]&&d[1]==k[1]+1){
                            if(d[1]+1>7){
                                continue;
                            }
                            d[1]+=1;
                        }
                        k[1]+=1;
                    }
                    break;
                case "L":
                    if(k[1]-1>=0){
                        if(d[0]==k[0]&&d[1]==k[1]-1){
                            if(d[1]-1<0)continue;
                            d[1]-=1;
                        }
                        k[1]-=1;
                    }
                    break;
                case "B":
                    if(k[0]-1>=1){
                        if(d[1]==k[1]&&d[0]==k[0]-1){
                            if(d[0]-1<1) continue;
                            d[0]-=1;
                        }
                        k[0]-=1;
                    }
                    break;
                case "T":
                    if(k[0]+1<=8){
                        if(d[1]==k[1]&&d[0]==k[0]+1){
                            if(d[0]+1>8) continue;
                            d[0]+=1;
                        }
                        k[0]+=1;
                    }
                    break;
                case "RT":
                    if(k[1]+1<=7 && k[0]+1<=8){
                        if(d[0]==k[0]+1 && d[1]==k[1]+1){
                            if(d[1]+1>7 || d[0]+1>8)continue;
                            d[0]+=1;
                            d[1]+=1;
                        }
                        k[0]+=1;
                        k[1]+=1;
                    }
                    break;
                case "LT":
                    if(k[1]-1>=0 && k[0]+1<=8){
                        if(d[0]==k[0]+1 &&d[1]==k[1]-1){
                            if(d[1]-1<0 || d[0]+1>8)continue;
                            d[0]+=1;
                            d[1]-=1;
                        }
                        k[0]+=1;
                        k[1]-=1;
                    }
                    break;
                case "RB":
                    if(k[1]+1<=7 && k[0]-1>=1){
                        if(d[0]==k[0]-1&&d[1]==k[1]+1){
                            if(d[1]+1>7 || d[0]-1<1){
                                continue;
                            }
                            d[0]-=1;
                            d[1]+=1;
                        }
                        k[0]-=1;
                        k[1]+=1;
                    }
                    break;
                case "LB":
                    if(k[1]-1>=0 && k[0]-1>=1){
                        if(d[0]==k[0]-1&&d[1]==k[1]-1){
                            if(d[1]-1<0 || d[0]-1<1){
                                continue;
                            }
                            d[0]-=1;
                            d[1]-=1;
                        }
                        k[0]-=1;
                        k[1]-=1;
                    }
                    break;
            }

        }
        bw.write(renameToString(k)+"\n"+renameToString(d));
        bw.flush();
        bw.close();
    }

    static int[] renameToInt(String s){
        return new int[]{(s.charAt(1)-'0'),s.charAt(0)-65 };
    }
    static String renameToString(int[] arr){
        return String.valueOf((char) (arr[1] + 65)) + arr[0];
    }
}