import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String s = br.readLine();
        int sum = 0;
        for(int i = 0 ; i < s.length(); i++){
            int c = (int)(s.charAt(i) - 'A');
            sum += findTime(c)+3;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private int findTime(int c){
        int[] number = {3,3,3,3,3,4,3,4};
        int sum = 0, i;
        for(i = 0 ; i < 9; i++){
            sum += number[i];
            if(c < sum) return i;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}