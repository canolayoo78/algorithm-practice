import java.io.*;
import java.util.*;

public class Main{

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            s = s.toLowerCase();
            if(isGroupWord(s)) count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }

    private boolean isGroupWord(String s){
        boolean[] alphabet = new boolean[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i+1 < s.length() && c == s.charAt(i+1))
                continue;
            if(alphabet[(int)c-(int)'a']) return false;
            else alphabet[(int)c-(int)'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}