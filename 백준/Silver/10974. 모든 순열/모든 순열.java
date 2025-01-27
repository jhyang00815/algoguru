import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언
        int n = Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        int[] out= new int[n];
        boolean[] visited= new boolean[n];
        permutation(arr,out,0,n,0,visited);
    }
    public static void permutation(int[] arr,int[]out,int start,int n,int depth,boolean[] visited){
        if(depth==n){
            for(int i=0;i<n;i++){
                System.out.printf(out[i]+" ");
            }
            System.out.println();
        }else{
            for(int i=start;i<n;i++){
                if(!visited[i]){
                    visited[i]=true;
                    out[depth]=arr[i];
                    permutation(arr,out,0,n,depth+1,visited);
                    visited[i]=false;
                }
            }
        }

    }
}
