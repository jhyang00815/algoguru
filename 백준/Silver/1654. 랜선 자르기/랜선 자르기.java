import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] kn= br.readLine().split(" ");
		int k=parseInt(kn[0]);
		int n=parseInt(kn[1]);
		long[] lan=new long[k];
		for(int i=0;i<k;i++) {
			lan[i]=Long.parseLong(br.readLine());
		}
		
		long left=1;
		long right= (1L<<31);	
		//System.out.println(right+10000);
		long mid=(left+right)/2; //랜선의 길이 찾기.
		while(left+1<right) {
			//Checklist
			//1. Check(left) =T, Check(right)=F를 만족하는가?
			//2. left는 정답이 될 수 있는 모든 범위를 나타낼 수 있는가?
			mid=(left+right)/2;
			//Check함수 시작
			long count=0;
			for(int i=0;i<k;i++) {
				count+=(lan[i]/mid);  //0으로 나눠버리는 경우 방지해야됨.
			}			
			//Check함수 결과 카운트가 n 이상인 경우(T),미만인경우(F)
			//길이에 따른 결정 분포는 TTTTTTT...TTFF..F 이다. 
			if(count>=n) { //n 이상인 경우->길이를 키워야된다.
				left=mid;
			}
			if(count<n) { //n개보다 적게 만들어진 경우 길이를 줄여야된다.
				right=mid;
			}
				
		}
		
		System.out.println(left); //경계의 왼쪽이 T
		
		
		
		}		

}


