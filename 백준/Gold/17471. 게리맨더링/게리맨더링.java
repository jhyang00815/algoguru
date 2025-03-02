import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
public class Main {
    //2^10가지 파악하고 전부 시도해보기...
    //비트마스킹ㄱㄱ
    //인접 행렬 쓰자...
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= parseInt(br.readLine());
        String[] population = br.readLine().split(" ");
        int[] populations= new int[n+1]; //1-index
        int[][] graph= new int[n+1][n+1]; //1-index

        Queue<Integer> qA= new ArrayDeque<>();
        Queue<Integer> qB= new ArrayDeque<>();
        List<Integer> listA= new ArrayList<>(); //방문처리 리스트
        List<Integer> listB= new ArrayList<>();
        for(int i=0;i<n;i++) populations[i+1]=parseInt(population[i]);
        for(int i=0;i<n;i++){
            String[] linkInfo= br.readLine().split(" ");
            int cnt= parseInt(linkInfo[0]);
            for(int j=1;j<=cnt;j++){
                graph[i+1][parseInt(linkInfo[j])]=1;
                graph[parseInt(linkInfo[j])][i+1]=1; //무방향 그래프
            }
        }

        for(int i=1;i<(1<<n)-1;i++){
            //System.out.println(1<<n+1);
            int populSumA=0;
            int populSumB=0;
            boolean[] visited=new boolean[n+1];
            boolean allConnected=true;
            for(int j=1;j<n+1;j++){
                if((i&(1<<(j-1)))!=0){ //j번째 수가 A 구획이면
                    listA.add(j);
                    //if(qA.isEmpty())qA.add(j);
                    populSumA+=populations[j];
                }else{ //B구획이면
                    listB.add(j);
                    //if(qB.isEmpty())qB.add(j);
                    populSumB+=populations[j];
                }
            }

            if(!listA.isEmpty()){
                qA.add(listA.get(0));
                visited[listA.get(0)]=true;
            }else allConnected=false;
            if(!listB.isEmpty()){
                qB.add(listB.get(0));
                visited[listB.get(0)]=true;
            }else allConnected=false;


            while(!qA.isEmpty()){
                int p= qA.poll();

                for(int node: listA){
                    //p와 listA속 노드 간 연결을 확인
                    if(graph[p][node]==1&&!visited[node]){
                        //연결된 경우
                        qA.add(node);
                        visited[node]=true;
                    }
                }
            }
            while(!qB.isEmpty()){
                int p= qB.poll();

                for(int node: listB){
                    //p와 listB속 노드 간 연결을 확인
                    if(graph[p][node]==1&&!visited[node]){
                        //연결된 경우
                        qB.add(node);
                        visited[node]=true;
                    }
                }
            }

            for(int k=1;k<n+1;k++){
                if(!visited[k]) {
                    allConnected=false;
                    break;
                }
            }
            if(allConnected) min=Math.min(Math.abs(populSumA-populSumB),min);
            listA.clear();
            listB.clear();
        }
        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}