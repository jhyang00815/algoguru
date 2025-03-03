//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
public class Main {
    static class Subject{
        int number;
        int term;

        public Subject(int number, int term) {
            this.number = number;
            this.term = term;
        }
    }
    static void putEdge(ArrayList<ArrayList<Integer>> graph, int x, int y ){
        graph.get(x).add(y);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n= parseInt(nm[0]);
        int m= parseInt(nm[1]);

        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 그래프 초기화
            graph.add(new ArrayList<>());
        }


        int[] subjects= new int[n+1];// 1-index
        int[] indegree= new int[n+1];
        for(int i=1;i<n+1;i++) subjects[i]=1; //subject배열을 미리 두고 putedge

        for(int i=0;i<m;i++){
            String[] ab = br.readLine().split(" ");
            int a=parseInt(ab[0]);
            int b=parseInt(ab[1]);
            putEdge(graph,a,b);
        }

        for(int i=1;i<n+1;i++){
            //indegree 배열 채우기
            for(int s : graph.get(i)){
                indegree[s]++;
            }
        }

        //Queue<Subject> q= new ArrayDeque<>();
        Queue<Integer> q= new ArrayDeque<>();
        for(int i=1;i<n+1;i++){
            if(indegree[i]==0){
                //자기를 가리키는 게 아무것도 없는 것 큐에 넣자...
                q.add(i);

                //System.out.println(i);
            }
        }
        while(!q.isEmpty()){
            int p= q.poll();
            for(int sub: graph.get(p)){
                subjects[sub]= subjects[p]+ 1;
                indegree[sub]--;
                if(indegree[sub]==0) q.add(sub);
            }
        }

        for(int i=1;i<n+1;i++){
            System.out.print(subjects[i]+" ");
        }

    }
}