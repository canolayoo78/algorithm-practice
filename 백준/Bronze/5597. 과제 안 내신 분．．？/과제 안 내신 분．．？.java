import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int student[] = new int[30];
        int num;

        for(int i = 0; i < 28 ; i++) {
            num = Integer.parseInt(br.readLine());
            student[num-1] = 1;
        }

        for(int i = 0; i < 30 ; i++){
            if(student[i] == 0) bw.write(i+1+"\n");
        }

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}