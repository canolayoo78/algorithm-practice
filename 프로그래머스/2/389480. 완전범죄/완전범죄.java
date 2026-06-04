import java.util.*;

class Solution {
    final int INF = 1_000_000_000;

    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m];

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] item : info) {
            int aEvidence = item[0];
            int bEvidence = item[1];

            int[] next = new int[m];
            Arrays.fill(next, INF);

            for (int b = 0; b < m; b++) {
                if (dp[b] == INF) continue;

                // A가 훔치는 경우
                int nextA = dp[b] + aEvidence;
                if (nextA < n) {
                    next[b] = Math.min(next[b], nextA);
                }

                // B가 훔치는 경우
                int nextB = b + bEvidence;
                if (nextB < m) {
                    next[nextB] = Math.min(next[nextB], dp[b]);
                }
            }

            dp = next;
        }

        int answer = INF;

        for (int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[b]);
        }

        return answer == INF ? -1 : answer;
    }
}