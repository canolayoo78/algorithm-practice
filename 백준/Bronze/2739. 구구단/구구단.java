import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= 9 ; i++){
            bw.write(a + " * " + i + " = " + a*i+"\n");
        }
        
        bw.flush();
    }


    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}