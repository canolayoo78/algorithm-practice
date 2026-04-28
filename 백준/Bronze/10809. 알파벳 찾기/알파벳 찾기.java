import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s= br.readLine();
        for( int i = 0 ; i < 26 ; i++){
            char c = (char)(97+i);
            bw.write(s.indexOf(c)+" ");
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}