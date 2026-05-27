import java.util.*;

class Solution {
    int[][] land;
    boolean[][] visited;
    Map<Integer, Integer> oilBlockSize = new HashMap<>();
    int R, C;
    
    int oilBlockCount = 1;
    boolean [] canPoll;
    
    
    public int solution(int[][] land) {
        R = land.length;
        C = land[0].length;
        
        this.land = land;
        this.visited = new boolean[R][C];
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (land[r][c] == 0) continue;
                if (visited[r][c]) continue;
                oilBlockSize.put(oilBlockCount, dfs(r, c, oilBlockCount));
                oilBlockCount++;
            }
        }
    
        canPoll = new boolean[oilBlockCount];
        int max = 0;
        for (int c = 0; c < C; c++) {
            max = Math.max(max, checkVertical(c));
        }
        
        return max;
    }
    
    
    int checkVertical(int c){
        Arrays.fill(canPoll, false);
        for (int r = 0; r < R; r++) {
            if (land[r][c] == 0) continue;
            canPoll[land[r][c]] = true;
        }
        
        int oil = 0;
        for (int i = 1; i < oilBlockCount; i++){
            if (canPoll[i]){
                oil += oilBlockSize.get(i);
            }
        }
        return oil;
    }
    
    int[] dr = {0, 0, 1, -1};
    int[] dc = {-1, 1, 0, 0};
    
    int dfs(int r, int c, int oilNum) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(r * C + c);
        land[r][c] = oilNum;
        visited[r][c] = true;
        int count = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            int cr = cur / C;
            int cc = cur % C;
            count++;
            
            for (int k = 0; k < 4; k++) {
                int nr = cr + dr[k];
                int nc = cc + dc[k];
                
                if (!isValid(nr, nc)) continue;
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                
                if (land[nr][nc] == 0) continue;
                
                land[nr][nc] = oilNum;
                q.add(nr * C + nc);
            }
        }
        return count;        
    }
    
    boolean isValid(int r, int c){
        return 0 <= r && r < R && 0 <= c & c < C;
    }
}