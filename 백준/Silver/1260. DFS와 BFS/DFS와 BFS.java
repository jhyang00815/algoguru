//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void DFS(int[][] graph,int n, boolean[] visited){
        visited[n]=true;
        System.out.print(n+" ");
        //System.out.print(graph.length);
        for(int i=1;i<graph.length;i++){ //n이 계속 바뀌므로 i<n+1이 아니라 i<graph.length 로
            if(graph[n][i]==1 && !visited[i]){
                // DFS(graph,i,visited); //i를 그대로 넣어버리면 visited[i-1]에서 문제가 생긴다.
                DFS(graph,i,visited);
            }
        }
    }
    public static void BFS(int[][] graph,int n, boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        que.add(n);
        visited[n] = true;
        while(!que.isEmpty()){
            n=que.poll();
            System.out.print(n+" ");
            for(int i=1;i<graph.length;i++){
                if(graph[n][i]==1 && !visited[i]){
                    que.add(i);
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

        int[][] graph= new int[n+1][n+1];
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

