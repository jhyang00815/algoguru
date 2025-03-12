import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
public class Main {
	static int L;
	static int C;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] lc= br.readLine().split(" ");
		L=parseInt(lc[0]);
		C=parseInt(lc[1]);
		
		char[] arr=new char[C];
		String[] chars= br.readLine().split(" ");
		
		for(int i=0;i<C;i++) {
			arr[i]=chars[i].charAt(0);
		}
		Arrays.sort(arr);
		boolean[] visited=new boolean[C];
		char[] out=new char[L];
		dfs(0,0,arr,out,visited);
	}
	static void dfs(int depth,int start,char[] arr,char[] out,boolean[] visited) {
		if(depth==L) {
			int zaum=0;
			int moum=0;
			for(int i=0;i<L;i++) {
				if(out[i]=='a'||out[i]=='e'||out[i]=='i'||out[i]=='o'||out[i]=='u') moum++;
				else zaum++;				
			}
			if(moum>=1&&zaum>=2) {				
				for(char c:out) System.out.print(c);
				System.out.println();
			}
			return;
		}
		for(int i=start;i<arr.length;i++) {
			
			if(!visited[i]) {
				out[depth]=arr[i];
				visited[i]=true;
				dfs(depth+1,i+1,arr,out,visited);
				visited[i]=false;
			}			
		
		}
		
	}
}
