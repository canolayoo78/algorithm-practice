import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] chess = br.readLine().split(" ");
        int[] piece = {1, 1, 2, 2, 2, 8};

        for(int i = 0; i < 6; i++){
            int a = Integer.parseInt(chess[i]);
            bw.write(piece[i]-a+" ");
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}