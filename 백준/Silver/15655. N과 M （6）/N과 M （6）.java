import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[] visited;
	static int[] nums;
	static int[] p;
	static int N, M;
	
	public static void main(String[] args) throws IOException{	
		st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		visited = new boolean[N];
		p = new int[M];
		
		perm(0, 0);
		System.out.println(sb);
	}
	
	static void perm(int start, int depth) {
		if (depth == M) {
			printPerm();
			return;
		}
		for (int i = start; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			p[depth] = nums[i];
			perm(i, depth + 1);
			visited[i] = false;
			p[depth] = 0;
		}
	}
	
	static void printPerm() {
		for (int i = 0; i < M; i++) {
			sb.append(p[i]).append(' ');
		}
		sb.append("\n");
	}
	
}