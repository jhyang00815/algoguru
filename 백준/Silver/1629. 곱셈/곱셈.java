import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

public class Main
{
    static int s=0;
    static int count=0;
    static long out=1;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언

        String num = br.readLine();
        String[] nums = num.split(" ");
        long a= Long.parseLong(nums[0]);
        long b= Long.parseLong(nums[1]);
        long c= Long.parseLong(nums[2]);

        func(a,b,c);

        long d=out%c;
        System.out.println(d);
        //int A = Integer.parseInt(nums[0]);
        //int B = Integer.parseInt(nums[1]);
        //String num = br.readLine();
        //System.out.println(N-(2541-1998));
        //String[] nums = num.split(" ");
        //int B = Integer.parseInt(br.readLine());
    }
    public static void func(long a,long b,long c)
    {
        if(b==1)
        {
            out*=a%c;
            return;
        }
        else if(b%2==0)
        {
            func(a,b/2,c);
            out=(out*out)%c;
        }
        else
        {
            func(a,(b-1)/2,c);
            out=(out*out)%c;
            out=(out*a)%c;
        }
    }
}