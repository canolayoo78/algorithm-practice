import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static List<List<Integer>> smaller = new ArrayList<>();
    static List<List<Integer>> taller = new ArrayList<>();
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            smaller.add(new ArrayList<>());
            taller.add(new ArrayList<>());
        }
        
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int small = Integer.parseInt(st.nextToken());
            int tall = Integer.parseInt(st.nextToken());
            smaller.get(small).add(tall);
            taller.get(tall).add(small);
        }
        
        int ans = 0;
        for (int i = 1; i <= N; i ++) {
            int total = 0;
            total += bfs(smaller, i);
            total += bfs(taller, i);
            if (total == N-1){
                ans ++;
            }
        }

        System.out.println(ans);
    }

    static int bfs(List<List<Integer>> graph, int start){
        Deque<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean [N+1];
        q.offer(start);
        visited[start] = true;
        int known = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(next);
                known ++;
            }
        }
        
        return known;
    }
}