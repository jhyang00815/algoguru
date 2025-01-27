import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    //-1 꺼진거 1 켜진거
    public static void toggleSwitchMan(int arr[],int n){
        for(int i=0;i<arr.length;i++){
            if((i+1)%n==0){
                if(arr[i]==1){
                    arr[i]=0;
                }else {
                    arr[i]=1;
                }
            }
        }
    }
    public static void toggleSwitchWoman(int arr[], int n) {
        int center = n - 1;
        int left = center;
        int right = center;
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }
        left++;
        right--;
        for (int i = left; i <= right; i++) {
            if(arr[i]==1){
                arr[i]=0;
            }else {
                arr[i]=1;
            }
        }
    }


    public static void printSwitch(int switchs[],int n)
    {
        for (int i = 0; i < (n + 19) / 20; i++) {
            int limit = Math.min(20, n - i * 20);
            for (int j = 0; j < limit; j++) {
                System.out.printf(switchs[i * 20 + j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        //System.out.println((8%20));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언
        int n=Integer.parseInt(br.readLine());
        int[] switches=new int[n];
        String switchNumString = br.readLine();
        String[] switchNum = switchNumString.split(" ");
        for (int i = 0; i < switches.length; i++) {
            switches[i] = Integer.parseInt(switchNum[i]);
        }
        //initializeSwitch(switches);
        int studentNum= Integer.parseInt(br.readLine());;
        for(int i=0;i<studentNum;i++){
            String nums = br.readLine();
            String[] num = nums.split(" ");
            if(Integer.parseInt(num[0])==1){
                toggleSwitchMan(switches,Integer.parseInt(num[1]));
            } else if (Integer.parseInt(num[0])==2) {
                toggleSwitchWoman(switches,Integer.parseInt(num[1]));
            }
        }
        for(int i=0;i<switches.length;i++){
            System.out.printf(switches[i]+" ");
            if((i+1)%20==0) System.out.println();
        }
    }
}
