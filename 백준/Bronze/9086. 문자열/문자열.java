import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T ; i++){
            String S = br.readLine();
            bw.write(String.valueOf(S.charAt(0)));
            bw.write(S.charAt(S.length()-1)+"\n");
        }

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}