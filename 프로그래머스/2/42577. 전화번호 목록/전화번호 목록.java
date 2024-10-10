import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i=0;i<phone_book.length;i++){
            if(i+1<phone_book.length && phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
}