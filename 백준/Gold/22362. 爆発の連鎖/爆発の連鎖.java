import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
public class Main {
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws Exception{

        //폭탄을 큐에 넣고 폭발시키자
        //W: width , H: height, N: 폭탄개수 D:폭발범위 B:최초로 폭발하는 폭탄의 번호
        //2행부터 이어지는 N행은 N개 폭탄의 위치.
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        while(true) {

            String[] WHNDB = br.readLine().split(" ");
            int w = parseInt(WHNDB[0]);
            int h = parseInt(WHNDB[1]);
            int n = parseInt(WHNDB[2]);
            int d = parseInt(WHNDB[3]);
            int b = parseInt(WHNDB[4]);
            if(w==0&&h==0&&n==0&&d==0&&b==0) return;
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            int[][] map = new int[h][w];
            Point[] positions = new Point[n];
            for (int i = 0; i < n; i++) positions[i] = new Point(0, 0);
            for (int i = 0; i < n; i++) {
                String[] pos = br.readLine().split(" ");
                positions[i].x = parseInt(pos[0]) - 1; //0-based index
                positions[i].y = parseInt(pos[1]) - 1; //0-based index
                map[positions[i].y][positions[i].x] = 1;
            }
            Queue<Point> q = new ArrayDeque<>();
            map[positions[b - 1].y][positions[b - 1].x] = 0;
            q.add(positions[b - 1]);
            int count = 1;
            while (!q.isEmpty()) {
                Point p = q.poll();
                for (int i = 1; i <= d; i++) {
                    for (int j = 0; j < 4; j++) {
                        int nx = p.x + i * dx[j];
                        int ny = p.y + i * dy[j];
                        if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                            if (map[ny][nx] == 1) {
                                q.add(new Point(nx, ny));
                                map[ny][nx] = 0;
                                count++;
                            }
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }
}