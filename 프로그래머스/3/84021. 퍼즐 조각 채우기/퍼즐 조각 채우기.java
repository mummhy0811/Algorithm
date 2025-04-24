import java.util.*;

class Solution {
    static int[][] gameBoard, table;
    static int len, count;
    static Map<Integer, List<int[][]>> puzzles;
    static int[] mr = {1, 0, -1, 0};
    static int[] mc = {0, 1, 0, -1};
    
    public int solution(int[][] game_board, int[][] _table) {
        count = 0;
        gameBoard = game_board;
        table = _table;
        len = game_board.length;
        
        //칸별로 차지하는 빈칸을 줄세우고
        puzzles = new HashMap<>();
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(table[i][j] == 1) savePuzzles(i, j);
            }
        }
        
        // 맵에서 빈칸을 만날 때마다 해당 넓이에 해당하는 블록들을 찾아서 채운다.
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(game_board[i][j]==0) find(i, j);
            }
        }
        
        return count;
    }

    
    static void savePuzzles(int sr, int sc){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        table[sr][sc] = -1;
        
        int sum = 1;
        int minR = sr, maxR = sr, minC = sc, maxC = sc;
        
        //보드 빈칸 넓이와 영역 구하기
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            
            for(int i=0;i<4;i++){
                int nr = r+mr[i];
                int nc = c+mc[i];
                
                if(nr<0 || nc<0 || nr>=len || nc>=len || table[nr][nc]!=1) continue;
                
                table[nr][nc] = -1;
                queue.add(new int[]{nr, nc});
                sum++;
                
                minR = Math.min(minR, nr);
                minC = Math.min(minC, nc);
                maxR = Math.max(maxR, nr);
                maxC = Math.max(maxC, nc);
            }
            
        }
        
        List<int[][]> infos = puzzles.getOrDefault(sum, new ArrayList<>());
        int[][] tmp = new int[maxR-minR+1][maxC-minC+1];
        
        int height = maxR - minR + 1;
        
        for(int i=0;i<height;i++){
            tmp[i] = Arrays.copyOfRange(table[minR+i], minC, maxC+1);
        }
        
        infos.add(tmp);
        puzzles.put(sum, infos);
    }
    
    static void find(int sr, int sc){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        gameBoard[sr][sc] = -1;
        
        int sum = 1;
        int minR = sr, maxR = sr, minC = sc, maxC = sc;
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            
            for(int i=0;i<4;i++){
                int nr = r+mr[i];
                int nc = c+mc[i];
                
                if(nr<0 || nc<0 || nr>=len || nc>=len || gameBoard[nr][nc]!=0) continue;
                
                gameBoard[nr][nc] = -1;
                queue.add(new int[]{nr, nc});
                sum++;
                
                minR = Math.min(minR, nr);
                minC = Math.min(minC, nc);
                maxR = Math.max(maxR, nr);
                maxC = Math.max(maxC, nc);
            }
            
        }
        
        
        int area = (maxR-minR+1)*(maxC-minC+1);
        
        //맞는 퍼즐 찾기
        List<int[][]> puzzle = puzzles.get(sum);
        
        if(puzzle == null) return;
        
        for(int i=0;i<puzzle.size();i++){
            int[][] p = puzzle.get(i);
            
            if(area == p.length*p[0].length){
                int[][] rotated = p;
                
                for(int j=0;j<4;j++){
                    if(j!=0) rotated = rotate(rotated);
                    
                    if(isFit(minR, maxR, minC, maxC, rotated)){
                        puzzle.remove(i);
                        puzzles.put(sum, puzzle);
                        count+=sum;
                        return;
                    }
                }
            }
        }
    }
    
    static boolean isFit(int minR, int maxR,int minC,int maxC,int[][] p){
        
        int width = maxC - minC + 1;
        int height = maxR - minR + 1;
        
        if(width != p[0].length || height != p.length) return false;
    
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(gameBoard[minR + i][minC + j] == -1 ){
                    if(p[i][j]!=-1) return false;
                }
            }
        }

        
        return true;
    }
    
    static int[][] rotate(int[][] tmp){ // 우회전 
        int height = tmp.length;
        int width = tmp[0].length;
        int[][] newTable = new int[width][height];

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                newTable[j][height - 1 - i] = tmp[i][j];
            }
        }

        return newTable;
    }

}
