import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, S;
	static int[][] stores;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(br.readLine());
		
		stores = new int[S + 1][2];
		for (int i = 0; i < S + 1; i++) {
			st = new StringTokenizer(br.readLine());
			stores[i][0] = Integer.parseInt(st.nextToken());
			stores[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for (int i = 0; i < S; i++) {
			ans+= getMinDist(i);
		}
		System.out.println(ans);
	}
	
	
	static int getMinDist(int i) {
		int tl, td, sl, sd;
		if (stores[i][0] > stores[S][0]) {
			tl = stores[S][0];
			td = stores[S][1];
			sl = stores[i][0];
			sd = stores[i][1];
		}
        else{
            tl = stores[i][0];
    		td = stores[i][1];
    		sl = stores[S][0];
    		sd = stores[S][1];
        }
		int dis = 0;
		if (tl == sl) {
			dis = Math.abs(td - sd);
		}
		else if ((sl <= 2 && tl <= 2)){
			if (td + sd > C) dis = 2 * C - (td + sd) + R;
			else dis = td + sd + R;
		}
		else if ((sl > 2 && tl > 2)){
			if (td + sd > R) dis = 2 * R - (td + sd) + C;
			else dis = td + sd + C;
		}
		else {
            if (tl == 1) {
				dis += sd;
			}
			else {
				dis += (R - sd);
			}
			
			if (sl == 3) {
				dis += td;
			}
			else {
				dis += (C - td);
			}
		}
		return dis;
	}
	
}
