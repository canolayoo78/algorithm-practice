import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{	
		int K = Integer.parseInt(br.readLine());
		int[][] inputs = new int[6][2];
		int dir, dirH = 0, dirV = 0;
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			if (dir > 2)
				dirH ^= dir;
			else
				dirV ^= dir;	
			inputs[i][0] = dir;
			inputs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int smallWidth = 0, smallHeight = 0, largeWidth = 0, largeHeight = 0;
		
		for (int i = 0; i < 6 ; i++) {
			if ((inputs[i][0] == dirH && inputs[(i+1)%6][0] == dirV) ||
				(inputs[i][0] == dirV && inputs[(i+1)%6][0] == dirH)){
				largeHeight = inputs[i][1];
				largeWidth = inputs[(i+1)%6][1];
				smallWidth = inputs[(i+3)%6][1];
				smallHeight = inputs[(i+4)%6][1];
				break;
			}
		}
		
		System.out.print((largeWidth * largeHeight - smallWidth * smallHeight) * K);
	}
}
