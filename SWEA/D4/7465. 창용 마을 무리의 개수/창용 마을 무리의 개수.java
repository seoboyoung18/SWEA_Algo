import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution
{
    static int answer;
    static int[] parent;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			answer = 0;
			parent = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				parent[i] = i;
			}
			
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			for(int i=1; i<=N; i++) {
				if(parent[i] == i) {
					answer++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
			
		}//test
		System.out.println(sb);
	}//main

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) {
			parent[rootB] = rootA; 
		}
	}//union

	private static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}//find
}