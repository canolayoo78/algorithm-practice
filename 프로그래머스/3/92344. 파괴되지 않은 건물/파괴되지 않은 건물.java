class Solution {
    int N, M;
    int[][] diff, board;
        
    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        this.board = board;
        
        diff = new int[N+1][M+1];
            
        for(int[] line : skill){
            update(line);
        }
        
        calcPrefix();
        
        int answer = countRemain();
        
        return answer;
    }
    
    void update(int[] line){
        int degree = line[5];
        int r1 = line[1], c1 = line[2], r2 = line[3], c2 = line[4];
        if (line[0] == 1){
            degree = -degree;
        }
        diff[r1][c1] += degree;
        diff[r1][c2 + 1] -= degree;
        diff[r2 + 1][c1] -= degree;
        diff[r2 + 1][c2 + 1] += degree;        
    }
    
    void calcPrefix(){
        for (int c = 0; c < M; c++){
            for (int r = 1; r < N; r++){
                diff[r][c] += diff[r-1][c];
            }
        }

        for (int r = 0; r < N; r++){
            for (int c = 1; c < M; c++){
                diff[r][c] += diff[r][c-1];
            }
        }
    }
    
    int countRemain(){
        int ans = 0;
         for (int r = 0; r < N; r++){
            for (int c = 0; c < M; c++){
                if (board[r][c] + diff[r][c] > 0 ){
                    ++ans;
                }
            }
         }
        return ans;
    }
}