import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        Map<String, Integer> words = new HashMap<>();

        for(int i=0;i<n;i++){
            String word = br.readLine();
            if(words.containsKey(word)) words.replace(word, words.get(word)+1);
            else if(word.length()>=m) words.put(word, 1);
        }

        Map<Integer, List<String>> list = new HashMap<>();


        for (String key : words.keySet()) {
            if(list.containsKey(words.get(key))){
                List<String> sameFrequencyWords = list.get(words.get(key));
                sameFrequencyWords.add(key);
            }else{
                List<String> l = new ArrayList<>();
                l.add(key);
                list.put(words.get(key), l);
            }
        }


        for(int i:list.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())){
            List<String> wordList=list.get(i);
            if(wordList.size()==1) {
                bw.write(wordList.get(0)+"\n");
            }
            else{
                wordList.stream().sorted(
                        Comparator.comparing(String::length,Comparator.reverseOrder())
                                .thenComparing(String::toString)).forEach(s -> {
                    try {
                        bw.write(s+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        bw.flush();
        bw.close();
    }
}