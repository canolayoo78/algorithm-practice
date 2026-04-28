import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuffer sb = new StringBuffer(input);

        String reverse = sb.reverse().toString();

        if (input.equals(reverse)) bw.write("1");
        else bw.write("0");

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}