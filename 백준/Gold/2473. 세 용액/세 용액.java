import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= parseInt(br.readLine());
		long[] arr=new long[n];
		String[] info=br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i]=Long.parseLong(info[i]);
		}
		Arrays.sort(arr);
		
		int minIdxLeft=-1;
		int minIdxMid=-1;
		int minIdxRight=-1;
		
		//int left=0;
		//int right=n-1;
		
			
		long nearZero=Long.MAX_VALUE;
		
		for(int i=0;i<=n-3;i++) { //i=0~n-3까지 하나 선택			
			int left=i+1;
			int right=n-1;
			
			long sum=Long.MIN_VALUE;
			
			while(left<right) { //투포인터로 나머지 두 용액 찾기
				sum=arr[left]+arr[i]+arr[right];	
				if(Math.abs(nearZero)>Math.abs(sum)) {
					//System.out.println("갱신");
					nearZero=sum;
					minIdxLeft=left;
					minIdxMid=i;
					minIdxRight=right;
				}
				if(sum==0) break; //갱신 후 0이면 탈출
				else if(sum>0) { 
					right--;
				}else { 
					left++;
				}
			}
		}
			
		long[] ansArr=new long[3];
		ansArr[0]=arr[minIdxLeft];
		ansArr[1]=arr[minIdxMid];
		ansArr[2]=arr[minIdxRight];
		Arrays.sort(ansArr);
		System.out.println(ansArr[0]+" "+ansArr[1]+" "+ansArr[2]);

	}

}
