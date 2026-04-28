import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        
        int firstPlace = b%10;
        int secondPlace = (b%100)/10;
        int thirdPlace = b/100;
        bw.write(String.valueOf(a*firstPlace));
        bw.write('\n');
        bw.write(String.valueOf(a*secondPlace));
        bw.write('\n');
        bw.write(String.valueOf(a*thirdPlace));
        bw.write('\n');
        bw.write(String.valueOf(a*b));

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}