import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
public class Main {
	static int[][] map;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int n;
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int size;
		int time;
		int exp;
		public Point(int x, int y, int size, int time,int exp) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.time = time;
			this.exp=exp;
		}
		@Override
		public int compareTo(Point o) {
			if(this.time!=o.time) return this.time-o.time;
			if(this.y!=o.y) return this.y-o.y;
			return this.x-o.x;
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		n=parseInt(br.readLine());
		map=new int[n][n];
		//boolean[][] visited=new boolean[n][n];
		int sx=-1,sy=-1;
		for(int i=0;i<n;i++) {
			String[] mapInfo=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j]=parseInt(mapInfo[j]);
				if(map[i][j]==9) {
					sx=j;
					sy=i;
					map[i][j]=0;
				}
			}
		}
		PriorityQueue<Point> q= new PriorityQueue<Point>(); //거리와 좌표 순서로 우선순위 큐를 만들어야 함.
		
		q.offer(new Point(sx,sy,2,0,0));		
		int move=0;
		int size=2;
		int exp=0;
		while(true) {//상어가 먹이를 다 먹을때까지 이동을 계속해야 함	
			boolean[][] visited=new boolean[n][n];
			q.clear();
			q.offer(new Point(sx,sy,size,0,exp));
			visited[sy][sx]=true;
			
			PriorityQueue<Point> fishList=new PriorityQueue<>();
			
            while (!q.isEmpty()) {
                Point p = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = p.x + dx[dir];
                    int ny = p.y + dy[dir];

                    if (isIn(nx, ny) && !visited[ny][nx] && map[ny][nx] <= p.size) {
                        visited[ny][nx] = true;
                        q.offer(new Point(nx, ny, p.size, p.time + 1, p.exp));

                        if (map[ny][nx] > 0 && map[ny][nx] < p.size) {
                            fishList.offer(new Point(nx, ny, p.size, p.time + 1, p.exp));
                        }
                    }
                }
            }
			if(fishList.isEmpty()) break;
			
			Point fish=fishList.poll();
			move+=fish.time;
			sx=fish.x;
			sy=fish.y;
			map[sy][sx]=0;
			exp+=1;
			if(exp==size) {
				size+=1;
				exp=0;
			}		
			
		}
		System.out.println(move);
		 
	}
	static boolean isIn(int x, int y) {
		return x>=0&&y>=0&&x<n&&y<n;
	}

}
