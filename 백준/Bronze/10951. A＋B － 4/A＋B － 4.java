import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        String str;
        int a = 1, b = 1;

        while((str=br.readLine()) != null){
            st = new StringTokenizer(str," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write((a+b)+"\n");
        }
        
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}