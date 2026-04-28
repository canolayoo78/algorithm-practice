import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int BATTER = 9;
	static int pa[][];
	static int p[] = {1, 2, 3, 4, 5, 6, 7, 8}; 
	static int batters[] = new int[9];
	static int N, max = -1, score;
	
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		pa = new int[N][BATTER];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < BATTER; i++) {
				pa[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		batters[3] = 0;
		do {
			score = 0;
			setBattingOrder();
			gameStart();
			if (max < score) max = score;
		} while(getNextPerm());
		
		System.out.println(max);		
	}
	
	static boolean getNextPerm() {
		int i = BATTER-2;
		
		while(i > 0 && p[i-1] > p[i]) { i--;}
		
		if(i == 0) return false;
		
		int j = BATTER-2;
		
		while(p[i-1] > p[j]) { j--;}
		
		swap(i-1, j);
		
		int k = BATTER-2;
		while(i <= k) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	static void swap(int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}
	
	static void setBattingOrder() {
		for (int b = 0, i = 0; b < BATTER;) {
			if (b == 3) {
				b++; continue;
			}
			batters[b] = p[i];
			b++; i++;
		}
	}
	
	static void gameStart() {
		int nextBatter = 0;
		for (int i = 0; i < N; i++) {
			nextBatter = startInning(i, nextBatter);
		}
	}
	
	static int startInning(int inning, int atBat) {
		int outCnt = 0;
		int ground = 0;
		while (outCnt < 3) {
			int result = pa[inning][batters[atBat]];
			atBat = (atBat + 1) % BATTER;
			if (result == 0) {
				outCnt++;
				continue;
			}
			ground <<= result;
			ground |= 1 << (result-1);
			
			int scoreMasked = ground >> 3;
			score += Integer.bitCount(scoreMasked);
			ground &= 7;
		}
		return atBat;
	}
}
