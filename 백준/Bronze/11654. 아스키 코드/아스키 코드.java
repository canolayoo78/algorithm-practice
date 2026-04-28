import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char c = br.readLine().charAt(0);
        int ascii = (int)c;
        bw.write(String.valueOf(ascii));

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}