import java.util.*;
import java.io.*;

class Main {
    static int N, M, K, X;
    static List<List<Integer>> graph = new ArrayList<>();
    static Deque<State> q = new ArrayDeque<>();
    static List<Integer> answers = new ArrayList<>();
    static boolean visited[];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N+1];
        
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
        }
        bfs(X);
        if (answers.isEmpty()) {
            System.out.print(-1);
        }
        else{
            Collections.sort(answers);
            StringBuilder sb = new StringBuilder();
            for (int node : answers) {
                sb.append(node).append('\n');
            }
            System.out.print(sb);
        }        
    }

    static void bfs(int start){
        q.add(new State(start, 0));
        visited[start] = true;
        
        while(!q.isEmpty()){
            State cur = q.poll();
            int cNode = cur.node;
            int cCount = cur.count;
            if (cCount == K) {
                answers.add(cNode);
            }
            
            for (int next: graph.get(cNode)) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(new State(next, cCount + 1));
            }
        }
    }

    static boolean isValid(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < N;
    }
    
}

class State{
    int node;
    int count;

    State(int node, int count){
        this.node = node;
        this.count = count;
    }
}