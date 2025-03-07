import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n = parseInt(br.readLine());
		int[] arr= new int[n];
		String[] nums= br.readLine().split(" ");
		HashMap<Integer, Integer> hMap=new HashMap<>();
		
		for(int i=0;i<n;i++) {
			arr[i]=parseInt(nums[i]);	
			
			if(hMap.containsKey(arr[i])) {
				hMap.put(arr[i], hMap.get(arr[i])+1);
			}else {
				hMap.put(arr[i], 1);
			}
		}

		
		int m=parseInt(br.readLine());
		
		int[] mArr=new int[m];
		
		String[] nums2= br.readLine().split(" ");
		
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<m;i++) {
			int target= parseInt(nums2[i]);
			
			if(hMap.get(target)!=null)sb.append(hMap.get(target)+" ");	
			else sb.append("0 ");
		}
		System.out.println(sb.toString());
		
	}

}
