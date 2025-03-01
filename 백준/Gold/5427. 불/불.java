//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
public class Main {

    static class Point{

        int x;
        int y;
        int time;
        boolean isSangeun;
        public Point(int x, int y, int time, boolean isSangeun) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isSangeun=isSangeun;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] wh = br.readLine().split(" ");
            int w = parseInt(wh[0]);
            int h = parseInt(wh[1]);
            char[][] map = new char[h][w];
            boolean[][] fireVisited = new boolean[h][w];
            boolean[][] sangeunVisited = new boolean[h][w];
            boolean canExit = false;
            Queue<Point> q = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@') {
                        if (j == 0 || j == w - 1 || i == 0 || i == h - 1) {
                            System.out.println(1);
                            canExit = true;
                        }
                        q.add(new Point(j, i, 1, true));
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '*') q.add(new Point(j, i, 1, false));
                }
            }

            while (!q.isEmpty() && !canExit) {
                Point p = q.poll();

                if (p.isSangeun) {
                    if (map[p.y][p.x] == '.' || map[p.y][p.x] == '@') {
                        sangeunVisited[p.y][p.x] = true;
                        if (p.x == 0 || p.x == w - 1 || p.y == 0 || p.y == h - 1){
                            System.out.println(p.time);
                            canExit=true;
                            break;
                        }
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = p.x + dx[dir];
                            int ny = p.y + dy[dir];

                            if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                                if (map[ny][nx] == '.' && !sangeunVisited[ny][nx]) { //탈출구 바로 앞이면 그냥 나와버림

                                    q.add(new Point(nx, ny, p.time + 1, true));
                                    sangeunVisited[ny][nx] = true;

                                }
                            }
                        }
                    }
                } else {
                    fireVisited[p.y][p.x] = true;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = p.x + dx[dir];
                        int ny = p.y + dy[dir];

                        if (nx >= 0 && ny >= 0 && nx < w && ny < h && !fireVisited[ny][nx]) {
                            if (map[ny][nx] == '.') {
                                q.add(new Point(nx, ny, p.time + 1, false));
                                map[ny][nx] = '*';
                                fireVisited[ny][nx] = true;
                            }
                        }
                    }
                }
            }

            if (!canExit) System.out.println("IMPOSSIBLE");
        }
    }

}



