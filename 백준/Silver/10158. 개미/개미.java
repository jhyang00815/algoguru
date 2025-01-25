//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언
        String nums = br.readLine();
        String[] num = nums.split(" ");
        int w = Integer.parseInt(num[0]); //가로길이
        int h = Integer.parseInt(num[1]); //세로길이
        nums = br.readLine();
        num = nums.split(" ");
        int p = Integer.parseInt(num[0]); //초기 x좌표
        int q = Integer.parseInt(num[1]); //초기 y좌표
        int t= Integer.parseInt(br.readLine());

        int quotientX=(p+t)/w;
        int rX= (p+t)%w;
        int quotientY=(q+t)/h;
        int rY= (q+t)%h;

        if(quotientX%2==1) rX=w-rX;
        if(quotientY%2==1) rY=h-rY;



            // 2억 ->integer 범위
            //1초에 한 칸씩 옮기기 ->시간초과
            //일단 벽으로 땡겨온다->격자가 작으면 여전히 시간초과일 것 같다...
            //->아예 한번에 좌표를 구해야 할 것 같다.
            //How? x좌표, y좌표를 따로따로 구하면 편할 것 같다. 각각 상하로, 좌우로 왕복운동하는것처럼 된다.
            // 가로 세로 길이가 정해져있으므로 총 거리를 가로세로 길이로 나눈 나머지를 이용하면 될 것 같다.
            // 꼭지점에 튕겼을 경우: 도 예외는 아니다.

            //x축: (p+t)/w. 만약 몫이 홀수면 w-(나머지)가 좌표.
            //y축: (q+t)/w. 만약 몫이 홀수면 h-(나머지)가 좌표

        System.out.println(rX+" "+rY);
    }
}
