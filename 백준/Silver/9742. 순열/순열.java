import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {    //-1 꺼진거 1 켜진거

    public static int cnt=0;

    public static void charPermutation(char[] arr, char[] out,boolean[] visited, int depth,int targetNumber){
        if(depth==arr.length){
            //순열 완성됨.
            cnt++;
            if (cnt == targetNumber) {
                for (char c : arr) System.out.print(c);
                System.out.print(" " + targetNumber + " = ");
                for (int i = 0; i < depth; i++) System.out.print(out[i]);
                System.out.println();
            }
        }
        else{
            for(int i=0;i< arr.length;i++){
                if (!visited[i]){
                    visited[i]=true;
                    out[depth]=arr[i];
                    charPermutation(arr,out,visited,depth+1,targetNumber);
                    //back traverse
                    visited[i]=false;
                }
            }
        }
    }

    public static void permutation(int[] arr, int[] out,boolean[] visited, int depth,int targetNumber){
        if(depth==arr.length){
            cnt++;
            if (cnt == targetNumber) {
                for (int n : arr) System.out.print(n);
                System.out.print(" " + targetNumber + " = ");
                for (int i = 0; i < depth; i++) System.out.print(out[i]);
                System.out.println();
            }
        }
        else{
            for(int i=0;i< arr.length;i++){
                if (!visited[i]){
                    visited[i]=true;
                    out[depth]=arr[i];
                    permutation(arr,out,visited,depth+1,targetNumber);
                    //back traverse
                    visited[i]=false;
                }
            }
        }
    }
    public static int factorial(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        if (n==3) return 6;
        if (n==4) return 24;
        if (n==5) return 120;
        if (n==6) return 720;
        if (n==7) return 5040;
        if (n==8) return 40320;
        if (n==9) return 362880;
        if (n==10) return 3628800;
        else{
            return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        //System.out.println((8%20));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언
        StringTokenizer st;
        String testCase="";
        while((testCase = br.readLine())!=null){
            //String testCase = br.readLine();
            //if(testCase.isEmpty()||testCase==null)break;
            st = new StringTokenizer(testCase," ");
            if(!st.hasMoreTokens() ){
                return;
            }
            String[] testCaseString = testCase.split(" ");
            int num= testCaseString[0].length();
            int targetNumber=Integer.parseInt(testCaseString[1]);

            char[] out=new char[targetNumber];
            int[] digitOut= new int[targetNumber];
            boolean[] visited= new boolean[num];

            if(factorial(num)<targetNumber) {
                System.out.print(testCase+" = No permutation");
                System.out.println();
                continue;
            }

            if (testCaseString[0].matches("[a-zA-Z]+")){
                char[] charAlphabets=new char[num];
                //if(targetNumber>num)
                for(int i=0;i<num;i++) charAlphabets[i]=testCaseString[0].charAt(i);
                //알파벳인 경우
                charPermutation(charAlphabets,out,visited,0,targetNumber);
            }
            else {
                //숫자인 경우
                int[] digits=new int[num];
                for(int i=0;i<num;i++){
                    digits[i]=testCaseString[0].charAt(i)-'0';
                }
                permutation(digits,digitOut,visited,0,targetNumber);
            }

            cnt=0;
            Arrays.fill(visited, false);
        }

    }
}
