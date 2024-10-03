class Solution {
    static int x=0, y=0;
    public int[] solution(String command) {

        int head = 1; //1, 2, 3, 4 -> 위 오 아래 왼
        for(int i=0;i<command.length();i++){

            if(command.charAt(i)=='R'){
                if(head==4) head=1;
                else head++;
            }else if(command.charAt(i)=='L'){
                if(head==1) head=4;
                else head--;
            }else if(command.charAt(i)=='G'){
                move(head, 1);
            }else{
                move(head, -1);
            }
        }
        return new int[]{x, y};
    }
    private static void move(int head, int move){
        if(head==1){
            y+=move;
        }else if(head==2){
            x+=move;
        }else if(head==3){
            y-=move;
        }else{
            x-=move;
        }
    }
}