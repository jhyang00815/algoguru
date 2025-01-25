import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void DFS(int[][] graph,int n, boolean[] visited){
        visited[n]=true; //방문처리
        System.out.print(n+" "); //방문 노드 출력
        //System.out.print(graph.length);
        for(int i=1;i<graph.length;i++){      //1부터 n까지 n개의 노드 전부 확인
                                              //(n이 계속 바뀌므로 i<n+1이 아니라 i<graph.length 로)
            if(graph[n][i]==1 && !visited[i]){ //노드 n과 연결되어있고 방문하지 않았다면                
                DFS(graph,i,visited);          //DFS 재귀 수행
            }
        }
    }
    public static void BFS(int[][] graph,int n, boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        que.add(n);   //큐에 노드 넣기
        visited[n] = true;  //노드 방문처리
        while(!que.isEmpty()){
            n=que.poll();    //방문한 노드 큐에서 제거
            System.out.print(n+" ");    //방문 노드 출력
            for(int i=1;i<graph.length;i++){
                if(graph[n][i]==1 && !visited[i]){    //노드 n과 연결되어있고 아직 방문 안했다면
                    que.add(i);                       //큐에 넣고 방문처리
                    visited[i] = true;                
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언

        String nums = br.readLine(); // 첫 번째 줄 입력
        String[] num = nums.split(" "); //입력한 줄 파싱
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);
        int v = Integer.parseInt(num[2]);

        int[][] graph= new int[n+1][n+1]; //n+1 X n+1 행렬로 생성(인덱스 n으로 접근)
        boolean[] visited= new boolean[n+1]; 
        for(int i=0;i<n+1;i++) {
            visited[i]=false; 
        }
        //graph initialize
        for(int i=0;i<m;i++){
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int w = Integer.parseInt(edge[1]);
            graph[u][w]=1;
            graph[w][u]=1;
        }
        DFS(graph,v,visited);
        System.out.println();
        for(int i=0;i<n+1;i++){
            visited[i]=false;
        }

        BFS(graph,v,visited);
    }
}
