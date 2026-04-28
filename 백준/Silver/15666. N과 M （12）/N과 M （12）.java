import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] nums;
	static int[] p;
	static int N, M;
	
	public static void main(String[] args) throws IOException{	
		st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		p = new int[M];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		perm(0, 0);
		System.out.println(sb);
	}
	
	static void perm(int start, int depth) {
		if (depth == M) {
			printPerm();
			return;
		}
		int check = 0;
		for (int i = start; i < N; i++) {
			if (check == nums[i]) continue;
			p[depth] = nums[i];
			check = nums[i];
			perm(i, depth + 1);
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