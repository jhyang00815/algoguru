import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {    //-1 꺼진거 1 켜진거

    public static int cnt = 0;


    public static void main(String[] args) throws IOException {
        //System.out.println((8%20));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언
        int[] dwarf= new int[9];
        for(int i=0;i<9;i++){
            int n = Integer.parseInt(br.readLine());
            dwarf[i]=n;
        }
        Arrays.sort(dwarf);
        int sum=0;
        for (int i:dwarf) sum+=i;

        int left=0;
        int right=8;
        int antiSum= sum-100;
        while(left!=right){
            if(dwarf[left]+dwarf[right]==antiSum) {
                break;
            } else if (dwarf[left]+dwarf[right]>antiSum) {
                right--;
            }else left++;
        }
        for(int i=0;i<9;i++){
            if(i!=left && i!=right) System.out.println(dwarf[i]);
        }


    }
}
