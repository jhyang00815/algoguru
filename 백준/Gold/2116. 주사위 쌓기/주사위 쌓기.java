//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    public static int findMax(int[] arr, int idx1, int idx2){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i == idx1 ||i==idx2) continue;
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public static void main(String[] args) throws Exception {
        //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언
        int n= Integer.parseInt(br.readLine());
        int[][] dices= new int[n][6];
        for(int i=0;i<n;i++){
            String nums = br.readLine(); // 첫 번째 줄 입력
            String[] num = nums.split(" "); //입력한 줄 파싱
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(num[j]);
            }
        }
        int[] sums= new int[6];
        for(int j=0;j<6;j++) {
            int diceFace=dices[0][j]; //초기 윗면 설정
            if(j==0||j==5) sums[j] += findMax(dices[0], 0, 5);
            if(j==1||j==3) sums[j] += findMax(dices[0], 1, 3);
            if(j==2||j==4) sums[j] += findMax(dices[0], 2, 4);

            for (int i = 1; i < n; i++) {
                //다음 주사위 아랫면을 찾고 마주보는 윗면을 세팅
                for (int k=0;k<6;k++){
                    if(diceFace==dices[i][k]){
                        if(k==0) {
                            diceFace = dices[i][5];
                            sums[j] += findMax(dices[i], 0, 5);
                            break;
                        }
                        if(k==1) {
                            diceFace = dices[i][3];
                            sums[j] += findMax(dices[i], 3, 1);
                            break;
                        }
                        if(k==2) {
                            diceFace=dices[i][4];
                            sums[j] += findMax(dices[i], 4, 2);
                            break;
                        }
                        if(k==3) {
                            diceFace=dices[i][1];
                            sums[j] += findMax(dices[i], 1, 3);
                            break;
                        }
                        if(k==4) {
                            diceFace=dices[i][2];
                            sums[j] += findMax(dices[i], 4, 2);
                            break;
                        }
                        if(k==5) {
                            diceFace=dices[i][0];
                            sums[j] += findMax(dices[i], 0, 5);
                            break;
                        }
                    }
                }

            }
        }
        int max= Integer.MIN_VALUE;
        for(int i=0;i<6;i++){
            if(sums[i]>max) max=sums[i];
        }

        System.out.println(max);

    }
}