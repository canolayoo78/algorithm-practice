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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int box[] = new int[N];
        int a,b,temp;

        for(int i = 0; i < N ; i++) {
            box[i] = i + 1;
        }

        for(int i = 0; i < M ; i++){
            StringTokenizer Reader = new StringTokenizer(br.readLine());
            a = Integer.parseInt(Reader.nextToken());
            b = Integer.parseInt(Reader.nextToken());

            temp = box[a-1];
            box[a-1] = box[b-1];
            box[b-1] = temp;
        }

        for(int i = 0; i < N; i++){
            bw.write(box[i]+" ");
        }

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}