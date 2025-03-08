//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
public class Main {
    public static void main(String[] args)  throws Exception{
        //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n= parseInt(br.readLine());

            if(n>=4){
                int[] dp=new int[n+1]; //dp: n을 1,2,3의 합으로 나타내는 방법의 수
                dp[1]=1;
                dp[2]=2;
                dp[3]=3;
                for(int i=4;i<=n;i++){
                    dp[i]=dp[i-3]+i/2+1;
                }
                System.out.println(dp[n]);
            }
            else if (n==3) System.out.println(3);
            else if (n==2) System.out.println(2);
            else if (n==1) System.out.println(1);
        }
    }
}