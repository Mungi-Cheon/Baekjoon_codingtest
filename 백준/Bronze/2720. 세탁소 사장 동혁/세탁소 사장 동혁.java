import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> CList = new ArrayList<>();
        while (T > 0) {
            int C = Integer.parseInt(br.readLine());
            CList.add(C);
            T--;
        }

        for (int C : CList) {
            int[] coinArray = new int[4];
            while (C > 0) {

                if (C >= 25) {
                    coinArray[0] = C / 25;
                    C = C % 25;
                } else if (C / 10 > 0) {
                    coinArray[1] = C / 10;
                    C = C % 10;
                } else if (C / 5 > 0) {
                    coinArray[2] = C / 5;
                    C = C % 5;
                } else {
                    coinArray[3] = C;
                    C = 0;
                }
            }
            for (int coin : coinArray) {
                System.out.print(coin + " ");
            }
            System.out.println();
        }
    }
}