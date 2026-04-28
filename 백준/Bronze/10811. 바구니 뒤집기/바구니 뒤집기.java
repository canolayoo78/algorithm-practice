import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static int box[] = new int[100];
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int s, e;
        int sum = 0;

        for(int i = 0; i < N; i++){
            box[i] = i+1;
        }

        for(int i = 0; i < M ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st2.nextToken());
            e = Integer.parseInt(st2.nextToken());

            change(s,e);

        }

        for(int i = 0; i < N ; i++){
            bw.write(box[i]+" ");
        }

        bw.flush();
    }
    private void change(int start,int end){
        int temp = box[start-1];
        box[start-1] = box[end-1];
        box[end-1] = temp;
        if(end - start > 1) change(start+1,end-1);
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}