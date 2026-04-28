
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dishes;
	static int[] dishCnt;
	static int N, d, k, c;
	static int cnt = 1;
	static int max;
	
	public static void main(String[] args) throws IOException{	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		dishes = new int[N + k];
		dishCnt = new int[d + 1];
		
		for (int i = 0; i < N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
        
		dishCnt[c] = 1;
		for (int i = 0; i < k; i++) {
            dishes[N + i] = dishes[i];
			if(dishCnt[dishes[i]] == 0) {
				cnt ++;
			}
			dishCnt[dishes[i]]++;
		}
		max = cnt;
		for (int s = 1, i = 0; s < N; s++, i++) {
			int j = i + k;
			if (dishes[i] == dishes[j]) continue;
			dishCnt[dishes[i]]--;
			dishCnt[dishes[j]]++;
			if (dishCnt[dishes[i]] == 0) {
				cnt--;
			}
			if (dishCnt[dishes[j]] == 1) {
				cnt++;
			}
			if (max < cnt) {
				max = cnt;
			}
		}
		System.out.println(max);
	}	
}