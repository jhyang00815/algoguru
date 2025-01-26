import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader 선언
        for(int i=0;i<4;i++) {
            String nums = br.readLine();
            String[] num = nums.split(" ");
            int ax = Integer.parseInt(num[0]);
            int ay = Integer.parseInt(num[1]);
            int ap = Integer.parseInt(num[2]);
            int aq = Integer.parseInt(num[3]);
            int bx = Integer.parseInt(num[4]);
            int by = Integer.parseInt(num[5]);
            int bp = Integer.parseInt(num[6]);
            int bq = Integer.parseInt(num[7]);

            if (ap < bx || bp < ax || bq < ay || aq < by) {
                System.out.println("d");
            } else if ((ap == bx && bq == ay) || (by == aq && ax == bp) || (ap == bx && aq == by) || (ax == bp && bq == ay)) {
                System.out.println("c");
            } else if (ap == bx || ax == bp || bq == ay || by == aq) {
                System.out.println("b");
            } else {
                System.out.println("a");
            }
        }
    }
}
