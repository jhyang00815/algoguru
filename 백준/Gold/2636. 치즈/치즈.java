import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
public class Main {

	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int h;
	static int w;
	static boolean[][] visited;
	
	static int[][] map;
	public static void main(String[] args) throws Exception{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] hw= br.readLine().split(" ");
		h=parseInt(hw[0]);
		w=parseInt(hw[1]);
		int temp=0;
		map= new int[h][w];
		
		for(int i=0;i<h;i++) {
			String[] mapInfo=br.readLine().split(" "); 
			for(int j=0;j<w;j++) {
				map[i][j]=parseInt(mapInfo[j]);
			}
		}
		
		int initCheese=0;
		for(int i=0;i<h;i++) {				 
			for(int j=0;j<w;j++) {
				if(map[i][j]==1) initCheese++;
			}
		} //이전치즈 계산
		
		int time=0;
		while(true) {
			time++;
			visited=new boolean[h][w];
			
			for(int i=0;i<h;i++) {
				bfs(0,i);
				bfs(w-1,i);
			}
			for(int i=0;i<w;i++) {
				bfs(i,0);
				bfs(i,h-1);
			}
			//공기 visited끝

			
			
			
			int cnt=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {	
				
				if(map[i][j]==0&&visited[i][j]) {
						for(int dir=0;dir<4;dir++) {
							int nx=j+dx[dir];
							int ny=i+dy[dir];
							if(nx>=0&&ny>=0&&nx<w&&ny<h) {
								map[ny][nx]=0;
							}
						}						
					}
				}
			}

			//이 시점에 all 0이면 break; 걸어야 됨.
			int cheese=0;
			for(int i=0;i<h;i++) {				 
				for(int j=0;j<w;j++) {
					if(map[i][j]==1) cheese++;
				}
			} //이전치즈 계산
			
			
			if(cheese==0) {
				System.out.println(time);
				if(time==1) System.out.println(initCheese);
				else System.out.println(temp);
				
				break;
			}		
			
			
//			for(int i=0;i<h;i++) {				 
//				for(int j=0;j<w;j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			} //이전치즈 계산
			temp=cheese;
			
			
		}
		
		
		
		
		
	}

	static void bfs(int x, int y) {
		Queue<Point> q=new ArrayDeque<Point>();
		q.offer(new Point(x,y));
		//if(x==0||y==0||x==w-1||y==h-1) isAdj=true;
		visited[y][x]=true;
		while(!q.isEmpty()) {	
			Point p=q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx=p.x+dx[dir];
				int ny=p.y+dy[dir];
				if(nx>=0&&ny>=0&&nx<w&&ny<h) {
					if(!visited[ny][nx]&&map[ny][nx]==0) {
						q.offer(new Point(nx,ny));
						visited[ny][nx]=true;
					}
				}
			}	
		}
	}
}
