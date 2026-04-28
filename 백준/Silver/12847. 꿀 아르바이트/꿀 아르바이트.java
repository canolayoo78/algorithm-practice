import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[] wages;
	
	public static void main(String[] args) throws IOException{	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		wages = new int[N];
		for (int i = 0; i < N; i++) {
			wages[i] = Integer.parseInt(st.nextToken());
		}
		
		long subSum = 0;
		for (int i = 0; i < M; i++) {
			subSum += wages[i];
		}
		
		long max = subSum;
		for (int i = 0; i < N - M; i++) {
			subSum -= wages[i];
			subSum += wages[i + M];
			if (max < subSum) max = subSum;
		}
		System.out.println(max);
	}
}
