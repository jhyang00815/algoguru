import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;

public class Main {
    public static void main(String[] args) throws IOException{
        //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언
        String nums = br.readLine();
        String[] num = nums.split(" ");
        int n = Integer.parseInt(num[0]);
        int k = Integer.parseInt(num[1]);
        String temps = br.readLine();
        String[] tempSarr = temps.split(" ");
        int[] tempArr=new int[n];
        int[] window=new int[k];
        for(int i=0;i<n;i++){
            tempArr[i]=Integer.parseInt(tempSarr[i]);
        }
        int maxSum=MIN_VALUE;

        for(int i=0;i<n-k+1;i++){
            int localSum=0;
            for(int j=0;j<k;j++){
                window[j]=tempArr[i+j];
                localSum+=window[j];
            }
            if(localSum>maxSum) maxSum=localSum;

        }

        System.out.println(maxSum);

    }
}