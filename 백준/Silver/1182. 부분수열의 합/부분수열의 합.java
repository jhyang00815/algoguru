import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    static int s=0;
    static int count=0;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언

        String num = br.readLine();
        String[] nums = num.split(" ");
        int n= Integer.parseInt(nums[0]);
        s= Integer.parseInt(nums[1]);
        String numberStr = br.readLine();
        String[] numbersStr = numberStr.split(" ");
        int[] numbers= new int[n];
        for (int i=0;i<n;i++)
        {
            numbers[i]= Integer.parseInt(numbersStr[i]);
            //System.out.print(numbers[i]+" ");
        }

        for (int r = 1; r <= n; r++)
        {
            int[] out= new int[r];
            Combination(numbers, n, r, 0, 0,out);
        }
        System.out.println(count);
        //int A = Integer.parseInt(nums[0]);
        //int B = Integer.parseInt(nums[1]);
        //String num = br.readLine();
        //System.out.println(N-(2541-1998));
        //String[] nums = num.split(" ");
        //int B = Integer.parseInt(br.readLine());
    }
    public static void Combination(int[] arr,int n,int r, int start, int depth,int[] out)
    {

        if(depth==r)
        {
            int sum=0;
            for(int i: out) sum+=i;
            if (sum==s) count+=1;

            return;
        }
        else
        {
            for(int i=start;i<n;i++)
            {
                out[depth]=arr[i];
                Combination(arr,n,r,i+1,depth+1,out);
            }
        }

    }
}