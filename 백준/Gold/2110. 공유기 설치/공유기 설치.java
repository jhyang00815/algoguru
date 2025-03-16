import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] nc=br.readLine().split(" ");
		int n=parseInt(nc[0]);
		int c=parseInt(nc[1]);
		//int max=Integer.MIN_VALUE;
		long[] arr=new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Long.parseLong(br.readLine());
			//max=Math.max(max, arr[i]);
		}
		
		Arrays.sort(arr);
		
		long left=1; //가능한 최소치는 1.
		long right=arr[n-1]-arr[0]+1;
		
		
		
		while(left+1<right) {			
			long mid=(left+right)/2;			
			//공유기 설치 로직
			//주어진 거리를 지키면서 C개 이상의 공유기가 설치 가능한지 확인
			int cnt=1; //기본 1개는 설치됨
			long sum=0;
			for(int i=0;i<n-1;i++) { //순차로 돌면서 설치				
				if(sum+arr[i+1]-arr[i]>=mid) { //설치 가능하면
					cnt++;
					sum=0;
				}else {
					sum+=(arr[i+1]-arr[i]); //설치 안되면 넘겨서 거리를 벌려줌
				}
			}			
			if(cnt>=c) { //c개 이상 설치가능했다면 거리를 늘려줌
				left=mid;
			}else {
				right=mid;//설치를 못했다면 거리를 줄여줌
			}			
		}
		
		System.out.println(left);
	}

}
