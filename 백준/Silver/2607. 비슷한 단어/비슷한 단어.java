import java.io.*;

class Main {
    static String word;
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        word = br.readLine();

        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'A';
            alphabet[idx]++;
        }

        int size=0;
        for(int i=0;i<n-1;i++){
            if(check( br.readLine())){
                size++;
            }
        }

        bw.write(size+"");
        bw.flush();
        bw.close();
    }
    static boolean check(String st){

        //길이가 1 이상 차이나면 불가능
        if(Math.abs(word.length() - st.length())>1) return false;

        return canMakeSame(st);
    }

    static boolean canMakeSame(String st){
        int[] words = alphabet.clone();
        int cnt=0;

        for(int i=0;i<st.length();i++){
            if(words[st.charAt(i) - 'A']>0){
                cnt++;
                words[st.charAt(i) - 'A']--;
            }
        }

        if(word.length() == st.length() && (word.length() == cnt || word.length() - 1 == cnt)) {
            return true;
        }
        else if(word.length() == st.length() - 1 && st.length() - 1 == cnt) {
            return true;
        }
        else if(word.length() == st.length() + 1 && st.length() == cnt) {
            return true;
        }
        return false;
    }
}