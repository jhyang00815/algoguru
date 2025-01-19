import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;
import java.math.BigInteger;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언

        int n = Integer.parseInt(br.readLine());
        BigInteger moves = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
        System.out.println(moves);

        if (n<=20) hanoi(1,3,n);


        //int A = Integer.parseInt(nums[0]);
        //int B = Integer.parseInt(nums[1]);
        //String num = br.readLine();
        //System.out.println(N-(2541-1998));
        //String[] nums = num.split(" ");
        //int B = Integer.parseInt(br.readLine());
    }
    public static void hanoi(int start,int end,int n)
    {
        //n번째원반 :start ->end
        //1~n-1번째 원반까지 :start ->mid
        //start,end 번호를 제외한 기둥의 번호는 6-start-end
        if(n==1)
        {
            System.out.println(start+" "+end);
            //out+=1; //hanoi(1)의 1회 카운트. 2^(n)-1로 답은 대체할것임
            return;
        }
        else
        {
            hanoi(start,6-start-end,n-1); //n-1개의 원반을 start->mid로 옮기기
            System.out.println(start+" "+end); //n번째 원반을 start->end로 옮기기
            //out+=1; //n번째 원반 옮긴 1회 카운트. 2^(n)-1로 답을 대체할것임
            hanoi(6-start-end,end,n-1); //n-1개의 원반을 mid->end로 옮기기
        }
    }
}