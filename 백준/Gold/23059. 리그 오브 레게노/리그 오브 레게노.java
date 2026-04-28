import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<String> pQ = new PriorityQueue<>();
    static HashMap<String,Integer> nameToNum = new HashMap<String,Integer>();
    static HashMap<Integer,String> numToName = new HashMap<Integer,String>();
    static List<List<Integer>> graph = new ArrayList<>();
	static List<String> shoppingCart = new ArrayList<>();
    static int inDegrees[];
    static int N, itemCnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        inDegrees = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
			graph.add(new ArrayList<>());
		}
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String pre = st.nextToken();
        	String post = st.nextToken();
        	
        	int preNum = updateDictsWith(pre);
        	int postNum = updateDictsWith(post);
        	
        	graph.get(preNum).add(postNum);
        	inDegrees[postNum]++;        	
		}
        
        sortTopologically();
        System.out.println(sb);
	}
	
    static int updateDictsWith(String itemName) {
    	if (!nameToNum.containsKey(itemName)) {
    		nameToNum.put(itemName, itemCnt);
    		numToName.put(itemCnt, itemName);
    		itemCnt++;
    	}
    	return nameToNum.get(itemName);
    }
  
    static void sortTopologically() {
    	
    	for (int i = 0; i < itemCnt; i++) {
			if (inDegrees[i] == 0) {
				pQ.add(numToName.get(i));
			}
		}
    	
    	while (!pQ.isEmpty()) {
    		int qLen = pQ.size();
    		
    		for (int i = 0; i < qLen; i++) {
    			String nowName = pQ.poll();
        		int nowNum = nameToNum.get(nowName);
        		sb.append(nowName).append('\n');
        		
        		for (int nextNum: graph.get(nowNum)) {
        			inDegrees[nextNum]--;
        			if (inDegrees[nextNum] == 0) {
        				shoppingCart.add(numToName.get(nextNum));
        			}
        		}
			}
    		
    		for (String nextName: shoppingCart) {
				pQ.add(nextName);
			}
			shoppingCart.clear();
    	}
    	
    	for (int i = 0; i < itemCnt; i++) {
			if (inDegrees[i] != 0) {
				 sb.setLength(0);
				 sb.append(-1);
				 return;
			}
		}
    	
    	return;
    }
}

