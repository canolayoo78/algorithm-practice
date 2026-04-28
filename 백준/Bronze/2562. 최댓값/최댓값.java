import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 1;
        int a, memory = 0;

        for(int i = 0; i < 9 ; i++){
            a = Integer.parseInt(br.readLine());
            if (a > max) {
                max = a;
                memory = i+1;
            }
        }

        bw.write(max+"\n"+memory);
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}