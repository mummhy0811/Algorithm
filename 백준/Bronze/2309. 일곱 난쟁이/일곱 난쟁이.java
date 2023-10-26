import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//백준 2309 일곱 난쟁이 - 231026

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputList = new ArrayList<>(9);
        int sum=0;
        for(int i=0;i<9;i++){
            int input = Integer.parseInt(br.readLine());
            inputList.add(input);
            sum+=input;
        }

        for(int i=0;i<9;i++){
            for(int j=i+1;j<9;j++){
                if(sum-inputList.get(i)-inputList.get(j)==100){
                    inputList.remove(i);
                    inputList.remove(j-1);
                    break;
                }
            }
            if(inputList.size()==7) break;
        }
        Collections.sort(inputList);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Integer integer : inputList) bw.write(integer + "\n");

        bw.flush();
        bw.close();
    }
}