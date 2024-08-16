import java.util.*;

class Solution {
    static boolean[][] visit;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static List<Set<Integer>> myGroup;
    static List<Integer> groups;
    static int height, width;
    
    public static int solution(int[][] land) {

        width = land[0].length;
        height = land.length;

        visit = new boolean[height][width];

        myGroup = new ArrayList<>();
        groups = new ArrayList<>();

        for(int i=0;i<=width;i++){
            myGroup.add(new HashSet<>());
        }
        
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(!visit[i][j] && land[i][j]==1){
                    int size=1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});

                    while(!queue.isEmpty()){
                        int now[] = queue.poll();
                        int nowX = now[0];
                        int nowY = now[1];

                        visit[nowX][nowY]=true;
                        Set<Integer> set = myGroup.get(nowY);
                        set.add(groups.size());
                        myGroup.set(nowY, myGroup.get(nowY));
                        
                        for(int z=0;z<4;z++){
                            int nextX = nowX+moveX[z];
                            int nextY = nowY+moveY[z];

                            if(nextX<0 || nextX >= height || nextY<0 || nextY>=width || visit[nextX][nextY] || land[nextX][nextY]==0) continue;


                            queue.add(new int[]{nextX, nextY});
                             visit[nextX][nextY]=true;
                             size++;

                        }
                    }
                    groups.add(size);
                }
            }
        }

        //찾아

        int maxSize = 0;
        for(int i=0;i<width;i++){

            Iterator iter = myGroup.get(i).iterator();
            int size=0;
            while(iter.hasNext()){
                size+=groups.get((Integer) iter.next());
            }
            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }
}