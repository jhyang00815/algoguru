import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;
import java.math.BigInteger;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언

        String num = br.readLine();
        String[] nums = num.split(" ");
        int n= Integer.parseInt(nums[0]);
        int r= Integer.parseInt(nums[1]);
        int c= Integer.parseInt(nums[2]);
        System.out.println(Z(n,r,c));
        //int A = Integer.parseInt(nums[0]);
        //int B = Integer.parseInt(nums[1]);
        //String num = br.readLine();
        //System.out.println(N-(2541-1998));
        //String[] nums = num.split(" ");
        //int B = Integer.parseInt(br.readLine());
    }
    public static int Z(int n, int r, int c) //2^n by 2^n 배열에서 (r,c)를 방문하는 순서 반환
    {
        if (n==0)
        {
            return 0;
        }
        else
        {
            int half = 1 << (n - 1);
            //문제 조건: r행 c열 (c,r)
            //0<=r,c<2^n
            if(c<half&&r<half) //(c,r)가 2사분면 (1번)
            {
                return Z(n-1,r,c); //1번 사각형의 안쪽에서 Z함수 돌리기.
            }
            else if (c>=half&&r<half)  //1사분면 (2번)
            {
                return half*half +Z(n-1,r,c-half);//1번전부 돌고나서+2번 사각형의 안쪽에서 Z함수 돌리기.(2번 사각형 기준 바뀐좌표 보정.)
            }
            else if (c<half&&r>=half)  //3사분면 (3번)
            {
                return 2*half*half +Z(n-1,r-half,c);
            }
            else //4사분면 (4번)
            {
                return 3*half*half +Z(n-1,r-half,c-half);
            }
        }

    }
}