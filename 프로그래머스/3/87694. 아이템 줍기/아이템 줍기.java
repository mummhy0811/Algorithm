import java.util.*;

class Solution {
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};
    static boolean[][] visit = new boolean[51][51];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX, characterY, 0});
        visit[characterX][characterY]=true;
        
        while(!queue.isEmpty()){
            
            int[] pos = queue.poll();
            int nowX = pos[0];
            int nowY = pos[1];
            int cnt = pos[2];
            
            for(int j=0;j<4;j++){
                boolean isValid = true;
                
                int nextX = nowX+moveX[j];
                int nextY = nowY+moveY[j];
                
                if(nextX<0 || nextY<0 || nextX>50 || nextY>50 || visit[nextX][nextY]) continue;
                int borderCnt = 0;
                boolean isInside = false;
                
                for(int i=0;i<rectangle.length;i++){
                    double midX = (nowX+nextX)/2.0;
                    double midY = (nowY+nextY)/2.0;
                                            
                    //누군가의 내부면 안 됨
                    if(checkInside(rectangle[i][0],rectangle[i][1], rectangle[i][2], rectangle[i][3], midX, midY)
                      || checkInside(rectangle[i][0],rectangle[i][1], rectangle[i][2], rectangle[i][3], nowX, nowY)
                      || checkInside(rectangle[i][0],rectangle[i][1], rectangle[i][2], rectangle[i][3], nextX, nextY)){
                        isInside = true;
                        break;
                    } 
                    //누군가의 테두리여ㅑ함
                    if(checkBorder(rectangle[i][0],rectangle[i][1], rectangle[i][2], rectangle[i][3], nextX, nextY) 
                       && checkBorder(rectangle[i][0],rectangle[i][1], rectangle[i][2], rectangle[i][3], midX, midY) 
                       && checkBorder(rectangle[i][0],rectangle[i][1], rectangle[i][2], rectangle[i][3], nextX, nextY)) {
                        borderCnt++;
                    }
                }

                if(isInside || borderCnt == 0) continue;
                
                if(nextX == itemX && nextY ==itemY) return cnt+1;
                
                visit[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY, cnt+1});
            }

        }
        
        return 0;
    }

    private static boolean checkInside(int lx, int ly, int rx, int ry, double x, double y){
        return x<rx && x>lx && y<ry && y>ly;
    }
    
    private static boolean checkBorder(int lx, int ly, int rx, int ry, double nx, double ny){
        return ((nx==lx || nx==rx) && (ny<=ry && ny>=ly)) || ((nx>lx && nx<rx) && (ny==ry || ny==ly));
    }
    
}