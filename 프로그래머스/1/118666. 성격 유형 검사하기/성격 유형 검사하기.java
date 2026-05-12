import java.util.*;

class Solution {
    char[][] categories = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    HashMap<Character, Integer> scores = new HashMap<>();
    
    int N;
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        this.N = survey.length;
        
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 2; j++){
                scores.put(categories[i][j], 0);
            }
        }
        
        for (int i = 0; i < N; i++){
            int c = choices[i];
            
            if (c == 4) continue;
            if (c > 4) {
                char element = survey[i].charAt(1);
                scores.put(element, scores.get(element) + c - 4);
            }
            else {
                char element = survey[i].charAt(0);
                scores.put(element, scores.get(element) + 4 - c);
            }
        }
        
        for (char[] category: categories){
            int firstScore = scores.get(category[0]);
            int secondScore = scores.get(category[1]);
            if (firstScore >= secondScore){
                answer += category[0];
            }
            else{
                answer += category[1];
            }
        }
        
        return answer;
        
    }
}