import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] num = br.readLine().split(" ");
        int num1 = reverse(num[0]);
        int num2 = reverse(num[1]);

        if (num1>num2)    bw.write(String.valueOf(num1));
        else bw.write(String.valueOf(num2));

        bw.flush();
    }

    private int reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length(); i > 0 ; i--){
            sb.append(s.charAt(i-1));
        }
        return Integer.parseInt(String.valueOf(sb));
    }
    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}