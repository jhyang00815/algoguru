//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
public class Main {

    static int n,m,h;
    static int time=0;
    static class tomato{
        int x;
        int y;
        int z;
        boolean isRotten;
        int time;

        public tomato(int x, int y ,int z,int time,boolean isRotten) {
            this.x = x;
            this.y = y;
            this.z= z;
            this.time = time;
            this.isRotten=isRotten;
        }
    }
    public static void main(String[] args) throws Exception{
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] nmh= br.readLine().split(" ");
        m= parseInt(nmh[0]);
        n= parseInt(nmh[1]);
        h= parseInt(nmh[2]);
        int[] dx={1,-1,0,0,0,0};
        int[] dy={0,0,1,-1,0,0};
        int[] dz={0,0,0,0,1,-1};
        int[][][] map= new int[h][n][m];
        Queue<tomato> q= new ArrayDeque<>();
        boolean notYetDone=false;
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                String[] tomatos= br.readLine().split(" ");
                for(int k=0;k<m;k++){
                    map[i][j][k]=parseInt(tomatos[k]);
                    if(map[i][j][k]==1){
                        q.add(new tomato(k,j,i,0,true));
                    }
                    if(map[i][j][k]==0) notYetDone=true;
                }
            }
        }
        while(!q.isEmpty()){
            tomato pick=q.poll();
            for(int dir=0;dir<6;dir++){
                int nx=pick.x+dx[dir];
                int ny=pick.y+dy[dir];
                int nz=pick.z+dz[dir];
                if(isIn(nx,ny,nz)){
                    if(map[nz][ny][nx]==0){
                        map[nz][ny][nx]=1;
                        q.add(new tomato(nx,ny,nz,pick.time+1,true));
                    }
                }
            }
            time=pick.time;
        }
        boolean fail=false;



        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){

                    if(map[i][j][k]==0) fail=true;
                }
            }
        }

        if(!notYetDone) System.out.println(0);
        else if (fail) System.out.println(-1);
        else System.out.println(time);
    }
    static boolean isIn(int x,int y, int z){
        if(x>=0&&x<m&&y>=0&&y<n&&z>=0&&z<h) return true;
        else return false;
    }

}