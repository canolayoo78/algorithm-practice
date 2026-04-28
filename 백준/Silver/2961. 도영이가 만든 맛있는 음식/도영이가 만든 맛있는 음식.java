import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] sour;
	static int[] bitter;
	static int N;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{	
		N = Integer.parseInt(br.readLine());
		sour = new int[N]; bitter = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0, 1, 0);
		System.out.println(min);
	}
	
	static void comb(int start, int depth, int s, int b) {
		if (depth == N) {
			if (b == 0) return;
			int temp = Math.abs(s - b);
			if (temp < min) min = temp;
			return;
		}
		comb(start + 1, depth + 1, s * sour[start], b + bitter[start]);
		comb(start + 1, depth + 1, s, b);
	}
}
