import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int durabilities[], weights[];
	static int N, max = 0;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		durabilities = new int[N];
		weights = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			durabilities[i] = Integer.parseInt(st.nextToken());
			weights[i] = Integer.parseInt(st.nextToken());
		}
		
		crashEgg(0, 0);
		System.out.println(max);
	}
	
	static void crashEgg(int hold, int crashed) {
		if (hold == N){
			if (max < Integer.bitCount(crashed)) {
				max = Integer.bitCount(crashed);
			}
			return;
		}
		if ((crashed & 1 << hold) != 0) {
			crashEgg(hold + 1, crashed);
		}
		else { 
			int holdD = durabilities[hold];
			boolean canCrash = false;
			
			for (int select = 0; select < N; select++) {
				if (select == hold) continue;
				
				if ((crashed & 1 << select) != 0) continue;
				
				canCrash = true;
				
				int selectD = durabilities[select];
				int crashedNow = crashed;
				
				durabilities[hold] -= weights[select];
				durabilities[select] -= weights[hold];
				
				if (durabilities[hold] <= 0) {
					crashedNow |= 1 << hold;
				}
				if (durabilities[select] <= 0) {
					crashedNow |= 1 << select;
				}
				
				crashEgg(hold + 1, crashedNow);
				
				durabilities[hold] = holdD;
				durabilities[select] = selectD;	
			}
			
			if (!canCrash) {
				crashEgg(hold + 1, crashed);
			}
		}
		
	}	
	
}
