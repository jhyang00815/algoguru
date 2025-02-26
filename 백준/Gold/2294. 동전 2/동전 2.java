import java.util.*;

import static java.lang.Integer.parseInt;

import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));


        String[] nk= br.readLine().split(" ");
        int n= parseInt(nk[0]); //동전 종류 n가지
        int k= parseInt(nk[1]); //만들 액수 k

        int[] values=new int[n];
        int[] dp=new int[k+1];
        for(int i=0;i<n;i++) {
            values[i]=parseInt(br.readLine());
        }
        for(int i=0;i<k+1;i++) dp[i]=Integer.MAX_VALUE;
        dp[0]=0;
        for(int i=1;i<k+1;i++) {
            int min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                if(i-values[j]>=0)
                {
                    if(dp[i-values[j]]!=Integer.MAX_VALUE) min=Math.min(dp[i-values[j]], min);
                }
            }
            if(min!=Integer.MAX_VALUE&& min>=0)dp[i]=min+1;

        }
        if(dp[k]!=Integer.MAX_VALUE)System.out.println(dp[k]);
        else System.out.println(-1);
    }
}