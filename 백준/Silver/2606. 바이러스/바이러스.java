import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {    //-1 꺼진거 1 켜진거

    public static int cnt=0;


    public static void main(String[] args) throws IOException {
        //System.out.println((8%20));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언

        int n = Integer.parseInt(br.readLine());

        int[][] matrix= new int[n+1][n+1];
        boolean[] visited=new boolean[n+1];
        boolean[] isInfected=new boolean[n+1];
        isInfected[1]=true;

        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++) { //매트릭스 초기화
            String readLine= br.readLine();
            String[] uv = readLine.split(" ");
            int u= Integer.parseInt(uv[0]);
            int v= Integer.parseInt(uv[1]);
            matrix[u][v]=1;
            matrix[v][u]=1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
    while(!q.isEmpty()){
        int node=q.poll(); //큐에서 꺼낸다.
        visited[node]=true;
        for(int j=1;j<n+1;j++){
            if(matrix[node][j]==1 && !visited[j]){
                q.add(j);
                if(isInfected[node]) isInfected[j]=true;
            }
        }
    }
    for(int i=1;i<n+1;i++) if (isInfected[i]) cnt++;
    System.out.println(cnt-1);

    }
}
