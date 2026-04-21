import java.util.*;

class Solution {
    int N, maxSheep = -1; 
    int[] info;
    List<Integer> graph[];
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.N = info.length;
        graph = new ArrayList[N];
        
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges){
            int v = edge[0];
            int u = edge[1];
            
            graph[v].add(u);
        }
        
        Set<Integer> candidates = new HashSet<>();
        dfs(0, 1, 0, candidates);
        return maxSheep;
    }
    
    public void dfs(int now, int sheep, int wolf, Set<Integer> candidates){
        maxSheep = Math.max(maxSheep, sheep);
        
        for(int next: graph[now]){
            candidates.add(next);
        }
        
        // 후보들에 대해서
        for(int cand: candidates){
            // 이번에 가는 곳은 후보에서 빼고 진입
            Set<Integer> nextC = new HashSet<>(candidates);
            nextC.remove(cand);

            // 양이면 이동
            if (info[cand] == 0){
                dfs(cand, sheep + 1, wolf, nextC);
            }
            // 늑대면 개수 보고 이동
            else {
                if (sheep > wolf + 1){
                    dfs(cand, sheep, wolf + 1, nextC);
                }
            }
        }
            
    }
}