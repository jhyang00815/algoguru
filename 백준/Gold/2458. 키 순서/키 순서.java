import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm= br.readLine().split(" ");
		int n= Integer.parseInt(nm[0]);
		int m= Integer.parseInt(nm[1]);
		
		//int[][] map= new int[n][n];
		int[][] dist=new int[n][n];
		

		//플로이드 초기 거리 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
				if(i==j) 
					{
						dist[i][j]=0;
						continue;
				}
				dist[i][j]=100000000;
				
			}
		}
		
		for(int i=0;i<m;i++) {
			String[] link= br.readLine().split(" ");
			dist[Integer.parseInt(link[0])-1][Integer.parseInt(link[1])-1]=1;	
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		int count=0;
		
		for(int i=0;i<n;i++) {
			int cnt=0;
			for(int j=0;j<n;j++) {
				//System.out.print(dist[i][j]+" ");
				if(dist[i][j] <10000000||dist[j][i]<10000000) cnt++;
			}
			//System.out.println();
			if(cnt==n) count++;
		}
		
		
		System.out.println(count);
		
	}

}
